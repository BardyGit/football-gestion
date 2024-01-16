package com.example.matchservice.controller;

import com.example.matchservice.bean.Match;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    private final List<Match> matches = new ArrayList<>();
    private long nextId = 1;

    {
        matches.add(new Match(nextId++, "Manchester United", "Liverpool", 2, 1));
        matches.add(new Match(nextId++, "Manchester City", "Chelsea", 1, 1));
        matches.add(new Match(nextId++, "PSG", "Arsenal", 3, 1));
        matches.add(new Match(nextId++, "Tottenham", "Bayern", 2, 2));
    }

    @GetMapping("/{id}")
    @HystrixCommand(fallbackMethod = "getMatchByIdFallback")
    public Match getMatchById(@PathVariable Long id) {
        return matches.stream()
                .filter(match -> match.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Fallback method
    public Match getMatchByIdFallback(Long id) {
        // Créer un match par défaut avec des valeurs spécifiques
        return new Match(-1L, "Default Team A", "Default Team B", 0, 0);
    }

    @PostMapping
    public Match addMatch(@RequestBody Match match) {
        match.setId(nextId++);
        matches.add(match);
        return match;
    }

    @PutMapping("/{id}")
    public Match updateMatch(@PathVariable Long id, @RequestBody Match updatedMatch) {
        for (int i = 0; i < matches.size(); i++) {
            Match match = matches.get(i);
            if (match.getId().equals(id)) {
                updatedMatch.setId(id);
                matches.set(i, updatedMatch);
                return updatedMatch;
            }
        }
        return null; // Return appropriate response for non-existing match
    }

    @DeleteMapping("/{id}")
    public void deleteMatch(@PathVariable Long id) {
        matches.removeIf(match -> match.getId().equals(id));
    }
}
