package com.example.playerservice.bean;

public class Player {
    private Long id;
    private int teamId;
    private String name;
    private int age;
    private String position;

    // Constructors, getters, and setters

    public Player() {
    }

    public Player(Long id,int teamId, String name, int age, String position) {
        this.id = id;
        this.teamId = teamId;
        this.name = name;
        this.age = age;
        this.position = position;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTeamId(){
        return teamId;
    }

    public void setTeamId(int teamId){
        this.teamId = teamId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getPosition(){
        return position;
    }

    public void setPosition(String position){
        this.position = position;
    }
}
