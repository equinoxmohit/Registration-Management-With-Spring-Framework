/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.registrationwithspring.controller;

import com.mohit.registrationwithspring.dao.UserDAO;
import com.mohit.registrationwithspring.entity.User;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Mohit
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    UserDAO userDao;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet() {
        return "login/login";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String doPost(User u) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(u.getPassword().getBytes(), 0, u.getPassword().length());
            String finalPassword = (new BigInteger(1, m.digest()).toString(16));
            u.setPassword(finalPassword);
            u = userDao.login(u.getUsername(), u.getPassword());
            if(u!=null)
            {
                return "redirect:/admin?success";
            }
        } catch (NoSuchAlgorithmException | ClassNotFoundException | SQLException ex) {

        }
          return "redirect:/?error";
    }
}
