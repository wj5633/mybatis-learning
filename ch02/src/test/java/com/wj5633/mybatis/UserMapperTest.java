package com.wj5633.mybatis;

import com.wj5633.ch02.mapper.UserMapper;
import com.wj5633.ch02.model.SysRole;
import com.wj5633.ch02.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created at 2019/7/8 17:04.
 *
 * @author wangjie
 * @version 1.0.0
 */

public class UserMapperTest extends BaseMapperTest {

    @Test
    public void testSelectRolesByUserIdAndRoleEnabled() {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> userList = userMapper.selectRolesByUserIdAndRoleEnabled(1L, 1);
            userList.forEach(sysUser -> System.out.println(sysUser.toString()));
        }
    }

    @Test
    public void testDeleteById() {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = userMapper.selectById(1002L);
            System.out.println(sysUser.getUserName());

            int result = userMapper.deleteById(1002L);
            System.out.println(result);

            sysUser = userMapper.selectById(1002L);
            Assert.assertNull(sysUser);

//            sqlSession.commit();
        }
    }

    @Test
    public void testUpdateById() {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = userMapper.selectById(1L);
            System.out.println(sysUser.getUserName());

            sysUser.setUserName("admin_test");

            int result = userMapper.updateById(sysUser);
            System.out.println(result);

            sysUser = userMapper.selectById(1L);
            System.out.println(sysUser.getUserName());

        }
    }

    @Test
    public void testInsert() {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = new SysUser();
            sysUser.setId(1002L);
            sysUser.setUserName("test1");
            sysUser.setUserEmail("test1@wj5633.xyz");
            sysUser.setUserPassword("123456");
            sysUser.setUserInfo("test info");
            sysUser.setHeadImg(new byte[]{1, 2, 3});
            sysUser.setCreateTime(LocalDateTime.now());
            int result = userMapper.insert(sysUser);
            System.out.println(result);

            sqlSession.commit();
        }
    }

    @Test
    public void testInsert2() {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = new SysUser();
            sysUser.setUserName("test1");
            sysUser.setUserEmail("test1@wj5633.xyz");
            sysUser.setUserPassword("123456");
            sysUser.setUserInfo("test info");
            sysUser.setHeadImg(new byte[]{1, 2, 3});
            sysUser.setCreateTime(LocalDateTime.now());
            int result = userMapper.insert2(sysUser);
            System.out.println(result);

            System.out.println(sysUser.getId());

        }
    }

    @Test
    public void testInsert3() {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = new SysUser();
            sysUser.setUserName("test1");
            sysUser.setUserEmail("test1@wj5633.xyz");
            sysUser.setUserPassword("123456");
            sysUser.setUserInfo("test info");
            sysUser.setHeadImg(new byte[]{1, 2, 3});
            sysUser.setCreateTime(LocalDateTime.now());
            int result = userMapper.insert3(sysUser);
            System.out.println(result);

            System.out.println(sysUser.getId());

        }
    }

    @Test
    public void testSelectById() {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = userMapper.selectById(1L);

            System.out.println(user.toString());
        }
    }

    @Test
    public void testSelectAll() {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysUser> userList = userMapper.selectAll();
            userList.forEach(sysUser -> System.out.println(sysUser.toString()));
        }
    }

    @Test
    public void testSelectRolesByUserId() {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> userList = userMapper.selectRolesByUserId(1L);
            userList.forEach(sysUser -> System.out.println(sysUser.toString()));
        }
    }

}
