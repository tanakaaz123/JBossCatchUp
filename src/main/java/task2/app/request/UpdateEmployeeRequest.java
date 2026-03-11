package task2.app.request;

import java.util.List;
import task2.app.entity.EmployeeEntity;

// 従業員一括更新のリクエストクラス
public class UpdateEmployeeRequest {
    
    List<EmployeeEntity> updateEmployees;

    public List<EmployeeEntity> getUpdateEmployees() {
        return updateEmployees;
    }

    public void setUpdateEmployees(List<EmployeeEntity> updateEmployees) {
        this.updateEmployees = updateEmployees;
    }

}