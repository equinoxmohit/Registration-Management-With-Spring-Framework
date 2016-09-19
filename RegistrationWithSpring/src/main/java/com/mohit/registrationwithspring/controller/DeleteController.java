/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.registrationwithspring.controller;

import com.mohit.registrationwithspring.dao.UserDAO;
import com.mohit.registrationwithspring.entity.User;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Mohit
 */
@Controller
@RequestMapping(value = "/delete")
public class DeleteController {

    @Autowired
    UserDAO userDao;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String doGet(@PathVariable("id") int id,User user) {
        try{
        if(userDao.delete(id)>0)
        {
            return "redirect:/admin?success";
        }
        }catch(SQLException|ClassNotFoundException ex)
        {
        
        }
        return "redirect:/admin?delete";
    }

}
