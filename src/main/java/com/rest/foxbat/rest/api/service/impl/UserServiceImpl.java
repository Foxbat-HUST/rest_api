package com.rest.foxbat.rest.api.service.impl;

import com.rest.foxbat.rest.api.dao.AddressDao;
import com.rest.foxbat.rest.api.dao.UserDao;
import com.rest.foxbat.rest.api.dto.UserAddressDto;
import com.rest.foxbat.rest.api.dto.UserInfoDto;
import com.rest.foxbat.rest.api.entity.Address;
import com.rest.foxbat.rest.api.entity.User;
import com.rest.foxbat.rest.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private AddressDao addressDao;

    @Override
    @Transactional
    public void create() {
        User user = new User();
        user.setId(1L);
        user.setName("Pham Quoc An");
        user.setAge(27);
        user.setEmail("phamquocanhust@gmail.com");
        userDao.create(user);

        Address address = new Address();
        address.setId(1L);
        address.setUserId(user.getId());
        address.setZipCode("1740064");
        address.setAddress("ダイエー 板橋サンゼリゼ店");
        addressDao.create(address);

        System.out.println(userDao.findById(1L).toString());
    }

    @Override
    public UserAddressDto findUserAddress(long id) {
        return userDao.findUserAddress(id);
    }

    @Override
    public List<UserInfoDto> findUsersInfo(List<Long> ids) {
        return userDao.findUsersInfo(ids);
    }

    @Override
    public User findById(long id) {
        return userDao.findById(id);
    }
}
