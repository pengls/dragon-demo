package com.pl.stu.controller;

import com.pl.stu.model.Response;
import com.pl.stu.service.UserRegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: UserRegistController
 * @Description: 用户注册服务
 * @Author: pengl
 * @Date: 2020/5/1 22:49
 * @Version V1.0
 */
@RestController
public class UserRegistController {
    @Autowired
    private UserRegistService registService;

    @GetMapping("/user/regist")
    public Response regist(@RequestParam String usname, @RequestParam(required = false) String pwd) {
        return registService.regist(usname, pwd);
    }
}
