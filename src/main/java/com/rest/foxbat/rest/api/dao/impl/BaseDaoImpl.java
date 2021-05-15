package com.rest.foxbat.rest.api.dao.impl;

import com.rest.foxbat.rest.api.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.QueryUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BaseDaoImpl<T, ID extends Serializable> implements BaseDao<T, ID> {
    @Autowired
    private EntityManager em;

    private Class<T> entityClazz;

    public BaseDaoImpl(){
        entityClazz = (Class<T>)((ParameterizedType)getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];

    }


    @Override
    public long count() {
        String countQuery = String.format(QueryUtils.COUNT_QUERY_STRING,COUNT_QUERY_PLACE_HOLDER, entityClazz.getName());
         TypedQuery<Long> result = em.createQuery(countQuery, Long.class);

        return result.getSingleResult();
    }

    @Override
    public void delete(ID id) {
        T entity = em.find(entityClazz,id);
        em.remove(entity);
    }

    @Override
    public void delete(T entity) {
        em.remove(entity);
    }


    @Override
    public T findById(ID id) {
        return em.find(entityClazz,id);
    }

    @Override
    public List<T> findByIds(List<ID> ids) {
        if(ids == null || ids.isEmpty()){
            return Collections.emptyList();
        }
        String queryByIds = String.format(QUERY_BY_IDS,entityClazz.getName());
        TypedQuery<T> query = em.createQuery(queryByIds, entityClazz);
        query.setParameter("ids", ids);

        return query.getResultList();
    }
}
