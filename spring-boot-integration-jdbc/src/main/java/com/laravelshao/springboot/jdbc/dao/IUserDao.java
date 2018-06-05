package com.laravelshao.springboot.jdbc.dao;

import com.laravelshao.springboot.jdbc.bean.User;

import java.util.List;

/**
 * Created by shaoqinghua on 2018/6/5.
 */
public interface IUserDao {

    int add(User user);

    int update(User user);

    int delete(int id);

    User findUserById(int id);

    List<User> findUserList();
}
