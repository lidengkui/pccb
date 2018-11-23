package com.pccb.customer.dao;

import com.pccb.customer.entity.AppCustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppCustomerDao extends JpaRepository<AppCustomerEntity, Long> {

}
