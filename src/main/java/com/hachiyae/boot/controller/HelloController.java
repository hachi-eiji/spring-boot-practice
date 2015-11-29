package com.hachiyae.boot.controller;

import com.hachiyae.boot.exception.ServiceException;
import com.hachiyae.boot.serivce.MemcacheService;
import com.hachiyae.boot.serivce.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class HelloController {
    @Autowired
    private TestService testService;
    @Autowired
    private MemcacheService memcacheService;

    @RequestMapping(value = "/test/{id}")
    public Map<String, Object> test(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", testService.find(id));
        return map;
    }

    @RequestMapping(value = "/mem/{key}/{value}", method = RequestMethod.PUT)
    public String store(@PathVariable String key, @PathVariable String value) {
        return "success";
    }

    @RequestMapping(value = "/mem/{key}/i/{value}", method = RequestMethod.PUT)
    public String store2(@PathVariable String key, @PathVariable Integer value) {
        memcacheService.set(key, value);
        return "success";
    }

    @RequestMapping(value = "/mem/{key}", method = RequestMethod.GET)
    public String getFromCache(@PathVariable String key) {
        return memcacheService.get(key, String.class);
    }

    @RequestMapping(value = "/e")
    public String throwServiceException() {
        throw new ServiceException("error");
    }

    @RequestMapping(value = "/e2")
    public String nullexception() {
        String str = null;
        str.equals("hoge");
        return "a";
    }
}
