package com.andy.spb.service;

import com.andy.spb.entity.User;

import java.util.List;

/**
 * @author wusongjiang
 * @Description
 * @Date 2018-04-08 19:27
 */
public interface UserService {

    public List<User> getUserList() throws Exception;
}
