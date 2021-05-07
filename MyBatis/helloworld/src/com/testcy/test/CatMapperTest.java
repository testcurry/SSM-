package com.testcy.test;

import com.testcy.bean.Cat;
import com.testcy.mapper.CatMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CatMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        String resource="mybatis-conf.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    @Test
    public void getById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CatMapper mapper = sqlSession.getMapper(CatMapper.class);
        Cat cat = mapper.getById(1);
        System.out.println(cat);
    }
}