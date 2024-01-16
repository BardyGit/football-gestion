package com.example.statsservice.bean;

public class PlayerStats {
    private Long playerId;
    private int matchesPlayed;
    private int goalsScored;
    private int assists;
    private int yellowCards;
    private int redCards;

    // Constructors, getters, and setters

    public PlayerStats() {
    }

    public PlayerStats(Long playerId, int matchesPlayed, int goalsScored, int assists, int yellowCards, int redCards) {
        this.playerId = playerId;
        this.matchesPlayed = matchesPlayed;
        this.goalsScored = goalsScored;
        this.assists = assists;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
    }

    // Getters and setters
    public Long getPlayerId(){
        return playerId;
    }

    public void setPlayerId(Long playerId){
        this.playerId = playerId;
    }

    public int getMatchesPlayed(){
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed){
        this.matchesPlayed = matchesPlayed;
    }

    public int getGoalsScored(){
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored){
        this.goalsScored = goalsScored;
    }

    public int getAssists(){
        return assists;
    }

    public void setAssists(int assists){
        this.assists = assists;
    }

    public int getYellowCards(){
        return yellowCards;
    }

    public void setYellowCards(int yellowCards){
        this.yellowCards = yellowCards;
    }

    public int getRedCards(){
        return redCards;
    }

    public void setRedCards(int redCards){
        this.redCards = redCards;
    }
}
