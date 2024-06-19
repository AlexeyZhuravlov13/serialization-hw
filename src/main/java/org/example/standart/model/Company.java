package org.example.standart.model;

import java.io.Serializable;
import java.util.List;

public class Company implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Employee> employeeList;

    public Company() {
    }

    public Company(List<Employee> list) {
        this.employeeList = list;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public String toString() {
        return "Company{" +
                "employeeList=" + employeeList +
                '}';
    }
}
