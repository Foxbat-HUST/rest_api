package com.rest.foxbat.rest.api.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T, ID extends Serializable> {

    public static final String COUNT_QUERY_PLACE_HOLDER = "x";
    public static final String FIND_BY_IDS = "select x from %s x where id in (:ids)";
    public static final String DELETE_BY_IDS = "delete from %s x where id in (:ids)";

    /**
     * count number of entities in bd
     * @return
     */
    long count();

    /**
     * persistence entity to db
     * @param entity
     * @return
     */
    T create(T entity);

    /**
     * persistence list of entities to db
     * @param entities
     * @return
     */
    List<T> create(List<T> entities);

    /**
     * read an entity from db
     * @param id
     * @return
     */
    T findById(ID id);

    /**
     * read a list of entities from db
     * @param ids
     * @return
     */
    List<T> findByIds(List<ID> ids);

    /**
     * update entity in db
     * @param entity
     * @return
     */
    T update(T entity);

    /**
     * update list of entities to db
     * @param entities
     * @return
     */
    List<T> update(List<T> entities);

    /**
     * delete an entity by id
     * @param id
     */
    void delete(ID id);

    /**
     * delete an entity
     * @param entity
     */
    void delete(T entity);

    /**
     * delete list of entities by ids
     * @param ids
     */
    void deleteByIds(List<ID> ids);
}
