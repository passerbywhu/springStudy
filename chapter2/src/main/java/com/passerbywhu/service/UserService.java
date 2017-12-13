package com.passerbywhu.service;

import com.passerbywhu.dao.UserDao;
import com.passerbywhu.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    public String crackPassword(String userName) {
        User user = userDao.findUserByUserName(userName);
        if (user != null && user.password != null && !user.password.trim().equals("")) {
            return user.password;
        }
        return "crack failed";
    }
}
