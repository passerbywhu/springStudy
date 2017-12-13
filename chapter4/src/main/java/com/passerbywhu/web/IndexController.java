package com.passerbywhu.web;

import com.passerbywhu.domain.Boss;
import com.passerbywhu.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class IndexController {
    @Autowired
    private Car car;
    @Autowired
    private Boss boss;

    @RequestMapping(value = {"/", "/index.html"})
    public ModelAndView welcome(HttpServletRequest request) {
        return new ModelAndView("resource", "boss", boss);
    }

}
