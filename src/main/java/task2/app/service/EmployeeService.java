package task2.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import task2.app.entity.EmployeeEntity;
import task2.app.mapper.EmployeeMapper;
import task2.app.request.CreateEmployeeRequest;
import task2.app.request.DeleteEmployeeRequest;
import task2.app.request.UpdateEmployeeRequest;

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
    public void create(CreateEmployeeRequest request) {
        // 登録処理
        EmployeeEntity entity = new EmployeeEntity();
        entity.setName(request.getName());
        entity.setAge(request.getAge());
        entity.setAddress(request.getAddress());

        employeeMapper.insert(entity);
    }

    // 一括削除
    public void delete(DeleteEmployeeRequest request) {
        List<Long> targetIds = request.getDeleteEmployeeIds();
        if (targetIds == null || targetIds.isEmpty()) {
            return;
        }
        employeeMapper.delete(targetIds);
    }

    // 一括更新
    public void update(UpdateEmployeeRequest request) {
        List<EmployeeEntity> updateTargetEmployees = request.getUpdateEmployees();

        // inputが空欄だと空白になるのでnullに変換する処理
        List<EmployeeEntity> normalizedEmployees = new ArrayList<>();
        for (EmployeeEntity employee : updateTargetEmployees) {

            employee.setName(normalizeBlankToNull(employee.getName()));
            employee.setAddress(normalizeBlankToNull(employee.getAddress()));

            normalizedEmployees.add(employee);
        }
        if (normalizedEmployees.isEmpty()) {
            return;
        }
        employeeMapper.update(normalizedEmployees);
    }

    // 空白をnullに変換する処理
    private String normalizeBlankToNull(String value) {
        if (value == null || value.isBlank()) {
            return null;
        }
        return value;
    }

}