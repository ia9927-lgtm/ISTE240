package com.group.f1stats.model;

public class Result {

    private int id;
    private Race race;
    private Driver driver;
    private int finishingPosition;
    private int pointsEarned;
    private String fastestLapTime;

    public Result() {}

    public Result(int id, Race race, Driver driver,
                  int finishingPosition, int pointsEarned, String fastestLapTime) {
        this.id = id;
        this.race = race;
        this.driver = driver;
        this.finishingPosition = finishingPosition;
        this.pointsEarned = pointsEarned;
        this.fastestLapTime = fastestLapTime;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Race getRace() { return race; }
    public void setRace(Race race) { this.race = race; }
    public Driver getDriver() { return driver; }
    public void setDriver(Driver driver) { this.driver = driver; }
    public int getFinishingPosition() { return finishingPosition; }
    public void setFinishingPosition(int finishingPosition) { this.finishingPosition = finishingPosition; }
    public int getPointsEarned() { return pointsEarned; }
    public void setPointsEarned(int pointsEarned) { this.pointsEarned = pointsEarned; }
    public String getFastestLapTime() { return fastestLapTime; }
    public void setFastestLapTime(String fastestLapTime) { this.fastestLapTime = fastestLapTime; }
}