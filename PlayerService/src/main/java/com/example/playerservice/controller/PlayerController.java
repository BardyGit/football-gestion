package com.example.playerservice.controller;


import com.example.playerservice.bean.Player;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final List<Player> players = new ArrayList<>();
    private long nextId = 1;

    public PlayerController() {
        players.add(new Player(nextId++,1, "Player A", 20, "Position A"));
        players.add(new Player(nextId++, 1,"Player B", 21, "Position B"));
        players.add(new Player(nextId++, 2,"Player C", 22, "Position C"));
        players.add(new Player(nextId++, 3,"Player D", 23, "Position D"));
        players.add(new Player(nextId++, 3,"Player E", 24, "Position E"));
    }

    @GetMapping("/{id}")
    @HystrixCommand(fallbackMethod = "getPlayerByIdFallback")
    public Player getPlayerById(@PathVariable Long id) {
        return players.stream()
                .filter(player -> player.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Fallback method
    public Player getPlayerByIdFallback(Long id) {
        // Créer un joueur par défaut avec des valeurs spécifiques
        return new Player(-1L, -1, "Default Player", 0, "Default Position");
    }

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        player.setId(nextId++);
        players.add(player);
        return player;
    }

    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable Long id, @RequestBody Player updatedPlayer) {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.getId().equals(id)) {
                updatedPlayer.setId(id);
                players.set(i, updatedPlayer);
                return updatedPlayer;
            }
        }
        return null; // Return appropriate response for non-existing player
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id) {
        players.removeIf(player -> player.getId().equals(id));
    }
}
