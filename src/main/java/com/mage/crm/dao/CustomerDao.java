package com.mage.crm.dao;

import com.mage.crm.vo.Customer;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CustomerDao {
    @Select("select id,name from t_customer where is_valid=1 and state=0")
    List<Customer> queryAllCustomers();
}
