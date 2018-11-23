package com.pccb.customer.service.Impl;

import com.pccb.customer.dao.AppCustomerDao;
import com.pccb.customer.dao.mapper.AppCustomerMapper;
import com.pccb.customer.entity.AppCustomerEntity;
import com.pccb.customer.service.AppCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("appCustomerService")
public class AppCustomerServiceImpl implements AppCustomerService {

    @Autowired
    private AppCustomerMapper appCustomer;
    @Autowired
    private AppCustomerDao appCustomerDao;

    @Override
    public AppCustomerEntity findByAppCode(String code) {
        return appCustomer.findByAppCode(code);
    }

    @Override
    public AppCustomerEntity findById(Long id) {
        return appCustomerDao.getOne(id);
    }


}
