package com.mage.crm.service;

import com.mage.crm.dao.UserDao;
import com.mage.crm.model.UserModel;
import com.mage.crm.util.AssertUtil;
import com.mage.crm.util.Base64Util;
import com.mage.crm.util.Md5Util;
import com.mage.crm.vo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
@Resource
private UserDao userDao;

public UserModel userLogin(String userName, String userPwd){
        User user = userDao.queryUserByName(userName);
        System.out.println(user);
        AssertUtil.isTrue(null==user,"用户不存在");
        AssertUtil.isTrue(userPwd.equals(user.getUserPwd()),"用户名或密码错误!");
        AssertUtil.isTrue("0".equals(user.getIsValid()),"用户已经被注销!");
        return createUserModel(user);
        }

private UserModel createUserModel(User user) {
        UserModel userModel = new UserModel();
        userModel.setUserName(user.getUserName());
        userModel.setTrueName(user.getTrueName());
        userModel.setId(Base64Util.enCode(String.valueOf(user.getId())));
        return userModel;
        }
//userId,oldPassword,newPassword,confirmPassword
public void updatePwd(String userId, String oldPassword, String newPassword, String confirmPassword) {
        AssertUtil.isTrue(null==userId,"非法用戶");
        AssertUtil.isTrue(StringUtils.isBlank(newPassword),"新密码不能为空");
        AssertUtil.isTrue(!newPassword.equals(confirmPassword),"两次密码输入不一致");
        User user = userDao.queryUserById(userId);
        AssertUtil.isTrue(null==user,"用户被冻结，不允许修改密码");
        oldPassword = Md5Util.encode(oldPassword);
        AssertUtil.isTrue(!oldPassword.equals(user.getUserPwd()),"原始密码错误");
        AssertUtil.isTrue(userDao.updatePwd(userId,newPassword)<1,"操作失败");
        }
public  User queryUserById(String id){
        return  userDao.queryUserById(id);
        }

public List<User> queryAllCustomerManager() {
        return userDao.queryAllCustomerManager();
        }
}
