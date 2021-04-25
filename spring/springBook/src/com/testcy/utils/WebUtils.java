package com.testcy.utils;

import com.testcy.pojo.User;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Map;

public class WebUtils {

//    private static final long serialVersionUID=1L;
//    private static ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    /**
     * 从ioc容器中获取组件
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        //获取ioc容器
        WebApplicationContext ioc = ContextLoader.getCurrentWebApplicationContext();
        T bean = ioc.getBean(clazz);
        return bean;
    }

    public static <T> T copyParamsToBean(Map map, T bean) {
        //使用beanUtils类注入Javabean

//        System.out.println("注入之前：" + bean);
        try {
            BeanUtils.populate(bean, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int paseInt(String str, int defaultValue) {

        if (str != null && !"".equals(str)) {
            return Integer.parseInt(str);
        }
        return defaultValue;

       /* try {
            return Integer.parseInt(str);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        return defaultValue;*/
    }
}
