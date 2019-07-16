package com.wj5633.ch10.controller;

import com.wj5633.ch02.model.SysUser;
import com.wj5633.ch10.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created at 2019/7/10 19:03.
 *
 * @author wangjie
 * @version 1.0.0
 */

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/users/{id}")
    SysUser user(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @RequestMapping("/users")
    List<SysUser> users() {
        return userService.findAll();
    }
}
