package com.egoonet.lighting.assembly_jxepc_server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping("/hello")
    public String Hello(String name){
        return "hello"+name;
    }
}
