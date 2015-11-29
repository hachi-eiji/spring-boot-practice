package com.hachiyae.boot.controller;

import com.hachiyae.boot.exception.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class ViewController {
    @RequestMapping("/view")
    public String hello(Map<String, Object> model) {
        model.put("message", "hello");
        return "view";
    }

    @RequestMapping("/view/er")
    public String er(Map<String, Object> model) {
        String str = null;
        str.equals("hoge");
        return "view";
    }

    @RequestMapping("/view/er2")
    public String er2(Map<String, Object> model) {
        throw new ServiceException("test");
    }
}
