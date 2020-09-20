package com.cao.dao;

import com.cao.pojo.User;

import java.util.List;

/**
 * @author admin_cg
 * @date 2020/9/13 15:00
 */
public interface UserMapper {

    // 获取全部查询
    List<User> getUserList();

    // 根据id查询
    User getUserById(int id);

    //insert一个用户
    int addUser(User user);

    // 修改用户
    int updateUser(User user);

    // 删除用户
    int deleteUser(int id);
}
