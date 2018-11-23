package com.pccb.test.test;

import com.pccb.customer.entity.AppCustomerEntity;
import com.pccb.customer.service.AppCustomerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AppCustomerServiceTest extends  TestBase {
    @Autowired
    private AppCustomerService appCustomerService;
    @Test
    public  void  testfindById(){

     AppCustomerEntity appCustomerEntity = appCustomerService.findById(1L);
     System.out.println("---------------"+appCustomerEntity);
    }
}
