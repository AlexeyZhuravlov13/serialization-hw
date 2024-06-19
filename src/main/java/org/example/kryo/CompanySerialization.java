package org.example.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.example.kryo.model.Company;
import org.example.kryo.model.Employee;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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
        Kryo kryo = new Kryo();
        Employee boss = new Employee("Boss", 32, 1111.1d);
        Employee subordinate = new Employee("Subordinate", 25, 1.1d);

        boss.setSubordinate(subordinate);
        subordinate.setBoss(boss);

        List<Employee> employees = new ArrayList<>(Arrays.asList(boss, subordinate));
        Company company = new Company(employees);
        try (Output output = new Output(new FileOutputStream("company"))){
            kryo.writeObject(output, company);
        } catch (Exception e){
            e.printStackTrace();
        }

        try (Input input = new Input(new FileInputStream("company"))){
            Company company1 = kryo.readObject(input, Company.class);
            System.out.println(company1);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
