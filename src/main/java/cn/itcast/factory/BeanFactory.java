package cn.itcast.factory;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.HashMap;
import java.util.Map;

public class BeanFactory {
    /**
     * 获取bean对象的工厂方法
     * @return
     */
//    public static UserDao getBean(){
//        return new UserDaoImpl();
//    }
    // 从xml文件中解析bean，通过反射得到的对象存放到map中
    private static Map<String, Object> map = new HashMap<String, Object>();
    /**
     * 解析xml文件
     */
    static {
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml"));
            Element root = document.getRootElement();
            String id = root.attributeValue("id");
            // 类的全路径名
            String clazz = root.attributeValue("class");
            // 通过反射生成对象
            Object obj = Class.forName(clazz).newInstance();
            map.put(id, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取bean对象的工厂方法
     *
     * @return
     */
    public static Object getBean(String id) {
        return map.get(id);
    }

}
