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
    //      all find methods
    Optional<Race> findById(Long id);
    @Query("SELECT r FROM Race r WHERE r.grandPrixName = :grandPrixName ")
    List<Race> findByGrandPrixName(@Param("grandPrixName") String grandPrixName);
    List<Race> findAll();


    //      delete method
    void deleteById(Long id);

    //      update method
    @Modifying
    @Query("UPDATE Race r SET r = :race WHERE r.id = :id ")
    void updateById(@Param("id") Long id,@Param("race") Race raceToUpdate);





}
