package com.ithc.service;

import com.ithc.entity.User;

import java.util.List;

public interface UserService {

    public void insertUser(User user);

    public List<User> findAll();

    public User findById(Integer id);

    public void delete(Integer[] id);
}
