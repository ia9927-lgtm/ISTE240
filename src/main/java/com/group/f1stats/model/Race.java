// Adil Nurmagambetov UID:415002457
package com.group.f1stats.model;

import jakarta.persistence.*;

@Entity
@Table(name = "races")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="grandPrixName", length = 100, nullable = false)
    private String grandPrixName;
    @Column(name="Circuit", length = 100, nullable = false)
    private String circuit;
    @Column(name="Country", length = 100, nullable = false)
    private String country;
    @Column(name="RaceDate", length = 100, nullable = false)
    private String raceDate;
    @Column(name="Season", nullable = false)
    private int season;

    public Race() {
    }

    public Race( String grandPrixName, String circuit,
                String country, String raceDate, int season) {
        this.grandPrixName = grandPrixName;
        this.circuit = circuit;
        this.country = country;
        this.raceDate = raceDate;
        this.season = season;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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