package task2.app.request;

import java.util.List;

//　従業員一括削除のリクエストクラス
public class DeleteEmployeeRequest {

    List<Long> deleteEmployeeIds;

    public List<Long> getDeleteEmployeeIds() {
        return deleteEmployeeIds;
    }

    public void setDeleteEmployeeIds(List<Long> ids) {
        this.deleteEmployeeIds = ids;
    }

}