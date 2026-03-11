package task2.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import task2.app.entity.EmployeeEntity;
import task2.app.mapper.EmployeeMapper;
import task2.app.request.CreateEmployeeRequest;

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

    // 登録
    public void create(CreateEmployeeRequest employee) {
        // 登録処理
        EmployeeEntity entity = new EmployeeEntity();
        entity.setName(employee.getName());
        entity.setAge(employee.getAge());
        entity.setAddress(employee.getAddress());

        employeeMapper.insert(entity);

    }
}