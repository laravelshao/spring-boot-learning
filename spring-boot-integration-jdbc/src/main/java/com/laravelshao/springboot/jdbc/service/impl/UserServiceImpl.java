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
    public int add(User user) {
        return userDao.add(user);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public int delete(int id) {
        return userDao.delete(id);
    }

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public List<User> findUserList() {
        return userDao.findUserList();
    }
}
