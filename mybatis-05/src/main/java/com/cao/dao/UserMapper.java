package com.cao.dao;

import com.cao.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author admin_cg
 * @date 2020/9/13 15:00
 */
public interface UserMapper {

    @Select("select * from user")
    List<User> getUsers();

}
