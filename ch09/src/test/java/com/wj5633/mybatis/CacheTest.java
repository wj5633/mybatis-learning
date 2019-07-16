package com.wj5633.mybatis;

import com.wj5633.ch09.mapper.RoleMapper;
import com.wj5633.ch09.mapper.UserMapper;
import com.wj5633.ch09.model.SysRole;
import com.wj5633.ch09.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created at 2019/7/10 15:30.
 *
 * @author wangjie
 * @version 1.0.0
 */

public class CacheTest extends BaseMapperTest {

    @Test
    public void testL1Cache() {
        SysUser user1;
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            user1 = userMapper.selectById(1L);
            user1.setUserName("New Name");

            SysUser user2 = userMapper.selectById(1L);

            Assert.assertEquals("New Name", user2.getUserName());
            Assert.assertEquals(user1, user2);
        }

        System.out.println("开启新的 SqlSession");

        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            SysUser user2 = userMapper.selectById(1L);

            Assert.assertNotEquals("New Name", user2.getUserName());
            Assert.assertNotEquals(user1, user2);

            userMapper.deleteById(1L);

            SysUser user3 = userMapper.selectById(1L);
            Assert.assertNotEquals(user2, user3);
        }
    }

    @Test
    public void testL2Cache() {
        SysRole role1;
        try (SqlSession sqlSession = getSqlSession()) {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            role1 = roleMapper.selectById(1L);

            role1.setRoleName("New Name");

            SysRole role2 = roleMapper.selectById(1L);

            Assert.assertEquals("New Name", role2.getRoleName());
            Assert.assertEquals(role1, role2);
        }

        System.out.println("开启新的 SqlSession");

        try (SqlSession sqlSession = getSqlSession()) {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

            SysRole role2 = roleMapper.selectById(1L);

            Assert.assertEquals("New Name", role2.getRoleName());
            Assert.assertEquals(role1, role2);

            roleMapper.deleteById(1L);

            SysRole role3 = roleMapper.selectById(1L);
            Assert.assertNotEquals(role2, role3);
        }
    }
}
