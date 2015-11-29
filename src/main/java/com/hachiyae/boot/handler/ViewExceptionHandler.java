package com.hachiyae.boot.handler;

import com.hachiyae.boot.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice(annotations = Controller.class)
public class ViewExceptionHandler {
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(ServiceException.class)
    public ModelAndView serviceExceptionErrorHandler(HttpServletRequest req, HttpServletResponse res, Exception e) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("message", e.getMessage());
        map.put("status", HttpStatus.BAD_REQUEST);
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

    @ResponseStatus
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public String defaultErrorHandler(Model model, HttpServletRequest req, HttpServletResponse res, Exception e) throws Exception {
        model.addAttribute("message", e.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
        return "error";
    }
}
