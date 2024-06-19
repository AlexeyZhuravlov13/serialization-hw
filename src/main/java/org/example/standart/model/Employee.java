package org.example.standart.model;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private Double salary;
    private Employee boss;
    private Employee subordinate;


    public Employee() {
    }

    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        this.boss = boss;
    }

    public Employee getSubordinate() {
        return subordinate;
    }

    public void setSubordinate(Employee subordinate) {
        this.subordinate = subordinate;
    }

    public Employee(String name, int age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name) && Objects.equals(salary, employee.salary) && Objects.equals(boss, employee.boss) && Objects.equals(subordinate, employee.subordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary, boss, subordinate);
    }
}
