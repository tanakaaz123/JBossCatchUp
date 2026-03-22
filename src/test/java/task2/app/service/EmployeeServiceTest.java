package task2.app.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import task2.app.entity.EmployeeEntity;
import task2.app.mapper.EmployeeMapper;
import task2.app.request.UpdateEmployeeRequest;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

	// テスト対象serviceクラス
	@InjectMocks
	private EmployeeService targetService;

	// Mapperクラスのモック化
	@Mock
	private EmployeeMapper mapperMock;

	@Test
	void 従業員の0件の更新() {
		List<EmployeeEntity> updateTargetEmployees = List.of();

		UpdateEmployeeRequest request = new UpdateEmployeeRequest();
		request.setUpdateEmployees(updateTargetEmployees);

		targetService.update(request);

		verify(mapperMock, never()).update(updateTargetEmployees);
	}

	@Test
	void 従業員の1件の更新() {
		EmployeeEntity testEmployee = new EmployeeEntity();
		testEmployee.setId(1L);
		testEmployee.setName(" ");
		testEmployee.setAge(20);
		testEmployee.setAddress("東京");
		List<EmployeeEntity> updateTargetEmployees = List.of(testEmployee);

		UpdateEmployeeRequest request = new UpdateEmployeeRequest();
		request.setUpdateEmployees(updateTargetEmployees);

		targetService.update(request);

		verify(mapperMock).update(updateTargetEmployees);
	}

	@Test
	void 従業員の100件の更新() {
		List<EmployeeEntity> employees = new ArrayList<>();

		for (int i = 1; i <= 100; i++) {
			EmployeeEntity e = new EmployeeEntity();
			e.setId((long) i);
			e.setName("テスト" + i);
			e.setAge(20 + i);
			e.setAddress("東京" + i);
			employees.add(e);
		}

		UpdateEmployeeRequest request = new UpdateEmployeeRequest();
		request.setUpdateEmployees(employees);

		targetService.update(request);

		verify(mapperMock).update(employees);
	}

	@Test
	void 従業員の更新のデータベースアクセスの失敗() {

		doThrow(new RuntimeException("DBエラー"))
				.when(mapperMock)
				.update(any());
		EmployeeEntity testEmployee = new EmployeeEntity();
		testEmployee.setId(1L);
		testEmployee.setName("テスト太郎");
		testEmployee.setAge(20);
		testEmployee.setAddress("東京");
		List<EmployeeEntity> updateTargetEmployees = List.of(testEmployee);

		UpdateEmployeeRequest request = new UpdateEmployeeRequest();
		request.setUpdateEmployees(updateTargetEmployees);

		assertThrows(RuntimeException.class, () -> {
			targetService.update(request);
		});
	}

}
