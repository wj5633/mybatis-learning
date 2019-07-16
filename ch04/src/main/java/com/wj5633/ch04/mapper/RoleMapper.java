package com.wj5633.ch04.mapper;

import com.wj5633.ch04.model.SysRole;
import org.apache.ibatis.annotations.*;

/**
 * Created at 2019/7/8 16:49.
 *
 * @author wangjie
 * @version 1.0.0
 */

public interface RoleMapper {

    @Select({"select id,role_name as roleName, enabled,create_by as createBy, ",
            "create_time as createTime from sys_role where id = #{id}"})
    SysRole selectById(Long id);


    @Results(id = "roleMap", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "roleName", column = "role_name"),
            @Result(property = "enabled", column = "enabled"),
            @Result(property = "createBy", column = "create_by"),
            @Result(property = "createTime", column = "create_time")
    })
    @Select({"select id,role_name, enabled,create_by, create_time from sys_role where id = #{id}"})
    SysRole selectById2(Long id);

    @Insert({"insert into sys_role(id, role_name, enabled, create_by, create_time)",
            "values(#{id}, #{roleName}, #{enabled}, #{createBy}, #{createTime})"})
    int insert(SysRole sysRole);

    @Insert({"insert into sys_role(role_name, enabled, create_by, create_time)",
            "values(#{roleName}, #{enabled}, #{createBy}, #{createTime})"})
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert2(SysRole sysRole);

    @Insert({"insert into sys_role(role_name, enabled, create_by, create_time)",
            "values(#{roleName}, #{enabled}, #{createBy}, #{createTime})"})
    @SelectKey(statement = "select LAST_INSERT_ID()",
            keyProperty = "id", resultType = Long.class, before = false
    )
    int insert3(SysRole sysRole);


    @Update({"update sys_role",
            "set role_name = #{roleName}, enabled = #{enabled}, create_by = #{createBy}, create_time = #{createTime}",
            "where id = #{id}"})
    int updateById(SysRole sysRole);

    @Delete({"delete from sys_role where id = #{id}"})
    int deleteById(Long id);
}
