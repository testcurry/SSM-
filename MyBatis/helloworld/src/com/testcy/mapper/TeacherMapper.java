package com.testcy.mapper;

import com.testcy.bean.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {

    public Teacher getTeacherById(Integer id);

    public Teacher getTeacherByIdInclude(Integer id);

    public List<Teacher> getTeacherByCondition(Teacher teacher);

    public List<Teacher> getTeacherByConditionChoose(Teacher teacher);

    public List<Teacher> getTeacherByIn(@Param("ids") List<Integer> ids);

    public int updateTeacher(Teacher teacher);

}
