package com.wj5633.mybatis;

import com.wj5633.ch03.mapper.PrivilegeMapper;
import com.wj5633.ch03.model.SysPrivilege;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created at 2019/7/8 21:27.
 *
 * @author wangjie
 * @version 1.0.0
 */

public class PrivilegeMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById() {
        try (SqlSession sqlSession = getSqlSession()) {
            PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);
            SysPrivilege sysPrivilege = privilegeMapper.selectById(1L);

            Assert.assertNotNull(sysPrivilege);
            Assert.assertEquals("用户管理", sysPrivilege.getPrivilegeName());
        }
    }
}
