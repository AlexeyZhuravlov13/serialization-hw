package org.example.kryo.model;

import java.util.List;

public class Company {
    private List<Employee> employeeList;

    public Company() {
    }

    public Company(List<Employee> list) {
        this.employeeList = list;
    }

    @Override
    public String toString() {
        return "Company{" +
                "employeeList=" + employeeList +
                '}';
    }
}
