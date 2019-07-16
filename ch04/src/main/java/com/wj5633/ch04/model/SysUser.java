package com.wj5633.ch04.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created at 2019/7/8 16:35.
 *
 * @author wangjie
 * @version 1.0.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser {
    private Long id;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userInfo;
    private byte[] headImg;
    private LocalDateTime createTime;
}
