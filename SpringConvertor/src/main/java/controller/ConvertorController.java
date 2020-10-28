package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvertorController {
    double result;

    @GetMapping("/convertor")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("result", result);
        return modelAndView;
    }

    @PostMapping("/convertor")
    public String add(double input, String to) {
        System.out.println(input);
        System.out.println(to);
        switch (to) {
            case "vnd":
                result = input;
                break;
            case "usd":
                result = input/23000;
                break;
            case "cad":
                result = input/17300;
                break;
            case "aud":
                result = input/16100;
                break;
            default:
                result = 0;
        }
        return "redirect:/convertor";
    }
}