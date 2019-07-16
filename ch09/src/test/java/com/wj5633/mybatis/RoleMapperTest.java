package com.wj5633.mybatis;

import com.wj5633.ch09.interceptor.PageRowBounds;
import com.wj5633.ch09.mapper.RoleMapper;
import com.wj5633.ch09.model.SysRole;
import com.wj5633.ch09.type.Enabled;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created at 2019/7/10 14:54.
 *
 * @author wangjie
 * @version 1.0.0
 */

public class RoleMapperTest extends BaseMapperTest {

    @Test
    public void testSelectAllByRowBounds() {
        try (SqlSession sqlSession = getSqlSession()) {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            RowBounds rowBounds = new RowBounds(0, 1);
            List<SysRole> list = roleMapper.selectAll(rowBounds);
            list.forEach(sysRole -> System.out.println("角色名：" + sysRole.getRoleName()));

            System.out.println("===========================");

            PageRowBounds pageRowBounds = new PageRowBounds(0, 1);
            list = roleMapper.selectAll(pageRowBounds);
            System.out.println("查询总数: " + pageRowBounds.getTotal());
            list.forEach(sysRole -> System.out.println("角色名：" + sysRole.getRoleName()));
            pageRowBounds = new PageRowBounds(1, 1);
            list = roleMapper.selectAll(pageRowBounds);
            System.out.println("查询总数: " + pageRowBounds.getTotal());
            list.forEach(sysRole -> System.out.println("角色名：" + sysRole.getRoleName()));
            pageRowBounds = new PageRowBounds(2, 1);
            list = roleMapper.selectAll(pageRowBounds);
            System.out.println("查询总数: " + pageRowBounds.getTotal());
            list.forEach(sysRole -> System.out.println("角色名：" + sysRole.getRoleName()));

        }
    }

    @Test
    public void testSelectRoleByUserIdChoose() {
        try (SqlSession sqlSession = getSqlSession()) {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

            List<SysRole> roleList = roleMapper.selectRoleByUserIdChoose(1L);

            roleList.forEach(sysRole -> {
                System.out.println("角色名：" + sysRole.getRoleName());
                sysRole.getPrivilegeList().forEach(sysPrivilege ->
                        System.out.println("    权限名：" + sysPrivilege.getPrivilegeName()));
            });

            System.out.println("===========================");

            roleList = roleMapper.selectRoleByUserIdChoose(2L);

            roleList.forEach(sysRole -> {
                System.out.println("角色名：" + sysRole.getRoleName());
                sysRole.getPrivilegeList().forEach(sysPrivilege ->
                        System.out.println("    权限名：" + sysPrivilege.getPrivilegeName()));
            });
        }
    }


    @Test
    public void testUpdateById() {
        try (SqlSession sqlSession = getSqlSession()) {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

            SysRole sysRole = roleMapper.selectById(2L);

            Assert.assertEquals(Enabled.disabled, sysRole.getEnabled());

            System.out.println("===========================");

            sysRole.setEnabled(Enabled.enabled);

            roleMapper.updateById(sysRole);
        }
    }

}
