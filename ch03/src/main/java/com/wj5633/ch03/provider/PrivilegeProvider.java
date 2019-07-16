package com.wj5633.ch03.provider;

import org.apache.ibatis.jdbc.SQL;

/**
 * Created at 2019/7/8 21:23.
 *
 * @author wangjie
 * @version 1.0.0
 */

public class PrivilegeProvider {

    public String selectById(final Long id) {
        return new SQL() {
            {
                SELECT("id, privilege_name, privilege_url");
                FROM("sys_privilege");
                WHERE("id = #{id}");
            }
        }.toString();
    }

    public String selectById2(final Long id) {
        return "select id, privilege_name, privilege_url from sys_privilege where id = #{id}";
    }
}
