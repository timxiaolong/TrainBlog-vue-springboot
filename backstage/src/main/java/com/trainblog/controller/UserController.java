package com.trainblog.controller;


import com.aliyun.tea.*;
import com.trainblog.common.MessageSend;
import com.trainblog.entity.Message;
import com.trainblog.entity.User;
import com.trainblog.entity.UserMessageInfo;
import com.trainblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import springfox.documentation.spring.web.json.Json;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tyl
 * @since 2024-01-19
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/sendShortMessage")
    public String sendShortMessage(@RequestBody UserMessageInfo info) throws Exception {
        System.out.println(info.getTemplateparam());
        return "success";
//        return MessageSend.main(info);
    }

    @PostMapping("/signUp")
    public Message signUp(@RequestBody User user){
        if (userService.save(user)){
            return new Message("注册成功",200,user);
        }else {
            return new Message("注册失败，请重试或联系管理员", 500, null);
        }
    }

}
