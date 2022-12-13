package ae.jersey.poc.services;

import ae.jersey.poc.models.Fine;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

/**
 * Created by syedm on 12/12/2022.
 */
@Contract
public interface FineService {

    List<Fine> getFinesByParam(String param);

    Fine getFineById(Long fineId);

    Fine saveFine(Fine fine);

    void deleteFine(Long fineId);
}
