package com.fh.controller;

import com.fh.model.ServerResponse;
import com.fh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description: TODO
 * @Author 马传洲
 * @Date 2020/1/13
 * @Version V1.0
 **/
@RestController
@RequestMapping("User")
public class UserController {
    @Autowired
    private UserService userService;
    //用户验证登录
    @RequestMapping("login")
    public ServerResponse login(String userName, String password){
        try {
            ServerResponse serverResponse=userService.login(userName,password);
            return serverResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.error();
        }

    }

}
