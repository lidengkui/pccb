package com.pccb.test.test;

import com.pccb.assemble.AssembleApplication;
import com.pccb.customer.entity.AppCustomerEntity;
import com.pccb.customer.service.AppCustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(value = SpringRunner.class)
@SpringBootTest(classes = AssembleApplication.class)
public class AppCustomerServiceTest {
    @Autowired
    private AppCustomerService appCustomerService;
    @Test
    public  void  testfindById(){

     AppCustomerEntity appCustomerEntity = appCustomerService.findById(1L);
     System.out.println("---------------"+appCustomerEntity);
    }
}
