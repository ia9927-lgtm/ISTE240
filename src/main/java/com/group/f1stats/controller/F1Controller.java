package com.group.f1stats.controller;

import com.group.f1stats.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class F1Controller {

    @Autowired
    private DataService service;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/drivers")
    public String drivers(Model model){

        model.addAttribute("drivers",service.getDrivers());
        return "drivers";
    }

    @GetMapping("/drivers/add")
    public String addDriverPage(Model model){

        model.addAttribute("teams",service.getTeams());
        return "addDriver";
    }

    @PostMapping("/drivers/add")
    public String addDriver(@RequestParam String firstName,
                            @RequestParam String lastName,
                            @RequestParam int teamId){

        service.addDriver(firstName,lastName,teamId);

        return "redirect:/add/success/driver";
    }
}