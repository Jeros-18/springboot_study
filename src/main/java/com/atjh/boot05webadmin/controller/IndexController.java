package com.atjh.boot05webadmin.controller;

import com.atjh.boot05webadmin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    //去登录页
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if(StringUtils.hasLength(user.getUsername()) && "12345".equals(user.getPassword())){
                session.setAttribute("loginUser",user);
            //登录成功重定向到main.html,防止表单重复提交
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号密码错误");
            return "login";
        }



    }

    /*
    跳转页面，
    去main页面
     */
    @GetMapping("/main.html")
    public  String mainPage(HttpSession session,Model model){

//        Object loginUser = session.getAttribute("loginUser");
//        if(loginUser != null){
//            return "main";
//        }else {
//            model.addAttribute("msg","请重新登录");
//            return "login";
//        }
        return "main";

    }


}
