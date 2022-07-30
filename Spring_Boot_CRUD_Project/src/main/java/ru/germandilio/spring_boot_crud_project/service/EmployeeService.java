package ru.germandilio.spring_boot_crud_project.service;

import ru.germandilio.spring_boot_crud_project.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();

    Employee getEmployee(int id);

    void saveEmployee(Employee employee);

    void deleteEmployee(int id);
}
