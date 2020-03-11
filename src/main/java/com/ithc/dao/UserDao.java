package com.ithc.dao;

import com.ithc.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    @Insert("insert into user(name,age) values(#{name},#{age})")
    public void insertUser(User user);

    @Select("select * from user")
    public List<User> findAll();

    @Select("select * from user where id=#{id}")
    public User findById(Integer id);

    @Update("update user set name=#{name},age=#{age} where id=#{id}")
    public void updateUser(User user);

    public void delete(Integer[] id);
}
