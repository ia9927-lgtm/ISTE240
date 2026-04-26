// Adil Nurmagambetov UID:415002457
package com.group.f1stats.repository;

import com.group.f1stats.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ResultDAO extends JpaRepository<Result, Long> {
    Optional<Result> findById(Long id);
    List<Result> findByDriverId(Long driverId);
    @Query("SELECT r FROM Result r WHERE r.race.id = :raceId ")
    List<Result> findByRaceId(@Param("raceId")Long raceId);


    @Modifying
    @Query("UPDATE Result r SET r.pointsEarned = :points WHERE r.id = :id")
    void updatePointsEarnedById(@Param("id") Long id, @Param("points") int pointsEarned);
    void deleteById(Long id);

}
