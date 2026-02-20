package com.group.f1stats.model;

import org.springframework.stereotype.Component;

@Component
public class Race {

    private int id;
    private String grandPrixName;
    private String circuit;
    private String country;
    private String raceDate;
    private int season;

    public Race() {
    }

    public Race(int id, String grandPrixName, String circuit,
                String country, String raceDate, int season) {
        this.id = id;
        this.grandPrixName = grandPrixName;
        this.circuit = circuit;
        this.country = country;
        this.raceDate = raceDate;
        this.season = season;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrandPrixName() {
        return grandPrixName;
    }

    public void setGrandPrixName(String grandPrixName) {
        this.grandPrixName = grandPrixName;
    }

    public String getCircuit() {
        return circuit;
    }

    public void setCircuit(String circuit) {
        this.circuit = circuit;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRaceDate() {
        return raceDate;
    }

    public void setRaceDate(String raceDate) {
        this.raceDate = raceDate;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", grandPrixName='" + grandPrixName + '\'' +
                ", circuit='" + circuit + '\'' +
                ", country='" + country + '\'' +
                ", raceDate='" + raceDate + '\'' +
                ", season=" + season +
                '}';
    }
}