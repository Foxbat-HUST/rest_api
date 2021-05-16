package com.rest.foxbat.rest.api.dao.impl;

import com.rest.foxbat.rest.api.dao.BaseDao;
import com.rest.foxbat.rest.api.utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.QueryUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
    public T create(T entity) {
        if(entity == null){
            return null;
        }

        em.persist(entity);
        return entity;
    }

    @Override
    public List<T> create(List<T> entities) {
        if(entities == null || entities.size() == 0) {
            return Collections.emptyList();
        }

        for (T entity: entities) {
            em.persist(entity);
        }

        return entities;
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
    public void deleteByIds(List<ID> ids) {
        if(ListUtils.isEmpty(ids)){
            return;
        }

        /*String deleteQuery = String.format(DELETE_BY_IDS,entityClazz.getName());
        TypedQuery<T> typedQuery = em.createQuery(deleteQuery,entityClazz);
        typedQuery.setParameter("ids", ids);
        typedQuery.getR*/
    }


    @Override
    public T findById(ID id) {
        return em.find(entityClazz,id);
    }

    @Override
    public List<T> findByIds(List<ID> ids) {
        if(ListUtils.isEmpty(ids)){
            return Collections.emptyList();
        }
        String queryByIds = String.format(FIND_BY_IDS,entityClazz.getName());
        TypedQuery<T> query = em.createQuery(queryByIds, entityClazz);
        query.setParameter("ids", ids);

        return query.getResultList();
    }

    @Override
    public T update(T entity) {
        if(entity == null){
            return null;
        }

        em.merge(entity);

        return entity;
    }

    @Override
    public List<T> update(List<T> entities) {
        if(ListUtils.isEmpty(entities)){
            return Collections.emptyList();
        }

        for(T entity:entities){
            em.merge(entity);
        }

        return entities;
    }
}
