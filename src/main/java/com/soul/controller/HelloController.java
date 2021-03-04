package com.soul.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping("/")
@ResponseBody
    public String index(){
        return "欢迎访问我的项目<br/><a href='/admin/loginShow'>访问后台</a>";
    }
}
