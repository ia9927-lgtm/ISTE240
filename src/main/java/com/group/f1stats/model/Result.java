// Adil Nurmagambetov UID:415002457
package com.group.f1stats.model;

import jakarta.persistence.*;

@Entity
@Table(name="results")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="raceID")
    private Race race;

    @ManyToOne
    @JoinColumn(name="driverID")
    private Driver driver;

    @Column(name="finishingPosition", nullable = false)
    private Integer finishingPosition;

    @Column(name="pointsEarned", nullable = false)
    private Integer pointsEarned;

    @Column(name="fastestLapTime", length = 100)
    private String fastestLapTime;

    public Result() {}

    public Result(Race race, Driver driver,
                  Integer finishingPosition, Integer pointsEarned, String fastestLapTime) {
        this.race = race;
        this.driver = driver;
        this.finishingPosition = finishingPosition;
        this.pointsEarned = pointsEarned;
        this.fastestLapTime = fastestLapTime;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Race getRace() { return race; }
    public void setRace(Race race) { this.race = race; }
    public Driver getDriver() { return driver; }
    public void setDriver(Driver driver) { this.driver = driver; }
    public Integer getFinishingPosition() { return finishingPosition; }
    public void setFinishingPosition(Integer finishingPosition) { this.finishingPosition = finishingPosition; }
    public Integer getPointsEarned() { return pointsEarned; }
    public void setPointsEarned(Integer pointsEarned) { this.pointsEarned = pointsEarned; }
    public String getFastestLapTime() { return fastestLapTime; }
    public void setFastestLapTime(String fastestLapTime) { this.fastestLapTime = fastestLapTime; }
}