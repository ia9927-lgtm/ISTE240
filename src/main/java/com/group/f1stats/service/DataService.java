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

    public DataService(){

        Team t1 = new Team(1,"Red Bull","Austria","Christian Horner",6);
        Team t2 = new Team(2,"Ferrari","Italy","Fred Vasseur",16);

        teams.add(t1);
        teams.add(t2);

        drivers.add(new Driver("Max","Verstappen", t1));
        drivers.add(new Driver("Charles","Leclerc", t2));
    }

    public List<Driver> getDrivers(){
        return drivers;
    }

    public List<Team> getTeams(){
        return teams;
    }

    public void addDriver(String firstName,String lastName,int teamId){

        Team team = teams.get(teamId - 1);
        drivers.add(new Driver(firstName,lastName,team));
    }
}