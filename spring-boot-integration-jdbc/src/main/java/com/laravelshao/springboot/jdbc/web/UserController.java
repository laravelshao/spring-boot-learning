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

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/queryUserById/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") int id) {
        return userService.queryUserById(id);
    }

    /**
     * 查询用户信息列表
     *
     * @return
     */
    @RequestMapping(value = "/queryUserList", method = RequestMethod.GET)
    public List<User> queryUserList() {
        return userService.queryUserList();
    }

    /**
     * 根据id更新用户信息
     *
     * @param id
     * @param name
     * @param mobile
     * @return
     */
    @RequestMapping(value = "/updateUserById/{id}", method = RequestMethod.GET)
    public String updateUserById(@PathVariable("id") int id,
                                 @RequestParam(value = "name") String name,
                                 @RequestParam(value = "mobile") String mobile) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setMobile(mobile);
        int res = userService.updateUserById(user);
        if (res == 0) {
            return "update failed";
        }

        return "update success->" + user.toString();
    }

    /**
     * 添加用户信息
     *
     * @param name
     * @param mobile
     * @return
     */
    @RequestMapping(value = "/insertUserPost", method = RequestMethod.POST)
    public String insertUser(@RequestParam(value = "name") String name,
                             @RequestParam(value = "mobile") String mobile) {
        User user = new User();
        user.setName(name);
        user.setMobile(mobile);
        int res = userService.insertUser(user);
        if (res == 0) {
            return "insert failed";
        }

        return "insert success->" + user.toString();
    }

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteUserById/{id}", method = RequestMethod.GET)
    public String deleteUserById(@PathVariable("id") int id) {
        int res = userService.deleteUserById(id);
        if (res == 0) {
            return "delete failed";
        }

        return "delete success";
    }

}
