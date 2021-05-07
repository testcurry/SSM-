package com.testcy.bean;

public class Employee {
    private Integer id;
    private String empName;
    private Integer gender;
    private String email;
    private String loginAccount;

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public Employee() {
    }

    public Employee(Integer id, String empName, Integer gender, String email, String loginAccount) {
        this.id = id;
        this.empName = empName;
        this.gender = gender;
        this.email = email;
        this.loginAccount = loginAccount;
    }

    public Employee(Integer id, String empName, Integer gender, String email) {
        this.id = id;
        this.empName = empName;
        this.gender = gender;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", loginAccount='" + loginAccount + '\'' +
                '}';
    }
}
