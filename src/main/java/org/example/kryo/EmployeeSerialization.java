package org.example.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.example.kryo.model.Employee;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
) Настройка сериализации с помощью Kryo:
   - Создайте класс Employee с полями name, age и salary.
   - Используя библиотеку Kryo, настройте сериализацию и десериализацию объектов класса Employee.
   - Убедитесь, что Kryo может правильно обрабатывать класс Employee, включая обработку ссылок и циклических зависимостей.
 */
public class EmployeeSerialization {
    public static void main(String[] args) {
        Kryo kryo = new Kryo();

        Employee boss = new Employee("Boss", 32, 1111.1d);
        Employee subordinate = new Employee("Subordinate", 25, 1.1d);

        boss.setSubordinate(subordinate);
        subordinate.setBoss(boss);

        try (Output output = new Output(new FileOutputStream("file"))) {
            kryo.writeClassAndObject(output, boss);
            kryo.writeClassAndObject(output, subordinate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (Input input = new Input(new FileInputStream("file"))) {
            Employee object1 = (Employee) kryo.readClassAndObject(input);
            Employee object2 = (Employee) kryo.readClassAndObject(input);
            System.out.println(object1);
            System.out.println(object2);
            System.out.println("object1 getSubordinate: " + object1.getSubordinate());
            System.out.println("object2 getBoss: " + object2.getBoss());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}