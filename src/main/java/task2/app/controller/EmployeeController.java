package task2.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import task2.app.request.CreateEmployeeRequest;
import task2.app.request.DeleteEmployeeRequest;
import task2.app.request.UpdateEmployeeRequest;
import task2.app.service.EmployeeService;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee/list")
    public String employeeList(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "/employee/list";
    }

    @GetMapping("/employee/create")
    public String createEmployee() {
        return "/employee/create";
    }

    // 従業員登録のエンドポイント
    @PostMapping("/employee/create")
    public String createEmployee(CreateEmployeeRequest request) {
        employeeService.create(request);
        return "redirect:/employee/list";
    }

    // 一括削除のエンドポイント
    @PostMapping("/employee/delete")
    // @RequestBodyを使用して、JSONのリクエストボディからDeleteEmployeeRequestオブジェクトを受け取る
    public String deleteEmployee(@RequestBody DeleteEmployeeRequest request) {
        employeeService.delete(request);
        return "redirect:/employee/list";
    }

    // 一括更新のエンドポイント
    @PostMapping("/employee/update")
    public String updateEmployee(UpdateEmployeeRequest request) {
        employeeService.update(request);
        return "redirect:/employee/list";
    }

}