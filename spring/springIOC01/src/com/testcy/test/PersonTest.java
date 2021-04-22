package com.testcy.test;

import com.testcy.bean.Book;
import com.testcy.bean.Car;
import com.testcy.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import static org.junit.Assert.*;

public class PersonTest {

    //    private ApplicationContext ioc=new ClassPathXmlApplicationContext("ioc.xml");
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc2.xml");

    @Test
    public void test1(){
//        Book book = (Book) ioc.getBean("book");
//        System.out.println(book);
    }
    @Test
    public void test(){
        Person person08 = (Person) ioc.getBean("person08");
        System.out.println(person08);
    }

    /*
     * 1、容器启动完成久创建了实例
     * 2、单例
     * 3、属性赋值是调用了get/set方法，属性名有set后面的字符串首字母小写决定
     *第一种实例方式是：调用无参构造器实例化，且调用set方法给属性赋值
     * */
    @Test
    public void testIOC() {
//        实验1：通过IOC容器创建对象，并为属性赋值★
//        Person person = (Person) ioc.getBean("person01");
//        System.out.println(person);
        //实验2：根据bean的类型从IOC容器中获取bean的实例★
        //注意：如果容器中有多个此类型的bean，则会报错
//        Person bean = ioc.getBean(Person.class);
        //方式2
        Person bean = ioc.getBean("person01", Person.class);

    }

    /*
     * 通过有参构造性实例化并给属性赋值
     *
     * */
    @Test
    public void test2() {
        Person person03 = (Person) ioc.getBean("person03");
        //通过有参构造器的索引号指定对应的value来赋值
//        Object person04 = ioc.getBean("person04");
        Object person04 = ioc.getBean("person06");
        System.out.println(person04);

    }

    /*
     * 给各种属性赋值
     *
     * */
    @Test
    public void test3() {
        //注入null值，引用类型为null，基本类型的属性为默认值
//        Person person01 = (Person) ioc.getBean("person01");
//        System.out.println(person01.getLastName()==null);//true
//        System.out.println(person01.getLastName());
//        Person bean = ioc.getBean("person02", Person.class);
//        Car car01 = (Car) ioc.getBean("car01");
//        System.out.println("修改容器中的car之前："+bean.getCar()==ioc.getBean("car01"));//true
//        car01.setCarName("自行车");
//        System.out.println("修改容器中的car之后："+bean.getCar()==ioc.getBean("car01"));//true
//        System.out.println("修改容器中的car之后："+bean.getCar());//修改了
//        Person person03 = (Person) ioc.getBean("person03");
//        System.out.println(person03.getCar().getPrice());
//        Person person04 = (Person) ioc.getBean("person04");
//        List<Book> books = person04.getBooks();
//        System.out.println(books);
//        Person person04 = (Person) ioc.getBean("person04");
//        Map<String, Object> map = person04.getMap();
//        System.out.println(map);
//            Person person04= (Person) ioc.getBean("person04");
//        Properties pros = person04.getProperties();
//        System.out.println(pros);
//        Person person05= (Person) ioc.getBean("person05");
//        System.out.println(person05.getMap().getClass());
//        System.out.println(person05.getMap());
        Person person06 = (Person) ioc.getBean("person06");
        Car car = person06.getCar();
        System.out.println("person中的car"+car);
        Car iocCar= (Car) ioc.getBean("car01");
        System.out.println("容器中的car"+car);


    }

}