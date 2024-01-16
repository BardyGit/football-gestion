package com.example.statsservice.bean;

public class TeamStats {
    private Long teamId;
    private int matchesPlayed;
    private int wins;
    private int draws;
    private int losses;
    private int goalsFor;
    private int goalsAgainst;

    // Constructors, getters, and setters

    public TeamStats() {
    }

    public TeamStats(Long teamId, int matchesPlayed, int wins, int draws, int losses, int goalsFor, int goalsAgainst) {
        this.teamId = teamId;
        this.matchesPlayed = matchesPlayed;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
    }

    // Getters and setters
    public Long getTeamId(){
        return teamId;
    }

    public void setTeamId(Long teamId){
        this.teamId = teamId;
    }

    public int getMatchesPlayed(){
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed){
        this.matchesPlayed = matchesPlayed;
    }

    public int getWins(){
        return wins;
    }

    public void setWins(int wins){
        this.wins = wins;
    }

    public int getDraws(){
        return draws;
    }

    public void setDraws(int draws){
        this.draws = draws;
    }

    public int getLosses(){
        return losses;
    }

    public void setLosses(int losses){
        this.losses = losses;
    }

    public int getGoalsFor(){
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor){
        this.goalsFor = goalsFor;
    }

    public int getGoalsAgainst(){
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst){
        this.goalsAgainst = goalsAgainst;
    }
}
