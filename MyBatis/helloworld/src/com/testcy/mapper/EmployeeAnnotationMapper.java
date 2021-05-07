package com.testcy.mapper;

import com.testcy.bean.Employee;
import org.apache.ibatis.annotations.Select;

public interface EmployeeAnnotationMapper {

    @Select("select * from t_employee where id=#{id}")
    public Employee getEmpById(Integer id);

}
