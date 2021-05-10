package com.testcy.test;

import com.mysql.cj.Session;
import com.testcy.bean.Teacher;
import com.testcy.mapper.TeacherMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TeacherMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        String resource="mybatis-conf.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    @Test
    public void getTeacherByCondition() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher1 = new Teacher();
//        teacher1.setId(1);
//        teacher1.setName("%C%");
//        teacher1.setBirth(new Date());
        List<Teacher> teachers = mapper.getTeacherByCondition(teacher1);
        System.out.println(teachers);
    }

    @Test
    public void getTeacherById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacherById(1);
    }

    @Test
    public void getTeacherByIdInclude() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacherByIdInclude(1);
        System.out.println(teacher);
    }

    @Test
    public void getTeacherByIdIn() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.getTeacherByIn(Arrays.asList(1, 2, 3, 4, 5));
        for (Teacher teacher:teachers){
            System.out.println(teacher);
        }
    }

    @Test
    public void getTeacherByCondition2() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setName("Curry");
        teacher.setBirth(new Date());
        List<Teacher> teachers = mapper.getTeacherByConditionChoose(teacher);
        for (Teacher teacher1:teachers){
            System.out.println(teacher1);
        }
    }

    @Test
    public void updateTest() {
        SqlSession sqlSession=null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher teacher = new Teacher();
            teacher.setId(1);
            teacher.setName("Curry");
            teacher.setBirth(new Date());
            teacher.setAddress("鼓楼区");
            teacher.setCourse("高数");
            int i = mapper.updateTeacher(teacher);
            System.out.println("影响的记录数："+i);
        } finally {
            if (sqlSession!=null){
                sqlSession.commit();
                sqlSession.close();
            }
        }
    }
}