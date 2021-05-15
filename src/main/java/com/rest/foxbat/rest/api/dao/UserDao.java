package com.rest.foxbat.rest.api.dao;

import com.rest.foxbat.rest.api.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends BaseDao<User,Long> {

}
