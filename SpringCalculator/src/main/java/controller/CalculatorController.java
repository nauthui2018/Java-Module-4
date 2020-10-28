package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import static java.util.Arrays.asList;

@Controller
public class CalculatorController {
    double result;

    @GetMapping("/calculator")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("calculator");
        modelAndView.addObject("result", result);
        return modelAndView;
    }

    @PostMapping("/calculator")
    public String add(double num1, double num2, String operator) {
        switch (operator) {
            case "Addition(+)":
                result = num1 + num2;
                break;
            case "Subtract(-)":
                result = num1 - num2;
                break;
            case "Multiplication(X)":
                result = num1 * num2;
                break;
            case "Division(/)":
                result = num1 / num2;
                break;
            default:
                result = 0.0;
        }
        return "redirect:/calculator";
    }
}