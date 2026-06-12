package org.example.employeesystem.entity;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class Emp {
    private Integer id;
    private String name;
    private String gender;
    private Integer age;
    private String phone;
    private Double salary;
    private LocalDate entryDate;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer deptId;
    private String deptName;

    public Emp() {
    }

    public Emp(Integer id, String name, String gender, Integer age, String phone, Double salary, LocalDate entryDate, LocalDateTime createTime, LocalDateTime updateTime,Integer deptId,String deptName) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.salary = salary;
        this.entryDate = entryDate;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
