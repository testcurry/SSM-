package com.testcy.test;

import com.testcy.bean.Key;
import com.testcy.bean.Lock;
import com.testcy.mapper.LockMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class LockMapperTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        String resource="mybatis-conf.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    @Test
    public void getLockById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        LockMapper mapper = sqlSession.getMapper(LockMapper.class);
        Lock lock = mapper.getLockById(3);
        System.out.println(lock);
        System.out.println("所有的锁的钥匙信息：----------");
        List<Key> keys = lock.getKeys();
        for (Key k:keys){
            System.out.println(k);
        }
    }
}