package task2.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import task2.app.entity.EmployeeEntity;

// Mapperのインターフェース
@Mapper
public interface EmployeeMapper {
    // 全件取得
    List<EmployeeEntity> findAll();

    // 従業員登録
    void insert(EmployeeEntity employee);
}
