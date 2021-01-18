package com.xiaoxie.gym.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * @create 2020-05-27  22:02
 */
@Api(tags = "hello接口")
@CrossOrigin
@RestController
public class helloController {

    @ApiOperation("hello")
    @PostMapping("/hello")
    public String hello(){
        return "hellossss";
    }
}
