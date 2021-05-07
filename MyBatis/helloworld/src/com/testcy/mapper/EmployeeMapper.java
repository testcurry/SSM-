package com.testcy.mapper;

import com.testcy.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public Map<String,Object> getEmpReturnMap(Integer id);

    @MapKey("id")
    public Map<String,Object> getEmpsReturnMap();

    public List<Employee> getEmps();

    public Employee getEmpByIdAndName(@Param("id") Integer id, @Param("empName") String empName);

    public Employee getEmpByMap(Map<String,Object> map);

    public int updateEmployee(Employee employee);

    public int deleteEmployee(Integer id);

    public int insertEmployee(Employee employee);

    public int addEmployee(Employee employee);
}
