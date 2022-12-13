package ae.jersey.poc.repositories;

import ae.jersey.poc.models.Fine;
import org.jvnet.hk2.annotations.Contract;

import java.util.List;

/**
 * Created by syedm on 12/12/2022.
 */
@Contract
public interface FineRepository extends BaseRepository<Fine, Long>{

    List<Fine> findByParam(String param);
}
