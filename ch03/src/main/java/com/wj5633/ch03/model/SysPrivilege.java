package com.wj5633.ch03.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created at 2019/7/8 16:43.
 *
 * @author wangjie
 * @version 1.0.0
 */

@Data
public class SysPrivilege {
    private Long id;
    private String privilegeName;
    private String privilegeUrl;
    private LocalDateTime createTime;
}
