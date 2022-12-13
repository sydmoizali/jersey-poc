package ae.jersey.poc.services;

import ae.jersey.poc.models.Driver;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

/**
 * Created by syedm on 12/12/2022.
 */
@Contract
public interface DriverService {

    List<Driver> getDriversByParam(String param);

    Driver getDriverById(Long driverId);

    Driver saveDriver(Driver driver);

    void deleteDriver(Long driverId);
}
