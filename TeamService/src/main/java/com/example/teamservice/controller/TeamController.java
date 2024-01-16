package com.example.teamservice.controller;

import com.example.teamservice.beans.Team;
import com.example.playerservice.bean.Player;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Api(description = "Operations related to teams")
@RestController
@RequestMapping("/teams")
public class TeamController {

    private final List<Team> teams = new ArrayList<>();
    private long nextId = 1;


    private RestTemplate restTemplate;

    public TeamController() {
        restTemplate = new RestTemplate();
    }

    {
        // Initialisation des équipes avec des joueurs fictifs
        teams.add(new Team(nextId++, "Team A", "Coach A", List.of(new Player(1L,1,"Player A1", 22,"Forward"))));
        teams.add(new Team(nextId++, "Team B", "Coach B", List.of(new Player(2L,2,"Player B1",20, "Midfielder"))));
        teams.add(new Team(nextId++, "Team C", "Coach C", List.of(new Player(3L,3,"Player C1", 22,"Defender"))));
    }
    @HystrixCommand(fallbackMethod = "getTeamByIdFallback")
    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable Long id) {
        return teams.stream()
                .filter(team -> team.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Fallback method
    public Team getTeamByIdFallback(Long id) {
        // Créer une équipe par défaut avec des valeurs spécifiques
        return new Team(-1L, "Default Team", "Default Coach", List.of(new Player(-1L,-1,"Default Player", 0, "Default Position")));
    }

    @ApiOperation(value = "Get all teams", notes = "Returns all teams")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Successfully retrieved all teams"),
                    @ApiResponse(code = 401, message = "Unauthorized access"),
                    @ApiResponse(code = 403, message = "Forbidden access"),
                    @ApiResponse(code = 404, message = "Teams not found")
            }
    )

    @PostMapping
    public Team addTeam(@RequestBody Team team) {
        team.setId(nextId++);
        teams.add(team);
        return team;
    }

    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable Long id, @RequestBody Team updatedTeam) {
        for (int i = 0; i < teams.size(); i++) {
            Team team = teams.get(i);
            if (team.getId().equals(id)) {
                updatedTeam.setId(id);
                teams.set(i, updatedTeam);
                return updatedTeam;
            }
        }
        return null; // Return appropriate response for non-existing team
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id) {
        teams.removeIf(team -> team.getId().equals(id));
    }

    @GetMapping("/{id}/players")
    public ResponseEntity<List<Player>> getPlayersByTeamId(@PathVariable Long id) {
        String playerServiceUrl = "http://localhost:8092/players/{teamId}";

        // Utiliser ParameterizedTypeReference pour spécifier le type de réponse
        ResponseEntity<List<Player>> responseEntity = restTemplate.exchange(
                playerServiceUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Player>>() {},
                id
        );

        List<Player> players = responseEntity.getBody();
        return ResponseEntity.ok(players);
    }
}
