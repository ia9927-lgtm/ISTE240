// Author: Om Singh - 751006630
// Entity: Driver
package com.group.f1stats.service;

import com.group.f1stats.model.Driver;
import com.group.f1stats.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Optional<Driver> getDriverById(int id) {
        return driverRepository.findById(id);
    }

    public List<Driver> getDriversByNationality(String nationality) {
        return driverRepository.findByNationality(nationality);
    }

    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public Driver updateDriver(int id, Driver updated) {
        updated.setId(id);
        return driverRepository.save(updated);
    }

    public void deleteDriver(int id) {
        driverRepository.deleteById(id);
    }
}