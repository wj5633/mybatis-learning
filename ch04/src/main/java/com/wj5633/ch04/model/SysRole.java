package com.wj5633.ch04.model;

import lombok.Data;

import java.time.LocalDateTime;

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
    private Boolean enabled;
    private Long createBy;
    private LocalDateTime createTime;

    private SysUser user;
}
