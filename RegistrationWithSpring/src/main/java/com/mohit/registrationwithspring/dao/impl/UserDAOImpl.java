/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.registrationwithspring.dao.impl;

import com.mohit.registrationwithspring.dao.UserDAO;
import com.mohit.registrationwithspring.entity.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mohit
 */
@Repository(value = "userDao")
public class UserDAOImpl implements UserDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int insert(User u) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO tbl_registration(first_name,last_name,username,email,password)" + "VALUES(?,?,?,?,?)";

        return jdbcTemplate.update(sql, new Object[]{
            u.getFirstName(),
            u.getLastName(),
            u.getUsername(),
            u.getEmail(),
            u.getPassword()});
    }

    @Override
    public List<User> getAll() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM tbl_registration";
        return jdbcTemplate.query(sql, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User u = new User();
                u.setId(rs.getInt("registration_id"));
                u.setFirstName(rs.getString("first_name"));
                u.setLastName(rs.getString("last_name"));
                u.setUsername(rs.getString("username"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                return u;
            }
        });
    }

    @Override
    public User getById(int id) throws SQLException, ClassNotFoundException {

        String sql = "SELECT * FROM tbl_registration WHERE registration_id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User u = new User();
                u.setId(rs.getInt("registration_id"));
                u.setFirstName(rs.getString("first_name"));
                u.setLastName(rs.getString("last_name"));
                u.setUsername(rs.getString("username"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                return u;
            }
        });
    }

    @Override
    public User login(String username, String password) throws SQLException, ClassNotFoundException {
        for (User u : getAll()) {
            if (((u.getUsername().equals(username)) && (u.getPassword().equals(password)))) {
                return u;
            }
        }
        return null;
    }

    @Override
    public int delete(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM tbl_registration WHERE registration_id=?";
        return jdbcTemplate.update(sql, new Object[]{id});
    }

    @Override
    public int update(User u) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE tbl_registration SET first_name=?,last_name=?,username=?,email=?,password=? WHERE id=?";
        return jdbcTemplate.update(sql, new Object[]{
            u.getFirstName(),
            u.getLastName(),
            u.getUsername(),
            u.getEmail(),
            u.getPassword(),
            u.getId()
        });
    }
}
