package controller;

import model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SettingController {

    @GetMapping("/setting")
    public String viewSetting(Setting setting, Model model) {
        if (setting == null) {
            setting = new Setting();
        }
        model.addAttribute("setting", setting);
        return "/setting";
    }

    @PostMapping("/setting")
    public String saveSetting(Setting setting, RedirectAttributes redirect, Model model) {
        model.addAttribute("setting", setting);
        redirect.addFlashAttribute("success", "Saved setting successfully!");
        return "/viewSetting";
    }
}
