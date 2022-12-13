package ae.jersey.poc.services.impl;

import ae.jersey.poc.models.Vehicle;
import ae.jersey.poc.repositories.VehicleRepository;
import ae.jersey.poc.services.VehicleService;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by syedm on 12/12/2022.
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    @Inject
    private VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> getVehiclesByParam(String param) {
        List<Vehicle> vehicles = new ArrayList<>();
        if(param != null) {
            vehicles = vehicleRepository.findByParam(param);
        } else {
            vehicles = vehicleRepository.findAll();
        }
        return vehicles;
    }

    @Override
    public Vehicle getVehicleById(Long vehicleId) {
        if (vehicleId != null) {
            return vehicleRepository.findById(vehicleId);
        }
        return null;
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        if(vehicle != null) {
            if(vehicle.getVehicleId() != null) {
                vehicle = vehicleRepository.update(vehicle);
            } else {
                vehicle = vehicleRepository.save(vehicle);
            }
        }
        return vehicle;
    }

    @Override
    public void deleteVehicle(Long vehicleId) {
        if(vehicleId != null) {
            vehicleRepository.delete(vehicleId);
        }
    }
}
