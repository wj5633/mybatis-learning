package com.wj5633.ch08.mapper;

import com.wj5633.ch08.model.SysUser;

import java.util.List;

/**
 * Created at 2019/7/8 16:45.
 *
 * @author wangjie
 * @version 1.0.0
 */

public interface UserMapper {

    SysUser selectById(Long id);

    int deleteById(Long id);

    List<SysUser> selectAll();

    SysUser selectUserAndRoleById(Long userId);

    SysUser selectUserAndRolesById(Long userId);

    SysUser selectUserAndRoleByIdSelect(Long id);
}
