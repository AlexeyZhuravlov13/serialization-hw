package org.example.standart;

import org.example.standart.model.Company;
import org.example.standart.model.Employee;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

2) Сериализация объектов с вложенными структурами данных:
   - Создайте класс Company, который содержит список объектов Employee.
   - Реализуйте сериализацию и десериализацию объекта Company с использованием/без библиотеки Kryo.

 */
public class CompanySerialization {
    public static void main(String[] args) {
        Employee boss = new Employee("Boss", 32, 1111.1d);
        Employee subordinate = new Employee("Subordinate", 25, 1.1d);

        boss.setSubordinate(subordinate);
        subordinate.setBoss(boss);

        List<Employee> employees = new ArrayList<>(Arrays.asList(boss, subordinate));
        Company company = new Company(employees);

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("company"))){
            output.writeObject(company);
        } catch (Exception e){
            e.printStackTrace();
        }

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("company"))){
            Company company1 = (Company) input.readObject();
            List<Employee> employeeList = company1.getEmployeeList();
            System.out.println(company1);
            Employee employee = employeeList.get(0);
            Employee employee1 = employeeList.get(1);
            System.out.println("getSubordinate: " + employee.getSubordinate());
            System.out.println("getBoss: " + employee1.getBoss());
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
