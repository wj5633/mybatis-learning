package com.wj5633.ch10.service;

import com.wj5633.ch02.model.SysUser;

import java.util.List;

/**
 * Created at 2019/7/10 19:01.
 *
 * @author wangjie
 * @version 1.0.0
 */

public interface UserService {

    SysUser findById(Long id);

    List<SysUser> findAll();

}
