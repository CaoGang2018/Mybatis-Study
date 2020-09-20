package com.cao.dao;

import com.cao.pojo.User;
import com.cao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author admin_cg
 * @date 2020/9/13 15:14
 */
public class UserTest {

    @Test
    public void getUserLike(){
        // 1 获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 方式一： 执行sql
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.getUserLike("%李%");

        for (User user : userList){
            System.out.println(user);
        }
        // 关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void test(){
        // 1 获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 方式一： 执行sql
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.getUserList();

        for (User user : userList){
            System.out.println(user);
        }
        // 关闭SqlSession
        sqlSession.close();
    }
    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }
    // 增删改需要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.addUser(new User(4, "小狗", "3333333"));
        if(res > 0)
            System.out.println("insert success");

        // 提交事务
        sqlSession.commit();

        sqlSession.close();
    }
    @Test
    public void addUserByMap(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("userid", 6);
        map.put("username", "阿狗");
        map.put("passward", "123453");
        int res = mapper.addUser2(map);
        if(res > 0)
            System.out.println("insert by map success");

        // 提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.updateUser(new User(4, "小猪", "3433333"));
        if(res > 0)
            System.out.println("update success");

        // 提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.deleteUser(4);
        if(res > 0)
            System.out.println("delete success");

        // 提交事务
        sqlSession.commit();

        sqlSession.close();
    }

}
