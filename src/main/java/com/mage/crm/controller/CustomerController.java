package com.mage.crm.controller;

import com.mage.crm.base.BaseController;
import com.mage.crm.model.MessageModel;
import com.mage.crm.service.CustomerService;
import com.mage.crm.vo.Customer;
import com.mage.crm.vo.SaleChance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController extends BaseController{

    @Resource
    private CustomerService customerService;
    @RequestMapping("queryAllCustomers")
    @ResponseBody
    public List<Customer> queryAllCustomers(){
        return  customerService.queryAllCustomers();
    }

}
