package com.wj5633.ch10.service.impl;

import com.wj5633.ch02.mapper.UserMapper;
import com.wj5633.ch02.model.SysUser;
import com.wj5633.ch10.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created at 2019/7/10 19:02.
 *
 * @author wangjie
 * @version 1.0.0
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public SysUser findById(Long id) {
        SysUser sysUser = userMapper.selectById(id);
        if (sysUser == null) {
            sysUser = new SysUser();
            sysUser.setId(0L);
            sysUser.setUserName("非法用户");
        }
        return sysUser;
    }

    @Override
    public List<SysUser> findAll() {
        return userMapper.selectAll();
    }
}
