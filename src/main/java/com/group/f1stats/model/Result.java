package com.group.f1stats.model;

import org.springframework.stereotype.Component;

@Component
public class Result {

    private int id;
    private int raceId;
    private int driverId;
    private int finishingPosition;
    private int pointsEarned;
    private String fastestLapTime;

    public Result() {
    }

    public Result(int id, int raceId, int driverId,
                  int finishingPosition, int pointsEarned, String fastestLapTime) {
        this.id = id;
        this.raceId = raceId;
        this.driverId = driverId;
        this.finishingPosition = finishingPosition;
        this.pointsEarned = pointsEarned;
        this.fastestLapTime = fastestLapTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getFinishingPosition() {
        return finishingPosition;
    }

    public void setFinishingPosition(int finishingPosition) {
        this.finishingPosition = finishingPosition;
    }

    public int getPointsEarned() {
        return pointsEarned;
    }

    public void setPointsEarned(int pointsEarned) {
        this.pointsEarned = pointsEarned;
    }

    public String getFastestLapTime() {
        return fastestLapTime;
    }

    public void setFastestLapTime(String fastestLapTime) {
        this.fastestLapTime = fastestLapTime;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", raceId=" + raceId +
                ", driverId=" + driverId +
                ", finishingPosition=" + finishingPosition +
                ", pointsEarned=" + pointsEarned +
                ", fastestLapTime='" + fastestLapTime + '\'' +
                '}';
    }
}