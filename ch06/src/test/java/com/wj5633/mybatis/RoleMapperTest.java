package com.wj5633.mybatis;

import com.wj5633.ch06.mapper.RoleMapper;
import com.wj5633.ch06.model.SysRole;
import com.wj5633.ch06.type.Enabled;
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
