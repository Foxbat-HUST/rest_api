package com.rest.foxbat.rest.api.dao.impl;

import com.rest.foxbat.rest.api.dao.CommonDao;
import com.rest.foxbat.rest.api.dao.UserDao;
import com.rest.foxbat.rest.api.dto.UserAddressDto;
import com.rest.foxbat.rest.api.dto.UserInfoDto;
import com.rest.foxbat.rest.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User, Long> implements UserDao{

    @Autowired
    private CommonDao commonDao;

    @Override
    public UserAddressDto findUserAddress(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        return (UserAddressDto) commonDao.selectFirst(FIND_USER_ADDRESS, UserAddressDto.class, params);
    }

    @Override
    public List<UserInfoDto> findUsersInfo(List<Long> ids) {
        Map<String, Object> params = new HashMap<>();
        params.put("ids", ids);

        return commonDao.select(FIND_USERS_INFO,UserInfoDto.class, params);
    }
}
