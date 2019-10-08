package com.egoonet.lighting.assembly_jxepc_server.controller;

import com.egoonet.lighting.assembly_jxepc_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired //自动连接到UserService Bean
    private UserService userService;

    @RequestMapping(value = "/show")
    public String show() {
        return userService.show();
    }

    @RequestMapping(value="/insert")
    public String insert(String name, int age) {
        return userService.insert(name, age);
    }

    @RequestMapping("/hello")
    public String Hello(String name){
        return "hello"+name;
    }
}
