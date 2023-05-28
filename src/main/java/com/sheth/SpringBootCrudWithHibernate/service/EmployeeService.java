package com.sheth.SpringBootCrudWithHibernate.service;

import com.sheth.SpringBootCrudWithHibernate.exception.RecordNotFoundException;
import com.sheth.SpringBootCrudWithHibernate.model.Employee;
import com.sheth.SpringBootCrudWithHibernate.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public List<Employee> getAllEmployees()
    {
        List<Employee> employeeList = repository.findAll();

        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<>();
        }
    }

    public Employee getEmployeeById(int id) throws RecordNotFoundException
    {
        Optional<Employee> employee = repository.findById(id);

        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }

    public Employee createOrUpdateEmployee(Employee entity) throws RecordNotFoundException
    {
        Optional<Employee> employee = repository.findById(entity.getId());

        if(employee.isPresent())
        {
            Employee newEntity = employee.get();
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteEmployeeById(int id) throws RecordNotFoundException
    {
        Optional<Employee> employee = repository.findById(id);

        if(employee.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
}
