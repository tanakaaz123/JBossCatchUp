package task2.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import task2.app.entity.EmployeeEntity;

@Repository

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
