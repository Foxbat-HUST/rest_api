package com.rest.foxbat.rest.api.dao;

import com.rest.foxbat.rest.api.dto.UserAddressDto;
import com.rest.foxbat.rest.api.dto.UserInfoDto;
import com.rest.foxbat.rest.api.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends BaseDao<User,Long> {

    public static final String FIND_USER_ADDRESS = "User.findUserAddress";
    public static final String FIND_USERS_INFO = "User.findUsersInfo";

    /**
     * find user address by id
     * @param id
     * @return
     */
    UserAddressDto findUserAddress(long id);

    /**
     * find user information by ids
     * @param ids
     * @return
     */
    List<UserInfoDto> findUsersInfo(List<Long> ids);
}
