package com.soul.controller;

import com.soul.entity.Users;
import com.soul.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequestMapping("/admin")
@Controller
public class LoginController {
    //定义后台登录对象
    @Autowired
    private UsersService usersService;
    @RequestMapping("loginShow")
    public String login(){
        return "login";
    }
    @RequestMapping("/loginSubmit")
    public String loginSubmit(Users users, Model model, HttpSession session){
        Users u = usersService.login(users);
        if (u==null){
            model.addAttribute("err","用户名或密码不正确");
            return "login";
        }

        //将登录的账号对象存入session，用于会话跟踪管理
            session.setAttribute("adminUser",u);
            return "index";
        }

}
