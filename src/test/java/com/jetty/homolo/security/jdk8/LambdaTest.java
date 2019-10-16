package com.jetty.homolo.security.jdk8;

import com.jetty.homolo.security.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.function.Function;

/**
 * @Author: lsl
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LambdaTest {

    private List<Employee> employees = Arrays.asList(
            new Employee("tom", 18, 3333d),
            new Employee("admin", 19, 4000d),
            new Employee("root", 20, 3500d),
            new Employee("rose", 21, 5000d),
            new Employee("mary", 22, 5100d)
    );
    // 匿名内部类.
    @Test
    public void test() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
    }

    @Test
    public void test1() {
        Comparator<Employee> comparator =
                (o1, o2) -> -Integer.compare(o1.getAge(), o2.getAge());
        Collections.sort(employees, comparator);
        print(employees);
    }

    @Test
    public void test2() {
        // 普通方法
        List<Employee> list = filterEmplotyees(employees);
        print(list);
    }

    @Test
    public void test3() {
        //  策略设计模式
        List<Employee> list = filterEmployee(employees, new FilterEmployeeByAge());
        print(list);
        System.out.println("------------------------------------");
        List<Employee> list1 = filterEmployee(employees, new FilterEmployeeBySalary());
        print(list1);
    }

    @Test
    public void test4() {
        // 匿名内部类
        List<Employee> list = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean condotion(Employee employee) {
                return employee.getSalary() >= 5000;
            }
        });
        print(list);
    }
    @Test
    public void test5() {
        // lambda表达式
        List<Employee> list = filterEmployee(employees,
                            employee -> employee.getSalary() >= 5000);
        print(list);
        Function<Employee, String> function = Employee::getName;
        employees.stream().map(function);
    }

    @Test
    public void test6() {
        employees.stream().filter(employee -> employee.getSalary() >= 5000)
                    .map(Employee::getName)
                    .forEach(System.out::println);
    }

   private List<Employee> filterEmplotyees(List<Employee> employees) {
        List<Employee> list = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getAge() > 18) {
                list.add(employee);
            }
        }
        return list;
   }

   private List<Employee> filterEmployee(List<Employee> employees, MyPredicate<Employee> myPredicate) {
        List<Employee> list = new ArrayList<>();
        for (Employee employee : employees) {
            if (myPredicate.condotion(employee)) {
                list.add(employee);
            }
        }
        return list;
   }

    private void print(List<Employee> list) {
        list.forEach(System.out::println);
    }

}
