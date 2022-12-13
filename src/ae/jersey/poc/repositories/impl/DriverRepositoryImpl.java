package ae.jersey.poc.repositories.impl;

import ae.jersey.poc.models.Driver;
import ae.jersey.poc.repositories.DriverRepository;
import org.hibernate.Query;
import org.jvnet.hk2.annotations.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by syedm on 12/12/2022.
 */
@Service
public class DriverRepositoryImpl extends BaseRepositoryImpl<Driver, Long> implements DriverRepository {

    @Override
    public List<Driver> findByParam(String param) {
        List<Driver> drivers = new ArrayList<>();
        Query query = getSession().createQuery(
                 "SELECT d FROM Driver d " +
                            "WHERE d.licenseNo = :param " +
                            "OR d.licenseSource = :param"
        );
        query.setString("param", param);
        drivers = query.list();
        closeSession();
        return drivers;
    }
}
