// Adil Nurmagambetov UID:415002457
package com.group.f1stats.service;

import com.group.f1stats.model.Driver;
import com.group.f1stats.model.Race;
import com.group.f1stats.model.Result;
import com.group.f1stats.repository.DriverRepository;
import com.group.f1stats.repository.RaceDAO;
import com.group.f1stats.repository.ResultDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ResultService {

    @Autowired
    private ResultDAO resultDAO;

    @Autowired
    private RaceDAO raceDAO;

    @Autowired
    private DriverRepository driverRepository;

    public Result findById(Long id) {
        return resultDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Result not found"));
    }

    public List<Result> findByRaceId(Long raceId) {
        return resultDAO.findByRaceId(raceId);
    }

    public List<Result> findByDriverId(Long driverId) {
        return resultDAO.findByDriverId(driverId);
    }

    public List<Result> findAll() {
        return resultDAO.findAll();
    }

    public void updatePointsById(Long id, int points) {
        if (!resultDAO.existsById(id)) {
            throw new RuntimeException("Result not found");
        }
        resultDAO.updatePointsEarnedById(id, points);
    }

    public void deleteById(Long id) {
        if (!resultDAO.existsById(id)) {
            throw new RuntimeException("Result not found");
        }
        resultDAO.deleteById(id);
    }

    public Result createResult(Result result) {
        if (result.getRace() != null && result.getRace().getId() != null) {
            Race race = raceDAO.findById(result.getRace().getId())
                    .orElseThrow(() -> new RuntimeException("Race not found"));
            result.setRace(race);
        }
        if (result.getDriver() != null) {
            Driver driver = driverRepository.findById(result.getDriver().getId())
                    .orElseThrow(() -> new RuntimeException("Driver not found"));
            result.setDriver(driver);
        }
        return resultDAO.save(result);
    }

    public Result updateResult(Long id, Result resultToUpdate) {
        Result oldRes = resultDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Result not found"));
        if (resultToUpdate.getRace() != null && resultToUpdate.getRace().getId() != null) {
            Race race = raceDAO.findById(resultToUpdate.getRace().getId())
                    .orElseThrow(() -> new RuntimeException("Race not found"));
            oldRes.setRace(race);
        }
        if (resultToUpdate.getDriver() != null) {
            Driver driver = driverRepository.findById(resultToUpdate.getDriver().getId())
                    .orElseThrow(() -> new RuntimeException("Driver not found"));
            oldRes.setDriver(driver);
        }
        oldRes.setFinishingPosition(resultToUpdate.getFinishingPosition());
        oldRes.setPointsEarned(resultToUpdate.getPointsEarned());
        oldRes.setFastestLapTime(resultToUpdate.getFastestLapTime());
        return resultDAO.save(oldRes);
    }
}