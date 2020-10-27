package controller;

import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CustomerService;
import service.CustomerServiceFactory;

import java.util.List;

@Controller
public class HomeController {
    private CustomerService customerService = CustomerServiceFactory.getInstance();

    @GetMapping("/customers")
    public String showList(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "list";
    }

    @GetMapping("/info")
    public String showInfo(Model model, @RequestParam long id) {
        Customer customer = customerService.findOne(id);
        model.addAttribute("customer", customer);
        return "info";
    }
}