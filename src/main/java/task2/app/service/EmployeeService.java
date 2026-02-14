package task2.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import task2.app.entity.EmployeeEntity;
import task2.app.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<EmployeeEntity> findAll() {
        return repository.findAll();
    }
}