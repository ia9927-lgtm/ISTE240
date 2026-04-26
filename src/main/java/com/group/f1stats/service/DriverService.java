// Author: Om Singh - 751006630
// Entity: Driver
package com.group.f1stats.service;

import com.group.f1stats.model.Driver;
import com.group.f1stats.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Driver getDriverById(int id) {
        Optional<Driver> driver = driverRepository.findById(id);
        if (driver.isPresent()) {
            return driver.get();
        }
        return null;
    }

    public List<Driver> getDriversByNationality(String nationality) {
        return driverRepository.findByNationality(nationality);
    }

    public List<Driver> getDriversWithHighNumber(int number) {
        return driverRepository.findDriversWithNumberGreaterThan(number);
    }

    @Transactional
    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    @Transactional
    public Driver updateDriver(int id, Driver updated) {
        updated.setId(id);
        return driverRepository.save(updated);
    }

    @Transactional
    public void deleteDriver(int id) {
        driverRepository.deleteById(id);
    }
}