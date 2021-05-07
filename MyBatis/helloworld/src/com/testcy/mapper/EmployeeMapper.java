package com.testcy.mapper;

import com.testcy.bean.Employee;

public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public int updateEmployee(Employee employee);

    public int deleteEmployee(Integer id);

    public int insertEmployee(Employee employee);
}
