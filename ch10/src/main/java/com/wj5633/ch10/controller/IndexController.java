package com.wj5633.ch10.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created at 2019/7/10 18:08.
 *
 * @author wangjie
 * @version 1.0.0
 */

@RestController
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "Hello Mybatis!";
    }
}
