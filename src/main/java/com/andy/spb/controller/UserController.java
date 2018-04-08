package com.andy.spb.controller;

import com.andy.spb.entity.User;
import com.andy.spb.service.UserService;
import com.andy.spb.vo.UserVO;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wusongjiang
 * @Description
 * @Date 2018-04-08 18:10
 */

@RestController
@EnableAutoConfiguration
@RequestMapping("/andy-spring")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/getUser")
    public UserVO getUser() {
        UserVO userVO = new UserVO();
        userVO.setAddress("Shanghai");
        userVO.setAge(31);
        userVO.setUserName("Andy");

        return userVO;
    }

    @RequestMapping("/getUserList")
    public List<User> getUserList() throws Exception{
        return userService.getUserList();
    }


}
