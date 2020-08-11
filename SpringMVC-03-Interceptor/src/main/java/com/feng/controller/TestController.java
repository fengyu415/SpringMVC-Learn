package com.feng.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/t1")
    public String testFunction()
    {
        System.out.println("============执行testFunction()====================");
        return  "OK";
    }
}
