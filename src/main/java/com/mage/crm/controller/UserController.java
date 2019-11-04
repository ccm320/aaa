package com.mage.crm.controller;


import com.mage.crm.base.CrmConstant;
import com.mage.crm.base.exceptions.ParamsException;
import com.mage.crm.model.MessageModel;
import com.mage.crm.model.UserModel;
import com.mage.crm.service.UserService;
import com.mage.crm.util.UserLoginUtil;
import com.mage.crm.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("userLogin")
    @ResponseBody
    public MessageModel userLogin(String userName, String userPwd){
        MessageModel messageModel = new MessageModel();
        messageModel.setMsg(CrmConstant.OPS_SUCCESS_MSG);
        messageModel.setCode(CrmConstant.OPS_SUCCESS_CODE);
        try{
            UserModel userModel = userService.userLogin(userName, userPwd);
            messageModel.setResult(userModel);
        }catch (ParamsException p){
            p.printStackTrace();
            messageModel.setCode(CrmConstant.LOGIN_FAILED_CODE);
            messageModel.setMsg(p.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            messageModel.setCode(CrmConstant.LOGIN_FAILED_CODE);
            messageModel.setMsg(CrmConstant.LOGIN_FAILED_MSG);
        }
        return messageModel;
    }

    @ResponseBody
    @RequestMapping("updatePwd")
    public MessageModel updatePwd(HttpServletRequest request,String oldPassword,String newPassword,String confirmPassword){
        MessageModel messageModel = new MessageModel();
        String userId = UserLoginUtil.realseUserId(request);
        try{
            userService.updatePwd(userId,oldPassword,newPassword,confirmPassword);
        }catch (ParamsException e){
            e.printStackTrace();
            messageModel.setCode(e.getCode());
            messageModel.setMsg(e.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            messageModel.setCode(CrmConstant.OPS_FAILED_CODE);
            messageModel.setMsg(CrmConstant.OPS_FAILED_MSG);
        }
        return messageModel;
    }

    @RequestMapping(value = "queryAllCustomerManager")
    @ResponseBody
    public List<User> queryAllCustomerManager(){
        System.out.println(userService.queryAllCustomerManager());
        return userService.queryAllCustomerManager();
    }

    @RequestMapping("queryUserById")
    @ResponseBody
    public List<User> queryUserById(String id){
        System.out.println(userService.queryUserById(id));
        return queryUserById(id);
    }
}
