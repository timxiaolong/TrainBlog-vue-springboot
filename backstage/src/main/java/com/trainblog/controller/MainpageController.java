package com.trainblog.controller;


import com.trainblog.entity.Mainpage;
import com.trainblog.service.MainpageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tyl
 * @since 2024-01-24
 */
@CrossOrigin
@RestController
@RequestMapping("/mainpage")
public class MainpageController {
    @Autowired
    private MainpageService mainpageService;

    @GetMapping("/getSection")
    public List<Mainpage> getSection(){
        return mainpageService.list();
    }
    @GetMapping("/test")
    public void test(){

    }
}
