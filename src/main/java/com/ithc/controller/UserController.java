package com.ithc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ithc.entity.User;
import com.ithc.service.UserService;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    private Map<String,Object> result=new HashMap<>();

    /**
     * 保存
     * @param user
     * @return
     */
    @RequestMapping("/save")
    public Map<String,Object> save(User user) {
        try {
            userService.insertUser(user);
            result.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success",false);
            result.put("msg",e.getMessage());
        }
        return result;
    }

    /**
     * 分页查询
     */
    @RequestMapping("/findAllByPage")
    public Map<String,Object> listByPage(Integer page,Integer rows){
        PageHelper.startPage(page,rows);
        List<User> list=userService.findAll();
        PageInfo<User> pageInfo=new PageInfo<>(list);
        long total = pageInfo.getTotal();
        List<User> UserList = pageInfo.getList();
        result.put("total",total);
        result.put("rows",UserList);
        return result;
    }

    /**
     * 根据id查找
     */
    @RequestMapping("/findById")
    public User findById(Integer id){
        User user= userService.findById(id);
        return user;
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public Map<String,Object> delete(Integer[] id){
        try {
            userService.delete(id);
            result.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success",false);
            result.put("msg",e.getMessage());
        }
        return result;
    }
}
