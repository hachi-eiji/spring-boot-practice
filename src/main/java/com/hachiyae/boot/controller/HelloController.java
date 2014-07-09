package com.hachiyae.boot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hachiyae.boot.serivce.TestService;


@RestController
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.hachiyae.boot.repository")
@EntityScan(basePackages = "com.hachiyae.boot.entity")
@ComponentScan(basePackages = "com.hachiyae.boot")
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
