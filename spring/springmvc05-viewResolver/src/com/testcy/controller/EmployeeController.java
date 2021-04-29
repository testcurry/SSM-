package com.testcy.controller;

import com.testcy.dao.DepartmentDao;
import com.testcy.dao.EmployeeDao;
import com.testcy.entities.Department;
import com.testcy.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 查询所有员工
     *
     * @param model
     * @return
     */
    @RequestMapping("/emps")
    public String getEmps(Model model) {
        Collection<Employee> all = employeeDao.getAll();
        Model emps = model.addAttribute("emps", all);
        return "list";
    }

    /**
     * 去添加员工页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/toaddpage")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        model.addAttribute("employee", new Employee());
        return "add";
    }

    /**
     * 保存员工
     *
     * @param employee
     * @return
     */
    @RequestMapping(value = "/addEmp", method = RequestMethod.POST)
    public String addEmp(Employee employee) {
        System.out.println("要添加的员工：" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 查询员工来到修改页面回显
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String getEmp(@PathVariable Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        model.addAttribute("employee", employee);
        return "edit";

    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.PUT)
    public String updateEmp(@ModelAttribute("employee") Employee employee/*,@PathVariable("id") Integer id*/) {
        System.out.println("要修改的员工" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @ModelAttribute
    public void myModelAttribute(@RequestParam(value = "id", required = false) Integer id, Model model) {
//        System.out.println("hhhhh");
        if (id != null) {
            Employee employee = employeeDao.get(id);
//            System.out.println(employee);
            model.addAttribute("employee", employee);
        }
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
