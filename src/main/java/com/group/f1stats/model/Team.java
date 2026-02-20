package com.group.f1stats.model;

import org.springframework.stereotype.Component;

@Component
public class Team {

    private int id;
    private String name;
    private String nationality;
    private String principal;
    private int championshipsWon;

    public Team() {
    }

    public Team(int id, String name, String nationality,
                String principal, int championshipsWon) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.principal = principal;
        this.championshipsWon = championshipsWon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public int getChampionshipsWon() {
        return championshipsWon;
    }

    public void setChampionshipsWon(int championshipsWon) {
        this.championshipsWon = championshipsWon;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", principal='" + principal + '\'' +
                ", championshipsWon=" + championshipsWon +
                '}';
    }
}