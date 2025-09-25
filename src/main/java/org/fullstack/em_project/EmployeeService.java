package org.fullstack.em_project;

import java.util.List;

public interface EmployeeService {
     String creatEmployee(Employee employee);
     List<Employee> readEmployees();
     boolean deleteEmployee(Long id);
}