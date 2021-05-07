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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMapper {

    public SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        String resource="mybatis-conf.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

   /*
   org.apache.ibatis.exceptions.TooManyResultsException:
    Expected one result (or null) to be returned by selectOne(),
    but found: 8
    */
    @Test
    public void test08(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Map<String, Object> map = mapper.getEmpsReturnMap();
            Object emp = map.get(1);
            System.out.println(emp);
            System.out.println(map);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test09(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Map<String, Object> map = mapper.getEmpReturnMap(1);
            System.out.println(map);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test07(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> emps = mapper.getEmps();
            for (Employee employee:emps){
                System.out.println(employee);
            }
//            emps.forEach(System.out::println);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test06(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            HashMap<String,Object> map = new HashMap<>();
            map.put("id", 1);
            map.put("empName", "admin");
            Employee employee = mapper.getEmpByMap(map);
            System.out.println(employee);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test05(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            /*Caused by: org.apache.ibatis.binding.BindingException:
             Parameter 'id' not found. Available parameters are [arg1, arg0, param1, param2]*/
            Employee employee = mapper.getEmpByIdAndName(1, "admin");
            System.out.println(employee);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void test04(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee(null, "test", 0, "test@qq.com", "test");
            mapper.addEmployee(employee);
            System.out.println(employee.getId());
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void test03(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee(null, "test", 0, "test@qq.com", "test");
            int i = mapper.insertEmployee(employee);
            System.out.println("插入的记录数："+i);
            System.out.println(employee.getId());
        } finally {
            sqlSession.close();
        }
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
