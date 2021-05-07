package com.testcy.test;

import com.testcy.bean.Employee;
import com.testcy.mapper.EmployeeAnnotationMapper;
import com.testcy.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestMapper {

    public SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        String resource="mybatis-conf.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

//    测试注解SQL查询
    @Test
    public void test02(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeAnnotationMapper mapper = sqlSession.getMapper(EmployeeAnnotationMapper.class);
            Employee employee = mapper.getEmpById(1);
            System.out.println(employee);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test01() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            //class com.sun.proxy.$Proxy8
//            System.out.println(mapper.getClass());
            Employee emp = mapper.getEmpById(1);
            System.out.println(emp);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testInsert(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            int count = mapper.insertEmployee(new Employee(null, "Curry", 1, " Curry@qq.com","Curry"));
            System.out.println("插入的行数："+count);
        } finally {
//            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void update(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee(7,"Topson",1,"Topson@qq.com","topson");
            int count = mapper.updateEmployee(employee);
            System.out.println("修改的记录数："+count);
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void delete(){
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            int i = mapper.deleteEmployee(6);
            System.out.println("删除的记录数："+i);
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

}
