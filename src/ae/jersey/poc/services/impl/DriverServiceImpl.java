package ae.jersey.poc.services.impl;

import ae.jersey.poc.api.client.NationalityRestClient;
import ae.jersey.poc.models.Driver;
import ae.jersey.poc.repositories.DriverRepository;
import ae.jersey.poc.services.DriverService;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by syedm on 12/12/2022.
 */
@Service
public class DriverServiceImpl implements DriverService {

    @Inject
    private DriverRepository driverRepository;

    @Override
    public List<Driver> getDriversByParam(String param) {
        List<Driver> drivers = new ArrayList<>();
        if(param != null) {
            drivers = driverRepository.findByParam(param);
        } else {
            drivers = driverRepository.findAll();
        }
        return drivers;
    }

    @Override
    public Driver getDriverById(Long driverId) {
        if (driverId != null) {
            Driver driver =  driverRepository.findById(driverId);
            driver.setNationalities(NationalityRestClient.getNationalities(driver.getLicenseNo()));
            return driver;
        }
        return null;
    }

    @Override
    public Driver saveDriver(Driver driver) {
        if(driver != null) {
            if(driver.getDriverId() != null) {
                driver = driverRepository.update(driver);
            } else {
                driver = driverRepository.save(driver);
            }
        }
        return driver;
    }

    @Override
    public void deleteDriver(Long driverId) {
        if(driverId != null) {
            driverRepository.delete(driverId);
        }
    }
}
