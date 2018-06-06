package com.laravelshao.springboot.jdbc.service.impl;

import com.laravelshao.springboot.jdbc.bean.User;
import com.laravelshao.springboot.jdbc.dao.IUserDao;
import com.laravelshao.springboot.jdbc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shaoqinghua on 2018/6/5.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User queryUserById(int id) {
        return userDao.queryUserById(id);
    }

    @Override
    public List<User> queryUserList() {
        return userDao.queryUserList();
    }

    @Override
    public int updateUserById(User user) {
        return userDao.updateUserById(user);
    }

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public int deleteUserById(int id) {
        return userDao.deleteUserById(id);
    }

}
