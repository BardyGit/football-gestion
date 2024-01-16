package com.example.teamservice.beans;

import com.example.playerservice.bean.Player;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description = "Team details with name and coach information")
public class Team {

    @ApiModelProperty(notes = "Unique identifier of the team")
    private Long id;
    @ApiModelProperty(notes = "Name of the team")
    private String name;
    @ApiModelProperty(notes = "Coach of the team")
    private String coach;
    @ApiModelProperty(notes = "List of players")
    private List<Player> players;

    // Constructeurs, getters et setters

    public Team() {
    }

    public Team(Long id, String name, String coach, List<Player> players) {
        this.id = id;
        this.name = name;
        this.coach = coach;
        this.players = players;
    }

    // Getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
