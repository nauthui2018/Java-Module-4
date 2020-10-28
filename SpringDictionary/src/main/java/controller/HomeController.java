package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    String[] dictionaries = {"Mô tả", "Luyện tập", "Điều kiện", "Hướng dẫn"};
    String meaning;
    String input;

    @GetMapping(value = "/dictionary")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("meaning", meaning);
        modelAndView.addObject("input", input);
        return modelAndView;
    }

    @PostMapping("/dictionary")
    public String translate(String input) {
        switch (input) {
            case "description":
                meaning = dictionaries[0];
                break;
            case "practice":
                meaning = dictionaries[1];
                break;
            case "condition":
                meaning = dictionaries[2];
                break;
            case "instruction":
                meaning = dictionaries[3];
                break;
            default:
                meaning = "Not find";
        }
        return "redirect:/dictionary";
    }
}