package task2.app.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import task2.app.entity.EmployeeEntity;
import task2.app.mapper.EmployeeMapper;

@Service
@Transactional
public class EmployeeService {

    // Mapperの宣言
    private final EmployeeMapper employeeMapper;

    // mapperを注入
    public EmployeeService(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    // 全件取得
    public List<EmployeeEntity> findAll() {
        return employeeMapper.findAll();
    }
}