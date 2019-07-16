package com.wj5633.ch03.mapper;

import com.wj5633.ch03.model.SysPrivilege;
import com.wj5633.ch03.provider.PrivilegeProvider;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * Created at 2019/7/8 16:50.
 *
 * @author wangjie
 * @version 1.0.0
 */

public interface PrivilegeMapper {

    @SelectProvider(type = PrivilegeProvider.class, method = "selectById")
    SysPrivilege selectById(Long id);
}
