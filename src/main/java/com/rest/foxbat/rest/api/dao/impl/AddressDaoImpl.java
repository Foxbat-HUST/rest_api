package com.rest.foxbat.rest.api.dao.impl;

import com.rest.foxbat.rest.api.dao.AddressDao;
import com.rest.foxbat.rest.api.entity.Address;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDaoImpl extends BaseDaoImpl<Address, Long> implements AddressDao {
}
