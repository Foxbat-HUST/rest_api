package com.rest.foxbat.rest.api.service;

import com.rest.foxbat.rest.api.dto.UserAddressDto;
import com.rest.foxbat.rest.api.dto.UserInfoDto;
import com.rest.foxbat.rest.api.entity.User;

import java.util.List;

public interface UserService {

    void create();

    /**
     * get user address by id
     * @param id
     * @return
     */
    UserAddressDto findUserAddress(long id);

    /**
     * get users info by ids
     * @param ids
     * @return
     */
    List<UserInfoDto> findUsersInfo(List<Long> ids);

    /**
     * get user entity by id
     * @param id
     * @return
     */
    User findById(long id);
}
