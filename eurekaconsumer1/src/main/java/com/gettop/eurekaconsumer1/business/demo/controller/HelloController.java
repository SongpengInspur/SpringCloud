package com.gettop.eurekaconsumer1.business.demo.controller;

import com.gettop.eurekaconsumer1.business.demo.model.User;
import com.gettop.eurekaconsumer1.business.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/hi")
    public User hi(@RequestParam String name)
    {
        System.out.println("hihihi************************");
        return helloService.hiService(name);
    }


}
