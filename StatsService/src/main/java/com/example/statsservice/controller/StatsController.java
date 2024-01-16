package com.example.statsservice.controller;

import com.example.statsservice.bean.PlayerStats;
import com.example.statsservice.bean.TeamStats;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class StatsController {

    private final List<TeamStats> teamStatsList = new ArrayList<>();
    private final List<PlayerStats> playerStatsList = new ArrayList<>();

    // Initialisation de quelques statistiques de team
    {
        teamStatsList.add(new TeamStats(1L, 10, 7, 2, 1, 25, 10));
        teamStatsList.add(new TeamStats(2L, 12, 8, 3, 1, 30, 12));
        teamStatsList.add(new TeamStats(3L, 11, 6, 4, 1, 22, 15));
    }

    // Initialisation de quelques statistiques de joueur
    {
        playerStatsList.add(new PlayerStats(1L, 8, 5, 3, 2, 0));
        playerStatsList.add(new PlayerStats(2L, 10, 8, 4, 1, 0));
        playerStatsList.add(new PlayerStats(3L, 9, 3, 6, 0, 1));
    }

    @GetMapping("/team-stats/{teamId}")
    public TeamStats getTeamStats(@PathVariable Long teamId) {
        return teamStatsList.stream()
                .filter(playerStats -> playerStats.getTeamId().equals(teamId))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/player-stats/{playerId}")
    public PlayerStats getPlayerStats(@PathVariable Long playerId) {
        return playerStatsList.stream()
                .filter(playerStats -> playerStats.getPlayerId().equals(playerId))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/player-stats")
    public List<PlayerStats> getPlayerStats() {
        return playerStatsList;
    }
}

