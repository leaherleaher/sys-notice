package com.ttg.service.notice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title: Hello</p>
 * <p>Description: </p>
 *
 * @Author yangtao
 * @Date 2018/9/11 10:23
 */
@RestController
@RequestMapping(value="/")
public class Hello {

    @RequestMapping(value="/hello")
    public String hello(){
        System.out.println("1324");
        return "hello";
    }
}
