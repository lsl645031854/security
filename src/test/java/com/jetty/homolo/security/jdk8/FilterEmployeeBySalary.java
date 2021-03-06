package com.jetty.homolo.security.jdk8;

import com.jetty.homolo.security.entity.Employee;

/**
 * @Author: lsl
 * @Description:
 * @Date: Created on 9:32 2019/10/5
 */
public class FilterEmployeeBySalary implements MyPredicate<Employee> {
    @Override
    public boolean condotion(Employee employee) {
        return employee.getSalary() > 5000;
    }
}
