package ae.jersey.poc.repositories.impl;

import ae.jersey.poc.repositories.BaseRepository;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by syedm on 13/12/2022.
 */
public abstract class BaseRepositoryImpl<E , PK> implements BaseRepository<E , PK> {

    private final Class<E> entityClass;

    protected Session session;

    @SuppressWarnings("unchecked")
    protected BaseRepositoryImpl() {
        this.entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected Session getSession() {
        this.session = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
                .openSession();
        this.session.beginTransaction();
        return this.session;
    }

    protected void closeSession() {
        this.session.close();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<E> findAll() {
        List<E> entities = getSession().createCriteria(entityClass).list();
        closeSession();
        return entities;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E findById(PK id) {
        E  entity = (E) getSession().get(entityClass, (Serializable)id);
        closeSession();
        return entity;
    }

    @Override
    public E save(E entity) {
        getSession().save(entity);
        closeSession();
        return entity;
    }

    @Override
    public E update(E entity) {
        getSession().update(entity);
        closeSession();
        return entity;
    }

    @Override
    public void delete(PK id) {
        final E entity = findById(id);
        getSession().delete(entity);
        closeSession();
    }
}
