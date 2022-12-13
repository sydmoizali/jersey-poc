package ae.jersey.poc.services.impl;

import ae.jersey.poc.api.client.CurrencyRestClient;
import ae.jersey.poc.models.Fine;
import ae.jersey.poc.repositories.FineRepository;
import ae.jersey.poc.services.FineService;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by syedm on 12/12/2022.
 */
@Service
public class FineServiceImpl implements FineService {

    @Inject
    private FineRepository fineRepository;

    @Override
    public List<Fine> getFinesByParam(String param) {
        List<Fine> fines = new ArrayList<>();
        if(param != null) {
            fines = fineRepository.findByParam(param);
        } else {
            fines = fineRepository.findAll();
        }
        return fines;
    }

    @Override
    public Fine getFineById(Long fineId) {
        if (fineId != null) {
            Fine fine = fineRepository.findById(fineId);
            fine.setCurrencies(CurrencyRestClient.getCurrencies());
            return fine;
        }
        return null;
    }

    @Override
    public Fine saveFine(Fine fine) {
        if(fine != null) {
            if(fine.getFineId() != null) {
                fine = fineRepository.update(fine);
            } else {
                fine = fineRepository.save(fine);
            }
        }
        return fine;
    }

    @Override
    public void deleteFine(Long vehicleId) {
        if(vehicleId != null) {
            fineRepository.delete(vehicleId);
        }
    }
}
