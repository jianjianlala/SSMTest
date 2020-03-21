package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.factory.BeanFactory;
import cn.itcast.service.UserService;

public class UserServiceImpl implements UserService {
//    private UserDao userDao=new UserDaoImpl();//业务和dao耦合了
//手动实例DAO，Service严重耦合DAO
    //private UserDao userDao = new UserDaoImpl();

    //通过工厂的方式来获取DAO对象\,但是不能完全解耦，工厂类又跟UserDao耦合
//    BeanFactory beanFactory=new BeanFactory();
    private UserDao userDao = BeanFactory.getBean();
    public void saveUser() {
        userDao.save();
    }
}
