package com.andy.spb.dao;

import com.andy.spb.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author wusongjiang
 * @Description
 * @Date 2018-04-08 18:57
 */
@Mapper
public interface UserMapper {
    @Select("select * from address_user_info")
    @Results(value = {
            @Result(property = "userName", column = "name")
    })
    public List<User> getUserList();


    @Insert("insert into address_user_info(name, age, address) values (#{userName}, #{age}, #{address})")
    public int insertUser(User user);

}
