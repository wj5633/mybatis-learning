package com.wj5633.ch09.mapper;

import com.wj5633.ch09.model.SysRole;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created at 2019/7/8 16:49.
 *
 * @author wangjie
 * @version 1.0.0
 */

//@CacheNamespace
@CacheNamespaceRef(RoleMapper.class)
public interface RoleMapper {

    List<SysRole> selectRoleByUserId(Long userId);

    List<SysRole> selectRoleByUserIdChoose(Long userId);

    SysRole selectById(Long id);

    int updateById(SysRole sysRole);

    int deleteById(Long id);

    @ResultMap("roleMap")
    @Select("select * from sys_role")
    List<SysRole> selectAll();

    List<SysRole> selectAll(RowBounds rowBounds);
}
