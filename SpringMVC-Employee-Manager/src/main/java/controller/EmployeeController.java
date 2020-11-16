package controller;

import model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @GetMapping("/showForm")
    public String index(Model model) {
        model.addAttribute("employee", new Employee());
        return "/employee/addForm";
    }

    @PostMapping("/addEmployee")
    public String add(Employee employee, Model model) {
        model.addAttribute("id", employee.getId());
        model.addAttribute("name", employee.getName());
        model.addAttribute("phone", employee.getPhone());
        return "/employee/view";
    }
}