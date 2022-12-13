package ae.jersey.poc.repositories.impl;

import ae.jersey.poc.models.Vehicle;
import ae.jersey.poc.repositories.VehicleRepository;
import org.hibernate.Query;
import org.jvnet.hk2.annotations.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by syedm on 12/12/2022.
 */
@Service
public class VehicleRepositoryImpl extends BaseRepositoryImpl<Vehicle, Long> implements VehicleRepository {

    @Override
    public List<Vehicle> findByParam(String param) {
        List<Vehicle> vehicles = new ArrayList<>();
        Query query = getSession().createQuery(
                 "SELECT v FROM Vehicle v " +
                            "WHERE v.category = :param " +
                            "OR v.code = :param " +
                            "OR v.emirate = :param " +
                            "OR v.chassis = :param " +
                            "OR v.number = :param " +
                            "OR :param IS NULL"
        );
        query.setString("param", param);
        vehicles = query.list();
        closeSession();
        return vehicles;
    }
}
