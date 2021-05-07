package com.testcy.test;

import com.testcy.bean.Key;
import com.testcy.mapper.KeyMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class KeyMapperTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        String resource="mybatis-conf.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    @Test
    public void getKeyById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        KeyMapper mapper = sqlSession.getMapper(KeyMapper.class);
        Key key = mapper.getKeyById(2);
        System.out.println(key);
    }

}