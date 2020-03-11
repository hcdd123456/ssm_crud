package com.ithc.service.Impl;

import com.ithc.dao.UserDao;
import com.ithc.entity.User;
import com.ithc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void insertUser(User user) {
//        System.out.println("Service插入数据");
        if(user.getId()!=null){
            userDao.updateUser(user);
        }else {
            userDao.insertUser(user);
        }
    }

    @Override
    public List<User> findAll() {
//        System.out.println("Service查询全部");
        return userDao.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public void delete(Integer[] id) {
        userDao.delete(id);
    }
}
