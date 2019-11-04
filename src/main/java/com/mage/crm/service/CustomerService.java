package com.mage.crm.service;

import com.mage.crm.dao.CustomerDao;
import com.mage.crm.util.AssertUtil;
import com.mage.crm.vo.Customer;
import com.mage.crm.vo.SaleChance;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CustomerService {
    @Resource
    private CustomerDao customerDao;
    public List<Customer> queryAllCustomers() {
        return  customerDao.queryAllCustomers();
    }


}
