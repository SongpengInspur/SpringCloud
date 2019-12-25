package com.gettop.eurekaprovider1;

import com.gettop.eurekaprovider1.demo.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient //表明自己属于一个生产者
@RestController
public class Eurekaprovider1Application {

    public static void main(String[] args) {
        SpringApplication.run(Eurekaprovider1Application.class, args);
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
        /*Map<String, Object> map = new HashMap<>();
        User user = new User(1, name, 23);
        map.put("user", map);
        map.put("hello", "world");*/

        return new User(1, name, 23);
    }

}
