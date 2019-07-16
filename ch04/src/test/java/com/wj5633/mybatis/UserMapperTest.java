package com.wj5633.mybatis;

import com.wj5633.ch04.mapper.UserMapper;
import com.wj5633.ch04.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created at 2019/7/8 21:44.
 *
 * @author wangjie
 * @version 1.0.0
 */

public class UserMapperTest extends BaseMapperTest {

    @Test
    public void testSelectByUser() {

        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            SysUser query = new SysUser();
            query.setUserName("ad");

            List<SysUser> userList = userMapper.selectByUser(query);
            userList.forEach(System.out::println);

            System.out.println("===>>>");

            query = new SysUser();
            query.setUserName("ad");
            query.setUserEmail("test@wj5633.xyz");

            userList = userMapper.selectByUser(query);
            Assert.assertEquals(0, userList.size());
        }
    }

    @Test
    public void testUpdateByIdSelective() {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            SysUser user = new SysUser();
            user.setId(1001L);
            user.setUserEmail("test_update@wj5633.xyz");

            int result = userMapper.updateByIdSelective(user);

            user = userMapper.selectById(1001L);

            System.out.println(user.getUserEmail());
        }
    }

    @Test
    public void testInsert2() {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            SysUser user = new SysUser();
            user.setUserName("test-selective");
            user.setUserPassword("123456");
            user.setUserEmail("test@wj5633.xyz");
            user.setUserInfo("test info");
            user.setCreateTime(LocalDateTime.now());

            userMapper.insert2(user);

            user = userMapper.selectById(user.getId());

            Assert.assertNull("head_img is null", user.getHeadImg());
        }
    }
}
