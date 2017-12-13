package com.passerbywhu.web;

import com.passerbywhu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WelComeController {
    @Autowired
    UserService userService;

    @RequestMapping("/index.html")
    public String login(HttpServletRequest request) {
        System.out.println(request.getLocalAddr());
        return "index";
    }

    @RequestMapping("/crackPassword.html")
    public ModelAndView crack(HttpServletRequest request, String userName) {
        String password = userService.crackPassword(userName);
        return new ModelAndView("crackResult", "password", password);
    }
}
