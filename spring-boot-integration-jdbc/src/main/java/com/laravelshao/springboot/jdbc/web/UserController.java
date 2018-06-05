package com.laravelshao.springboot.jdbc.web;

import com.laravelshao.springboot.jdbc.bean.User;
import com.laravelshao.springboot.jdbc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by shaoqinghua on 2018/6/5.
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.findUserList();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") int id) {
        return userService.findUserById(id);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable("id") int id,
                             @RequestParam(value = "name", required = true) String name,
                             @RequestParam(value = "mobile", required = true) String mobile) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setMobile(mobile);
        int t = userService.update(user);
        if (t == 1) {
            return user.toString();
        } else {
            return "fail";
        }
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUserPost(@RequestParam(value = "name") String name,
                              @RequestParam(value = "mobile") String mobile) {
        User user = new User();
        user.setName(name);
        user.setMobile(mobile);
        int t = userService.add(user);
        if (t == 1) {
            return user.toString();
        } else {
            return "fail";
        }
    }

}
