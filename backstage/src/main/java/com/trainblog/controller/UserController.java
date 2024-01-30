package com.trainblog.controller;


import com.aliyun.tea.*;
import com.trainblog.common.MessageSend;
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

}
