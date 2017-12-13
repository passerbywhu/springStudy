package com.passerbywhu.web;

import com.passerbywhu.domain.User;
import com.passerbywhu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CrackController {
    private UserService userService;

    @RequestMapping(value = {"/", "/index.html"})
    public ModelAndView loginPage() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request) {
        User user  = userService.findUserByUserName("");
        return new ModelAndView("");
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
