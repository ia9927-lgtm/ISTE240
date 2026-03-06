package com.group.f1stats.service;

import com.group.f1stats.model.Driver;
import com.group.f1stats.model.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {

    private List<Driver> drivers = new ArrayList<>();
    private List<Team> teams = new ArrayList<>();


    public DataService() {

        // Create Teams
        Team t1 = new Team(1, "Red Bull", "Austrian", "Christian Horner", 6);
        Team t2 = new Team(2, "Ferrari", "Italian", "Fred Vasseur", 16);
        Team t3 = new Team(3, "Mercedes", "German", "Toto Wolff", 8);

        teams.add(t1);
        teams.add(t2);
        teams.add(t3);


        // Create Drivers
        drivers.add(new Driver(1, "Max", "Verstappen", "Dutch", 1, "Red Bull"));
        drivers.add(new Driver(2, "Charles", "Leclerc", "Monegasque", 16, "Ferrari"));
        drivers.add(new Driver(3, "Lewis", "Hamilton", "British", 44, "Mercedes"));
    }


    // Driver Methods

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }


    // Team Methods

    public List<Team> getTeams() {
        return teams;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }
}