package ru.itmentor.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.itmentor.spring.boot_security.demo.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @PersistenceContext
    EntityManager entityManager;



    @Override
    public List<Employee> getAllEmployees() {
        return entityManager.createQuery("from Employee",Employee.class).getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public void deleteEmployee(int id) {
        entityManager.createQuery("delete from Employee where id=:id").setParameter("id",id).executeUpdate();
    }
}
