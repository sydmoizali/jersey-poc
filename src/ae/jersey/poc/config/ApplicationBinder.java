package ae.jersey.poc.config;

import ae.jersey.poc.repositories.DriverRepository;
import ae.jersey.poc.repositories.FineRepository;
import ae.jersey.poc.repositories.VehicleRepository;
import ae.jersey.poc.repositories.impl.DriverRepositoryImpl;
import ae.jersey.poc.repositories.impl.FineRepositoryImpl;
import ae.jersey.poc.repositories.impl.VehicleRepositoryImpl;
import ae.jersey.poc.services.DriverService;
import ae.jersey.poc.services.FineService;
import ae.jersey.poc.services.VehicleService;
import ae.jersey.poc.services.impl.DriverServiceImpl;
import ae.jersey.poc.services.impl.FineServiceImpl;
import ae.jersey.poc.services.impl.VehicleServiceImpl;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

/**
 * Created by syedm on 13/12/2022.
 */
public class ApplicationBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind(VehicleRepositoryImpl.class).to(VehicleRepository.class);
        bind(DriverRepositoryImpl.class).to(DriverRepository.class);
        bind(FineRepositoryImpl.class).to(FineRepository.class);
        bind(VehicleServiceImpl.class).to(VehicleService.class);
        bind(DriverServiceImpl.class).to(DriverService.class);
        bind(FineServiceImpl.class).to(FineService.class);
    }
}
