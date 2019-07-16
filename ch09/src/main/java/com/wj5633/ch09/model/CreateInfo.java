package com.wj5633.ch09.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created at 2019/7/9 11:24.
 *
 * @author wangjie
 * @version 1.0.0
 */

@Data
public class CreateInfo {
    private Long createBy;
    private LocalDateTime createTime;
}
