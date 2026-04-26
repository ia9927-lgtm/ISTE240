// Adil Nurmagambetov UID:415002457
package com.group.f1stats.service;


import com.group.f1stats.model.Race;
import com.group.f1stats.repository.RaceDAO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RaceService {
    private final RaceDAO raceDAO;

    public RaceService(RaceDAO raceDAO){
        this.raceDAO = raceDAO;
    }


    // --- Races ---
    // find by id method for race
    public Race findById(Long id){
        return raceDAO.findById(id).orElseThrow(() -> new RuntimeException("Race not found"));
    }

    // find bt grandPrixName method for race
    public List<Race> findByGrandPrixName(String grandPrixName){
        List<Race> races = raceDAO.findByGrandPrixName(grandPrixName);
        if(races.isEmpty()){
            throw new RuntimeException("No races found");
        }
        return races;
    }

    // find all method for race
    public List<Race> findAll(){
        return raceDAO.findAll();
    }

    // delete method for race
    public void deleteById(Long id){
        if(!raceDAO.existsById(id)){
            throw new RuntimeException("Race not found");
        }
        raceDAO.deleteById(id);
    }

    //update method for race
    public Race updateById(Long id, Race raceToUpdate){
        Race oldRace = raceDAO.findById(id).orElseThrow(() -> new RuntimeException("Race not found"));

        oldRace.setGrandPrixName(raceToUpdate.getGrandPrixName());
        oldRace.setCircuit(raceToUpdate.getCircuit());
        oldRace.setCountry(raceToUpdate.getCountry());
        oldRace.setRaceDate(raceToUpdate.getRaceDate());
        oldRace.setSeason(raceToUpdate.getSeason());
        return raceDAO.save(oldRace);
    }

    //create method for race
    public Race createRace(Race newRace){
        if(newRace.getId() != 0 && raceDAO.existsById(newRace.getId())){
            throw new RuntimeException("Race already exists");
        }
        return raceDAO.save(newRace);
    }

}
