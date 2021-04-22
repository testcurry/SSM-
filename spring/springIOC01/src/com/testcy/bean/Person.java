package com.testcy.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Person {

    private Integer age;
    private String gender;
    private String email;
    private String lastName="小明";
    private Car car;
    private List<Book> books;
    private Map<String,Object> map;
    private Properties properties;

    public Person() {
        System.out.println("Person的无参构造器。。。");
    }

    public Person(Integer age, String gender, String email, String lastName) {
        System.out.println("Person的有参构造器执行。。。");
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.lastName = lastName;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        System.out.println("lastName的set方法");
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", car=" + car +
                ", books=" + books +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }
}
