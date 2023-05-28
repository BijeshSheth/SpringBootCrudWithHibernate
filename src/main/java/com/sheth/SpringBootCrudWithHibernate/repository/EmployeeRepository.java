package com.sheth.SpringBootCrudWithHibernate.repository;

import com.sheth.SpringBootCrudWithHibernate.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
