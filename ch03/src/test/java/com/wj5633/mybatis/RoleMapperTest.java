package com.wj5633.mybatis;

import com.wj5633.ch03.mapper.RoleMapper;
import com.wj5633.ch03.model.SysRole;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

/**
 * Created at 2019/7/8 17:04.
 *
 * @author wangjie
 * @version 1.0.0
 */

public class RoleMapperTest extends BaseMapperTest {


    @Test
    public void testSelectById() {
        try (SqlSession sqlSession = getSqlSession()) {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole role = roleMapper.selectById(1L);

            System.out.println(role);

            SysRole role2 = roleMapper.selectById2(2L);
            System.out.println(role2);
        }
    }

    @Test
    public void testInsert2() {
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("test_role");
        sysRole.setEnabled(true);
        sysRole.setCreateBy(1L);
        sysRole.setCreateTime(LocalDateTime.now());

        try (SqlSession sqlSession = getSqlSession()) {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            int result = roleMapper.insert2(sysRole);

            System.out.println(result);
            System.out.println(sysRole.getId());

            sqlSession.commit();
        }
    }

    @Test
    public void testUpdateById() {

        try (SqlSession sqlSession = getSqlSession()) {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole sysRole = roleMapper.selectById(4L);

            sysRole.setRoleName("test_update");

            int result = roleMapper.updateById(sysRole);

            System.out.println(result);

            sqlSession.commit();
        }
    }

    @Test
    public void testDeleteById() {

        try (SqlSession sqlSession = getSqlSession()) {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            SysRole sysRole = roleMapper.selectById(4L);

            System.out.println(sysRole.getRoleName());

            int result = roleMapper.deleteById(4L);
            System.out.println(result);

            sysRole = roleMapper.selectById(4L);
            Assert.assertNull("sys_role is null", sysRole);
            sqlSession.commit();
        }
    }
}
