package com.example.matchservice.bean;
public class Match {
    private Long id;
    private String team1;
    private String team2;
    private int scoreTeam1;
    private int scoreTeam2;

    // Constructors, getters, and setters
    public Match() {
    }

    public Match(Long id, String team1, String team2, int scoreTeam1, int scoreTeam2) {
        this.id = id;
        this.team1 = team1;
        this.team2 = team2;
        this.scoreTeam1 = scoreTeam1;
        this.scoreTeam2 = scoreTeam2;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeam1(){
        return team1;
    }

    public void setTeam1(String team1){
        this.team1 = team1;
    }

    public String getTeam2(){
        return team2;
    }

    public void setTeam2(String team2){
        this.team2 = team2;
    }

    public int getScoreTeam1(){
        return scoreTeam1;
    }

    public void setScoreTeam1(int scoreTeam1){
        this.scoreTeam1 = scoreTeam1;
    }

    public int getScoreTeam2(){
        return scoreTeam2;
    }

    public void setScoreTeam2(int scoreTeam2){
        this.scoreTeam2 = scoreTeam2;
    }
}
