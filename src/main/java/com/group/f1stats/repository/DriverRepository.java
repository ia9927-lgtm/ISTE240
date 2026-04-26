// Author: Om Singh - 751006630
// Entity: Driver
package com.group.f1stats.repository;

import com.group.f1stats.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Integer> {


    List<Driver> findByNationality(String nationality);


    @Query("SELECT d FROM Driver d WHERE d.driverNumber > :number")
    List<Driver> findDriversWithNumberGreaterThan(@Param("number") int number);


    @Modifying
    @Transactional
    @Query("UPDATE Driver d SET d.driverNumber = :number WHERE d.id = :id")
    int updateDriverNumberById(@Param("id") int id, @Param("number") int number);
}