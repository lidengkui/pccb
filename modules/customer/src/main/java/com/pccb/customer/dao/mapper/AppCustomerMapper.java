package com.pccb.customer.dao.mapper;

import com.pccb.customer.entity.AppCustomerEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AppCustomerMapper {

    AppCustomerEntity findByAppCode(@Param("code") String code);
}
