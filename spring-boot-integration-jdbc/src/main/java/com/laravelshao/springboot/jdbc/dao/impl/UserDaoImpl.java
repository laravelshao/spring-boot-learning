package com.laravelshao.springboot.jdbc.dao.impl;

import com.laravelshao.springboot.jdbc.bean.User;
import com.laravelshao.springboot.jdbc.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shaoqinghua on 2018/6/5.
 */
@Repository
public class UserDaoImpl implements IUserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User queryUserById(int id) {
        String sql = "select * from tb_spring where id = ?";
        List<User> list = jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper(User.class));
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<User> queryUserList() {
        String sql = "select * from tb_spring";
        List<User> list = jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper(User.class));
        if (list != null && list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }

    @Override
    public int updateUserById(User user) {
        String sql = "update tb_spring set name = ?, mobile = ? where id = ?";
        return jdbcTemplate.update(sql, user.getName(), user.getMobile(), user.getId());
    }

    @Override
    public int insertUser(User user) {
        String sql = "insert into tb_spring(name,mobile) values(?, ?)";
        return jdbcTemplate.update(sql, user.getName(), user.getMobile());
    }

    @Override
    public int deleteUserById(int id) {
        String sql = "delete from tb_spring where id = ?";
        return jdbcTemplate.update(sql, id);
    }

}
