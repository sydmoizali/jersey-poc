package ae.jersey.poc.repositories;

import ae.jersey.poc.models.Driver;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

/**
 * Created by syedm on 12/12/2022.
 */
@Contract
public interface DriverRepository extends BaseRepository<Driver, Long> {

    List<Driver> findByParam(String param);
}
