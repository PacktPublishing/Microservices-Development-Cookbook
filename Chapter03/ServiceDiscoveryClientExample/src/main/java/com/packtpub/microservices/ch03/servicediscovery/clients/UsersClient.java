package com.packtpub.microservices.ch03.servicediscovery.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Configuration
@EnableFeignClients
@EnableDiscoveryClient
public class UsersClient {

    @Autowired
    private Client client;

    @FeignClient("users-service")
    interface Client {
        @RequestMapping(path = "/followings/{userId}", method = RequestMethod.GET)
        @ResponseBody
        List<String> getFollowings(@PathVariable("userId") String userId);
    }

    public List<String> getFollowings(String userId) {
        return client.getFollowings(userId);
    }
}
