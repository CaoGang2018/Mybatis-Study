package dao;

import com.cao.dao.UserMapper;
import com.cao.pojo.User;
import com.cao.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author admin_cg
 * @date 2020/9/13 15:14
 */
public class UserTest {

    static Logger logger =  Logger.getLogger(UserTest.class);

    @Test
    public void getUserByLimit(){
        // 1 获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 方式一： 执行sql
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        Map<String, Integer> map = new HashMap<>();
        map.put("startIndex", 1);
        map.put("pageSize", 2);
        List<User> users = userDao.getUserByLimit(map);
        for (User user : users) {
            System.out.println(user);
        }

        // 关闭SqlSession
        sqlSession.close();
    }

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
    @Test
    public void testLog4j(){
        logger.info("info:进入testLog4j");
        logger.debug("debug:进入testLog4j");
        logger.error("error:进入testLog4j");
    }

}
