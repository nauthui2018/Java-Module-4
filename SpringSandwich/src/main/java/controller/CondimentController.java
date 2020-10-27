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
public class CondimentController {
    static String[] condiments = {"Lettuce", "Tomato", "Mustard", "Sprouts"};

    @GetMapping("/condiments")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("condiments", condiments);
        return modelAndView;
    }

    @RequestMapping("/condiments/save")
    public ModelAndView saved(@RequestParam("condiment") String[] condiment) {
        ModelAndView modelAndView = new ModelAndView("saved");
        String[] condiments = condiment;
        modelAndView.addObject("condiments", condiments);
        return modelAndView;
    }
}