package ae.jersey.poc.repositories;

import java.util.List;

/**
 * Created by syedm on 13/12/2022.
 */
public interface BaseRepository<E, PK> {

    List<E> findAll();

    E findById(PK id);

    E save(E entity);

    E update(E entity);

    void delete(PK id);
}
