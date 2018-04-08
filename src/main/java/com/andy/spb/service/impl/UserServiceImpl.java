package com.andy.spb.service.impl;

import com.andy.spb.dao.UserMapper;
import com.andy.spb.entity.User;
import com.andy.spb.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wusongjiang
 * @Description
 * @Date 2018-04-08 19:28
 */

@Component
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userDao;

    /**
     * 尝试事务回滚
     * @return
     * @throws Exception
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public List<User> getUserList() throws Exception {
        User user = new User();
        user.setAddress("Anhua");
        user.setAge(50);
        user.setUserName("PP");
        userDao.insertUser(user);
        if (1 == 1) {
            throw new Exception("aaa");
        }
        return userDao.getUserList();
    }
}
