package ae.jersey.poc.repositories.impl;

import ae.jersey.poc.models.Fine;
import ae.jersey.poc.repositories.FineRepository;
import org.hibernate.Query;
import org.jvnet.hk2.annotations.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by syedm on 12/12/2022.
 */
@Service
public class FineRepositoryImpl extends BaseRepositoryImpl<Fine, Long> implements FineRepository {

    @Override
    public List<Fine> findByParam(String param) {
        List<Fine> fines = new ArrayList<>();
        Query query = getSession().createQuery(
                 "SELECT f FROM Fine f " +
                            "WHERE f.referenceNumber = :param " +
                            "OR f.amount = :param " +
                            "OR :param IS NULL"
        );
        query.setString("param", param);
        fines = query.list();
        closeSession();
        return fines;
    }
}
