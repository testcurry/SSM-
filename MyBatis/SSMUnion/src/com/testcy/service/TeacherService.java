package com.testcy.service;

import com.testcy.bean.Teacher;
import com.testcy.mapper.TeacherMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

/*
    @Autowired
    private SqlSessionFactory sqlSessionFactory;*/

    @Autowired
    private TeacherMapper teacherMapper;

    public Teacher getTeacherById(Integer id) {

        return teacherMapper.getTeacherById(id);
    }

}
