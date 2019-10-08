package com.egoonet.lighting.assembly_jxepc_server.service;

import com.egoonet.lighting.assembly_jxepc_server.dao.UserDao;
import com.egoonet.lighting.assembly_jxepc_server.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service //声明成一个spring bean
public class UserService {

    @Autowired //连接到UserDao Bean
    private UserDao userDao;

    public String show() {
        return "Hello World!";
    }

    public List<User> showDao(int age) {
        return userDao.get(age);
    }

    public String insert(String name, int age) { //插入一条记录
        User user = new User();
        user.setName(name);
        user.setAge(age);
        userDao.insert(user);
        return "Insert ( \""+name+"\", age"+age+") OK!";
    }
}