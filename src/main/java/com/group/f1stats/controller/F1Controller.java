package com.group.f1stats.controller;

import com.group.f1stats.model.Race;
import com.group.f1stats.service.DataService;
import com.group.f1stats.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class F1Controller {

    @Autowired
    private DataService service;


    private final RaceService raceService;

    public F1Controller(RaceService raceService) {
        this.raceService = raceService;
    }




    // Landing page
    @GetMapping("/")
    public String home() {
        return "forward:/index.html";
    }

    //DRIVERS

    @GetMapping("/drivers")
    public String drivers(Model model) {
        model.addAttribute("drivers", service.getDrivers());
        return "drivers";
    }

    @GetMapping("/drivers/add")
    public String addDriverPage(Model model) {
        model.addAttribute("teams", service.getTeams());
        return "addDriver";
    }

    @PostMapping("/drivers/add")
    public String addDriver(@RequestParam String firstName,
                            @RequestParam String lastName,
                            @RequestParam String nationality,
                            @RequestParam int driverNumber,
                            @RequestParam int teamId) {
        int id = service.getDrivers().size() + 1;
        service.addDriver(id, firstName, lastName, nationality, driverNumber, teamId);
        return "redirect:/add/success/driver";
    }

    //TEAMS

    @GetMapping("/teams")
    public String teams(Model model) {
        model.addAttribute("teams", service.getTeams());
        return "teams";
    }

    @GetMapping("/teams/add")
    public String addTeamPage() {
        return "addTeam";
    }

    @PostMapping("/teams/add")
    public String addTeam(@RequestParam String name,
                          @RequestParam String nationality,
                          @RequestParam String principal,
                          @RequestParam int championshipsWon) {
        int id = service.getTeams().size() + 1;
        service.addTeam(id, name, nationality, principal, championshipsWon);
        return "redirect:/add/success/team";
    }

    //RACES

    @GetMapping("/races")
    public String showRaces(Model model) {
        model.addAttribute("races", raceService.findAll());
        return "races";
    }

    @GetMapping("/races/add")
    public String addRacePage() {
        return "addRace";
    }

    @PostMapping("/races/add")
    public String addRace(@ModelAttribute Race race) {
        raceService.createRace(race);
        return "redirect:/add/success/race";
    }

    //RESULTS

    @GetMapping("/results")
    public String results(Model model) {
        model.addAttribute("results", service.getResults());
        return "results";
    }

    @GetMapping("/results/add")
    public String addResultPage(Model model) {
        model.addAttribute("races", raceService.findAll());
        model.addAttribute("drivers", service.getDrivers());
        return "addResult";
    }

    @PostMapping("/results/add")
    public String addResult(@RequestParam int raceId,
                            @RequestParam int driverId,
                            @RequestParam int finishingPosition,
                            @RequestParam int pointsEarned,
                            @RequestParam String fastestLapTime) {
        service.addResult(raceId, driverId, finishingPosition, pointsEarned, fastestLapTime);
        return "redirect:/add/success/result";
    }

    //SUCCESS

    @GetMapping("/add/success/{entityName}")
    public String successPage(@PathVariable String entityName, Model model) {
        model.addAttribute("entity", entityName);
        return "success";
    }
}