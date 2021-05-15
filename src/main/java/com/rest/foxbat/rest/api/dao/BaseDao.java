package com.rest.foxbat.rest.api.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T, ID extends Serializable> {

    public static final String COUNT_QUERY_PLACE_HOLDER = "x";
    public static final String QUERY_BY_IDS = "select x from %s x where id in (:ids)";

    long count();

    void delete(ID id);

    void delete(T entity);

    T findById(ID id);

    List<T> findByIds(List<ID> ids);

}
