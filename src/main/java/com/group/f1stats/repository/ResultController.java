// Adil Nurmagambetov UID:415002457
package com.group.f1stats.repository;

import com.group.f1stats.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RaceDAO extends JpaRepository<Race, Long> {

    Optional<Race> findById(Long id);

    List<Race> findAll();

    @Query("SELECT r FROM Race r WHERE r.grandPrixName = :grandPrixName")
    List<Race> findByGrandPrixName(@Param("grandPrixName") String grandPrixName);

    void deleteById(Long id);

    @Modifying
    @Query("UPDATE Race r SET r.grandPrixName = :grandPrixName, r.circuit = :circuit, r.country = :country, r.raceDate = :raceDate, r.season = :season WHERE r.id = :id")
    void updateById(@Param("id") Long id,
                    @Param("grandPrixName") String grandPrixName,
                    @Param("circuit") String circuit,
                    @Param("country") String country,
                    @Param("raceDate") String raceDate,
                    @Param("season") int season);
}