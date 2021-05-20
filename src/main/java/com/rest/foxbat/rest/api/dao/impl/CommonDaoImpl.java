package com.rest.foxbat.rest.api.dao.impl;

import com.rest.foxbat.rest.api.dao.CommonDao;
import com.rest.foxbat.rest.api.utils.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
public class CommonDaoImpl implements CommonDao {

    @Autowired
    EntityManager em;

    @Override
    public <T> List<T> select(String namedQuery, Class<T> dtoClass, Map<String, Object> params) {
        TypedQuery<T> query = em.createNamedQuery(namedQuery, dtoClass);

        if(MapUtils.isNotEmpty(params)){
            params.entrySet().stream()
                    .forEach(i -> query.setParameter(i.getKey(), i.getValue()));
        }

        return (List<T>) query.getResultList();
    }

    @Override
    public <T> List<T> select(String namedQuery, Class<T> dtoClass) {
        return select(namedQuery, dtoClass, null);
    }

    @Override
    public <T> T selectFirst(String namedQuery, Class<T> dtoClass, Map<String, Object> params) {
        TypedQuery<T> query = em.createNamedQuery(namedQuery,dtoClass);

        if(MapUtils.isNotEmpty(params)){
            params.entrySet().stream()
                    .forEach(i -> query.setParameter(i.getKey(), i.getValue()));
        }

        return (T) query.getSingleResult();
    }

    @Override
    public <T> T selectFirst(String namedQuery, Class<T> dtoClass) {
        return selectFirst(namedQuery, dtoClass, null);
    }

    @Override
    public void execute(String namedQuery, Map<String, Object> params) {
        Query query = em.createQuery(namedQuery);

        if(MapUtils.isNotEmpty(params)){
            params.entrySet().stream()
                    .forEach(i -> query.setParameter(i.getKey(), i.getValue()));
        }
        query.executeUpdate();
    }

    @Override
    public void execute(String namedQuery) {
        execute(namedQuery, null);
    }
}
