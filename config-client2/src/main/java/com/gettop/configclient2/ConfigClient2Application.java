package com.gettop.configclient2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConfigClient2Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClient2Application.class, args);
    }


    @RequestMapping(value = "/world")
    public String helloWorld() {
        System.out.println("hello world!");
        return "index";
    }
}
