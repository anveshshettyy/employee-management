package org.fullstack.em_project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    // List<Employee>  employees = new ArrayList<>();

    @Override
    public String creatEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        // employees.add(employee);
        return "Account Created Successfully!";
    }

    @Override
    public Employee readEmployee(Long id) {
        EmployeeEntity emp = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(emp, employee);

        return employee;
    }

    @Override
    public List<Employee> readEmployees() {
        List<EmployeeEntity> employeeList = employeeRepository.findAll(); 
        List<Employee> employees = new ArrayList<>();

        for(EmployeeEntity employeeEntity: employeeList) {
            Employee emp = new Employee();
            emp.setId(employeeEntity.getId());
            emp.setName(employeeEntity.getName());
            emp.setEmail(employeeEntity.getEmail());
            emp.setPhone(employeeEntity.getPhone());

            employees.add(emp);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity emp = employeeRepository.findById(id).get();
        employeeRepository.delete(emp);
        return true;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmployeeEntity emp = employeeRepository.findById(id).get();
        
        emp.setName(employee.getName());
        emp.setPhone(employee.getPhone());
        emp.setEmail(employee.getEmail());

        employeeRepository.save(emp);
        return "Updated Successfully!";
    }

    

    

}
