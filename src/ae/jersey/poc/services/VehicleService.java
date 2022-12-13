package ae.jersey.poc.services;

import ae.jersey.poc.models.Vehicle;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

/**
 * Created by syedm on 12/12/2022.
 */
@Contract
public interface VehicleService {

    List<Vehicle> getVehiclesByParam(String param);

    Vehicle getVehicleById(Long vehicleId);

    Vehicle saveVehicle(Vehicle vehicle);

    void deleteVehicle(Long vehicleId);

}
