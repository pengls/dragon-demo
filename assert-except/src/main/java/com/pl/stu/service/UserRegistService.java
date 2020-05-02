package com.pl.stu.service;

import com.pl.stu.model.Response;
import com.pl.stu.model.ResponseEnum;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

/**
 * @ClassName: UserRegistService
 * @Description: 用户注册
 * @Author: pengl
 * @Date: 2020/5/1 22:54
 * @Version V1.0
 */
@Service
public class UserRegistService {

    public Response regist(String usname, String pwd) {

        boolean exist = "abc".equalsIgnoreCase(usname);
        ResponseEnum.USER_EXITS.isFalse(exist);

        boolean weakPass = Pattern.matches(".*[A-Za-z0-9]+.*", pwd);
        ResponseEnum.PASS_STRENGTH_LOW.isFalse(weakPass);

        return Response.ok();
    }
}
