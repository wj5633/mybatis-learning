package com.wj5633.ch06.mapper;

import com.wj5633.ch06.model.SysRole;

import java.util.List;

/**
 * Created at 2019/7/8 16:49.
 *
 * @author wangjie
 * @version 1.0.0
 */

public interface RoleMapper {

    List<SysRole> selectRoleByUserId(Long userId);

    List<SysRole> selectRoleByUserIdChoose(Long userId);

    SysRole selectById(Long id);

    int updateById(SysRole sysRole);
}
