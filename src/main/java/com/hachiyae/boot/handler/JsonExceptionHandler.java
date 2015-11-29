package com.hachiyae.boot.handler;

import com.hachiyae.boot.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice(annotations = RestController.class)
public class JsonExceptionHandler {

    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(ServiceException.class)
    public Map<String, Object> serviceExceptionErrorHandler(HttpServletRequest req, HttpServletResponse res, Exception e) throws Exception {
        log.debug(e.getMessage(), e);
        Map<String, Object> map = new HashMap<>();
        map.put("message", e.getMessage());
        map.put("status", HttpStatus.BAD_REQUEST);
        return map;
    }

    @ResponseStatus
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, HttpServletResponse res, Exception e) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("message", e.getMessage());
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView(), map);
        return mv;
    }
}
