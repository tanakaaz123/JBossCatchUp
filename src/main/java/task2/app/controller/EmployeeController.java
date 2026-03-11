package task2.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import task2.app.request.CreateEmployeeRequest;
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
    public String employeeCreate() {
        return "/employee/create";
    }

    @PostMapping("/employee/create")
    public String employeeCreate(CreateEmployeeRequest employee) {
        employeeService.create(employee);
        return "redirect:/employee/list";
    }

}