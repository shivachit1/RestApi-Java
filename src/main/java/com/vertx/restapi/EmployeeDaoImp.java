package com.vertx.restapi;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EmployeeDaoImp implements EmployeeDao {

    private String id;
    private Set<EmployeeEntity> employees;
    private Map<String,String> data;


    public EmployeeDaoImp(){
        employees=new HashSet<>();
        // using Entity Builder For creating Object
        EmployeeEntity entity1 = EmployeeEntity.builder().setId("1").setName("riia").setPosition("developer").setCompany("abc").build();
        EmployeeEntity entity2 = EmployeeEntity.builder().setId("2").setName("Toni").setPosition("Project Manager").setCompany("yz").build();
        employees.add(entity1);
        employees.add(entity2);
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public Set<EmployeeEntity> getEmployees() {
        // Returns List of Employees
        return employees;
    }

    @Override
    public Map<String, String> getData() {
        return data;
    }
}
