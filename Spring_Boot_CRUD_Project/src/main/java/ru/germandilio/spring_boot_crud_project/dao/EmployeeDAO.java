package ru.germandilio.spring_boot_crud_project.dao;

import ru.germandilio.spring_boot_crud_project.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getEmployees();

    Employee getEmployee(int id);

    void saveEmployee(Employee employee);

    void deleteEmployee(int id);
}
