package com.wj5633.ch07.mapper;

import com.wj5633.ch07.model.SysPrivilege;

import java.util.List;

/**
 * Created at 2019/7/8 16:50.
 *
 * @author wangjie
 * @version 1.0.0
 */

public interface PrivilegeMapper {

    List<SysPrivilege> selectPrivilegeByRoleId(Long roleId);
}
