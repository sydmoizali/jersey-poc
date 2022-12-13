package ae.jersey.poc.repositories;

import ae.jersey.poc.models.Vehicle;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

/**
 * Created by syedm on 12/12/2022.
 */
@Contract
public interface VehicleRepository extends BaseRepository<Vehicle, Long> {

    List<Vehicle> findByParam(String param);
}
