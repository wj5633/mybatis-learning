package com.wj5633.ch07.mapper;

import com.wj5633.ch07.model.SysRole;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.CacheNamespaceRef;

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
}
