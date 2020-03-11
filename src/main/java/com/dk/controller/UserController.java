package com.dk.controller;

import com.dk.pojo.User;
import com.dk.service.UserServiceI;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 孙亚东
 */
@Controller
@RequestMapping("userController")
public class UserController {

    @Resource
    private UserServiceI userServiceI;

    /**
     * 跳转到查询页
     * @return
     */
    @RequestMapping("toUserPage")
    public String toUserPage(){
        return "user/list";
    }

    /**
     * 查询
     */
    @RequestMapping("findAll")
    @ResponseBody
    public List<User> findAll(){
        List<User> userList = userServiceI.findAll();
        return userList;
    }

    /**
     * 跳转到添加页
     */
    @RequestMapping("toAdd")
    public String toAdd(){
        return "user/save";
    }

    /**
     * 增加
     */
    @RequestMapping("insert")
    @ResponseBody
    public boolean insert(User user){
        try {
            userServiceI.insert(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }


    /**
     * 修改回显
     */
    @RequestMapping("toUpdate")
    public String toUpdate(Integer id, Model model){
        User user = userServiceI.findById(id);
        model.addAttribute("user", user);
        return "user/update";
    }

    /**
     * 修改
     */
    @RequestMapping("update")
    @ResponseBody
    public boolean update(User user){
        try {
            userServiceI.update(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 删除
     */
    @RequestMapping("deleteById")
    @ResponseBody
    public boolean deleteById(Integer id){
        try {
            userServiceI.delete(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
