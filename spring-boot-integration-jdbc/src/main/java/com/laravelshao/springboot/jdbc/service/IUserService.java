package com.laravelshao.springboot.jdbc.service;

import com.laravelshao.springboot.jdbc.bean.User;

import java.util.List;

/**
 * Created by shaoqinghua on 2018/6/5.
 */
public interface IUserService {

    User queryUserById(int id);

    List<User> queryUserList();

    int updateUserById(User user);

    int insertUser(User user);

    int deleteUserById(int id);

}
