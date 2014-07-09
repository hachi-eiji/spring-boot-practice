package com.hachiyae.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hachiyae.service.TestService;

@RestController
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.hachiyae")
public class HelloController {
    @Autowired
    private TestService testService;

    @RequestMapping(value = "/test/{id}")
    public Map<String, Object> test(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", testService.find(id));
        return map;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloController.class, args);
    }
}
