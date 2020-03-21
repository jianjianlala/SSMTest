package cn.itcast.test;

import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;
import org.junit.Test;

public class TestIOC {
    @Test
    public void test1(){
        UserService userService = new UserServiceImpl();
        userService.saveUser();
    }
}
