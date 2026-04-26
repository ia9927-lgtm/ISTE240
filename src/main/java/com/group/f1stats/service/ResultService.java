// Adil Nurmagambetov UID:415002457
package com.group.f1stats.service;

import com.group.f1stats.model.Result;
import com.group.f1stats.repository.ResultDAO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ResultService {
    private final ResultDAO resultDAO;

    public ResultService(ResultDAO resultDAO) {
        this.resultDAO = resultDAO;
    }

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

    public Result updateResult(Long id, Result resultToUpdate) {
        Result oldRes = resultDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Result not found"));
        oldRes.setRace(resultToUpdate.getRace());
        oldRes.setDriver(resultToUpdate.getDriver());
        oldRes.setPointsEarned(resultToUpdate.getPointsEarned());
        oldRes.setFastestLapTime(resultToUpdate.getFastestLapTime());
        oldRes.setFinishingPosition(resultToUpdate.getFinishingPosition());
        return resultDAO.save(oldRes);
    }

    public Result createResult(Result result) {
        return resultDAO.save(result);
    }
}