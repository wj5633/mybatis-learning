package com.wj5633.mybatis;

import com.wj5633.ch08.mapper.UserMapper;
import com.wj5633.ch08.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created at 2019/7/8 21:44.
 *
 * @author wangjie
 * @version 1.0.0
 */

public class UserMapperTest extends BaseMapperTest {


    @Test
    public void testSelectAll() {
        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<SysUser> userList = userMapper.selectAll();
            userList.forEach(sysUser -> System.out.println(sysUser.toString()));
        }
    }

    @Test
    public void testSelectUserAndRoleById() {

        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            SysUser sysUser = userMapper.selectUserAndRoleById(1001L);

            System.out.println(sysUser);
        }
    }

    @Test
    public void testSelectUserAndRolesById() {

        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            SysUser sysUser = userMapper.selectUserAndRolesById(1L);

            System.out.println("用户名：" + sysUser.getUserName());
            sysUser.getRoleList().forEach(sysRole -> {
                System.out.println("    角色名：" + sysRole.getRoleName());
                sysRole.getPrivilegeList().forEach(sysPrivilege -> {
                    System.out.println("        权限名：" + sysPrivilege.getPrivilegeName());
                });
            });
        }
    }


    @Test
    public void testSelectUserAndRolesByIdSelect() {

        try (SqlSession sqlSession = getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            SysUser sysUser = userMapper.selectUserAndRoleByIdSelect(1L);

            System.out.println("用户名：" + sysUser.getUserName());
            sysUser.getRoleList().forEach(sysRole -> {
                System.out.println("    角色名：" + sysRole.getRoleName());
                sysRole.getPrivilegeList().forEach(sysPrivilege -> {
                    System.out.println("        权限名：" + sysPrivilege.getPrivilegeName());
                });
            });
        }
    }
}
