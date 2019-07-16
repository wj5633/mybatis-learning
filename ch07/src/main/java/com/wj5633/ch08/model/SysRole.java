package com.wj5633.ch07.model;

import com.wj5633.ch07.type.Enabled;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created at 2019/7/8 16:42.
 *
 * @author wangjie
 * @version 1.0.0
 */

@Data
public class SysRole {
    private Long id;
    private String roleName;
    private Enabled enabled;
    private CreateInfo createInfo;

    private List<SysPrivilege> privilegeList = new ArrayList<>();
}
