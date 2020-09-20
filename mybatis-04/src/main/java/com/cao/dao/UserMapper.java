package com.cao.dao;

import com.cao.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author admin_cg
 * @date 2020/9/13 15:00
 */
public interface UserMapper {

    // 获取全部查询
    List<User> getUserList();

    List<User> getUserByLimit(Map<String, Integer> map);

    // 根据id查询
    User getUserById(int id);

    //insert一个用户
    int addUser(User user);

    // 修改用户
    int updateUser(User user);

    // 删除用户
    int deleteUser(int id);
}
