package com.gettop.eurekaprovider2;

import com.gettop.eurekaprovider2.demo.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient //表明自己属于一个生产者。
@RestController
public class EurekaProvider2Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProvider2Application.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam String name)
    {
        return "hi " + name + ",i am from port:" + port;
    }

    @RequestMapping("/hello")
    public User hello(@RequestParam String name)
    {
        return new User(2, name, 32);
    }


}
