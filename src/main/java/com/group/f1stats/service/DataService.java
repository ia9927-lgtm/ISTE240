package com.group.f1stats.service;

import com.group.f1stats.model.Driver;
import com.group.f1stats.model.Result;
import com.group.f1stats.model.Team;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DataService {
    private List<Driver> drivers = new ArrayList<>();
    private List<Team> teams = new ArrayList<>();
    private List<Result> results = new ArrayList<>();

    public DataService() {


        Team t1 = new Team(1, "Red Bull", "Austria", "Christian Horner", 6);
        Team t2 = new Team(2, "Ferrari", "Italy", "Fred Vasseur", 16);
        Team t3 = new Team(3, "Mercedes", "Germany", "Toto Wolff", 8);
        teams.add(t1);
        teams.add(t2);
        teams.add(t3);


        Driver d1 = new Driver(1, "Max", "Verstappen", "Dutch", 1, t1);
        Driver d2 = new Driver(2, "Charles", "Leclerc", "Monegasque", 16, t2);
        Driver d3 = new Driver(3, "Lewis", "Hamilton", "British", 44, t3);
        drivers.add(d1);
        drivers.add(d2);
        drivers.add(d3);


        t1.addDriver(d1);
        t2.addDriver(d2);
        t3.addDriver(d3);
    }


    public List<Driver> getDrivers() { return drivers; }

    public void addDriver(int id, String firstName, String lastName,
                          String nationality, int driverNumber, int teamId) {
        Team team = getTeamById(teamId);
        if (team != null) {
            Driver d = new Driver(id, firstName, lastName, nationality, driverNumber, team);
            drivers.add(d);
            team.addDriver(d);
        }
    }


    public List<Team> getTeams() { return teams; }

    public void addTeam(int id, String name, String nationality,
                        String principal, int championshipsWon) {
        teams.add(new Team(id, name, nationality, principal, championshipsWon));
    }


    public List<Result> getResults() { return results; }

    public void addResult(int raceId, int driverId, int finishingPosition,
                          int pointsEarned, String fastestLapTime) {
    }


    public Team getTeamById(int id) {
        for (Team t : teams) {
            if (t.getId() == id) return t;
        }
        return null;
    }

    public Driver getDriverById(int id) {
        for (Driver d : drivers) {
            if (d.getId() == id) return d;
        }
        return null;
    }
}