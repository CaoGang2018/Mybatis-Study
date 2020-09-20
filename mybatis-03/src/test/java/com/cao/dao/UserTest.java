package com.cao.dao;

import com.cao.pojo.User;
import com.cao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author admin_cg
 * @date 2020/9/13 15:14
 */
public class UserTest {

    @Test
    public void getUserList(){
        // 1 获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 方式一： 执行sql
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        User user = userDao.getUserById(1);

        System.out.println(user);
        // 关闭SqlSession
        sqlSession.close();
    }

}
