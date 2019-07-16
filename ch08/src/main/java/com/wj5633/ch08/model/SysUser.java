package com.wj5633.ch08.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    private SysRole role;

    private List<SysRole> roleList = new ArrayList<>();
}
