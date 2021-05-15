package com.rest.foxbat.rest.api.dao.impl;

import com.rest.foxbat.rest.api.dao.UserDao;
import com.rest.foxbat.rest.api.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao{

}
