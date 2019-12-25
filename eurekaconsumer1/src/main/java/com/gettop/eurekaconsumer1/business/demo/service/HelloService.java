package com.gettop.eurekaconsumer1.business.demo.service;

import com.gettop.eurekaconsumer1.business.demo.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    // 断路器配置，当无法调用如下方法时，就会调用自定的hiError方法。
    @HystrixCommand(fallbackMethod = "hiError")
    public User hiService(String name) {
        //return restTemplate.getForObject("http://SERVICE-PROVIDER1/hi?name=" + name, String.class);

        User user = restTemplate.getForObject("http://SERVICE-PROVIDER/hello?name=" + name, User.class);
        System.out.println(user.getAge());
        return user;
    }

    public User hiError(String name)
    {
        return new User(3, "there is some problem with hi page", 10);
    }


}
