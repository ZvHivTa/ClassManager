package com.zht.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zht.pojo.User;
import com.zht.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;

//@CrossOrigin  //在服务器端支持跨域访问
//@RestController  //如果本类中全部都是ajax请求,则使用此注解,方法上的@ResponseBody可不写
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value="/login")
    @ResponseBody
    public String login(@RequestBody String userdata,
                        HttpSession session,
                        HttpServletResponse response){
        JSONObject jsonObject = JSON.parseObject(userdata, JSONObject.class);
        Integer account = jsonObject.getInteger("account");
        String password = jsonObject.getString("password");
        boolean autoLogin = jsonObject.getBoolean("autoLogin");
        User user = new User(account,password);
        User user1 = userService.login(user);
        String userJSON = null;
        Cookie cookie_account = null;
        Cookie cookie_type = null;
        if(user1!=null) {
            userJSON = JSON.toJSONString(user1);

            if (user1.getType() == 1) {
                session.setAttribute("USER_SESSION", user1);
            } else if (user1.getType() == 0) {
                session.setAttribute("MANAGER_SESSION", user1);
            }
            if (autoLogin) {
                cookie_account = new Cookie("account",user1.getAccount().toString());
                //默认跨域的cookie不能相互访问
                cookie_account.setPath("/");
                response.addCookie(cookie_account);

                cookie_type = new Cookie("type",user1.getType().toString());
                //默认跨域的cookie不能相互访问
                cookie_type.setPath("/");
                response.addCookie(cookie_type);

            }
        }
        return userJSON;
    }
}
