// Adil Nurmagambetov UID:415002457
package com.group.f1stats.controller;

import com.group.f1stats.model.Race;
import com.group.f1stats.service.RaceService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/races")
public class RaceController {
    private final RaceService raceService;

    public RaceController(RaceService raceService){
        this.raceService = raceService;
    }

    @GetMapping
    public List<Race> findAllRaces(){
        return raceService.findAll();
    }

    @GetMapping("/{id}")
    public Race findById(@PathVariable long id){
        return raceService.findById(id);
    }

    @GetMapping("/search")
    public List<Race> findByGrandPrixName(@RequestParam String grandPrixName){
        return raceService.findByGrandPrixName(grandPrixName);
    }

    @PostMapping
    public Race createRace(@RequestBody Race race){
        return raceService.createRace(race);
    }

    @PutMapping("/{id}")
    public Race updateRace(@PathVariable Long id, @RequestBody Race race){
        return raceService.updateById(id, race);

    }

    @DeleteMapping("/{id}")
    public void deleteRace(@PathVariable Long id){
        raceService.deleteById(id);
        System.out.println("Race deleted!");
    }

}