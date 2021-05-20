package com.rest.foxbat.rest.api.dao;

import java.util.List;
import java.util.Map;

public interface CommonDao {
    /**
     * run query specify by @namedQuery and return list of result
     * @param namedQuery
     * @param dtoClass
     * @param params
     * @param <T>
     * @return
     */
    <T> List<T> select(String namedQuery, Class<T> dtoClass, Map<String, Object> params);

    /**
     * run query specify by @namedQuery and return list of result
     * @param namedQuery
     * @param dtoClass
     * @param <T>
     * @return
     */
    <T> List<T> select(String namedQuery, Class<T> dtoClass);

    /**
     * run query  specify by @namedQuery and return one result
     * @param namedQuery
     * @param dtoClass
     * @param params
     * @param <T>
     * @return
     */
    <T> T selectFirst(String namedQuery, Class<T> dtoClass, Map<String, Object> params);

    /**
     * run query  specify by @namedQuery and return one result
     * @param namedQuery
     * @param dtoClass
     * @param <T>
     * @return
     */
    <T> T selectFirst(String namedQuery, Class<T> dtoClass);

    /**
     * run SQL statement specify by @namedQuery
     * @param namedQuery
     * @param params
     */
    void execute(String namedQuery, Map<String, Object> params);

    /**
     * run SQL statement specify by @namedQuery
     * @param namedQuery
     */
    void execute(String namedQuery);

}
