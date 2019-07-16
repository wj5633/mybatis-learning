package com.wj5633.ch03.mapper;

import com.wj5633.ch03.model.SysRole;
import com.wj5633.ch03.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created at 2019/7/8 16:45.
 *
 * @author wangjie
 * @version 1.0.0
 */

public interface UserMapper {


    SysUser selectById(Long id);

    List<SysUser> selectAll();

    List<SysRole> selectRolesByUserId(Long userId);

    int insert(SysUser sysUser);

    int insert2(SysUser sysUser);

    int insert3(SysUser sysUser);

    int updateById(SysUser sysUser);

    int deleteById(Long id);

    List<SysRole> selectRolesByUserIdAndRoleEnabled(
            @Param("userId") Long userId,
            @Param("enabled") Integer enabled);
}
