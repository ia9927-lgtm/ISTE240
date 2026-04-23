package com.group.f1stats.service;

import com.group.f1stats.model.Driver;
import com.group.f1stats.model.Race;
import com.group.f1stats.model.Result;
import com.group.f1stats.model.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {

    private List<Driver> drivers = new ArrayList<>();
    private List<Team> teams = new ArrayList<>();
    private List<Race> races = new ArrayList<>();
    private List<Result> results = new ArrayList<>();

    public DataService() {

        // Seed Teams
        Team t1 = new Team(1, "Red Bull", "Austria", "Christian Horner", 6);
        Team t2 = new Team(2, "Ferrari", "Italy", "Fred Vasseur", 16);
        Team t3 = new Team(3, "Mercedes", "Germany", "Toto Wolff", 8);
        teams.add(t1);
        teams.add(t2);
        teams.add(t3);

        // Seed Drivers
        Driver d1 = new Driver(1, "Max", "Verstappen", "Dutch", 1, t1);
        Driver d2 = new Driver(2, "Charles", "Leclerc", "Monegasque", 16, t2);
        Driver d3 = new Driver(3, "Lewis", "Hamilton", "British", 44, t3);
        drivers.add(d1);
        drivers.add(d2);
        drivers.add(d3);

        // Link drivers to teams
        t1.addDriver(d1);
        t2.addDriver(d2);
        t3.addDriver(d3);

        // Seed Races
        Race r1 = new Race(1, "Bahrain Grand Prix", "Bahrain International Circuit", "Bahrain", "2025-03-02", 2025);
        Race r2 = new Race(2, "Saudi Arabian Grand Prix", "Jeddah Corniche Circuit", "Saudi Arabia", "2025-03-09", 2025);
        Race r3 = new Race(3, "Australian Grand Prix", "Albert Park Circuit", "Australia", "2025-03-23", 2025);
        races.add(r1);
        races.add(r2);
        races.add(r3);

        // Seed Results - now uses actual Race and Driver objects
        results.add(new Result(1, r1, d1, 1, 25, "1:32.456"));
        results.add(new Result(2, r1, d2, 2, 18, "1:32.891"));
        results.add(new Result(3, r2, d3, 1, 25, "1:29.102"));
    }

    // --- Drivers ---
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

    // --- Teams ---
    public List<Team> getTeams() { return teams; }

    public void addTeam(int id, String name, String nationality,
                        String principal, int championshipsWon) {
        teams.add(new Team(id, name, nationality, principal, championshipsWon));
    }

    // --- Races ---
    public List<Race> getRaces() { return races; }

    public void addRace(String grandPrixName, String circuit, String country,
                        String raceDate, int season) {
        int id = races.size() + 1;
        races.add(new Race(id, grandPrixName, circuit, country, raceDate, season));
    }

    // --- Results ---
    public List<Result> getResults() { return results; }

    public void addResult(int raceId, int driverId, int finishingPosition,
                          int pointsEarned, String fastestLapTime) {
        Race race = getRaceById(raceId);
        Driver driver = getDriverById(driverId);
        if (race != null && driver != null) {
            int id = results.size() + 1;
            results.add(new Result(id, race, driver, finishingPosition, pointsEarned, fastestLapTime));
        }
    }

    // --- Helpers ---
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

    public Race getRaceById(int id) {
        for (Race r : races) {
            if (r.getId() == id) return r;
        }
        return null;
    }
}