package controller;

import dao.UserDAO;
import model.Login;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    private UserDAO userDAO = new UserDAO();

    @GetMapping("/home")
    public String viewHome(Model model) {
        Login login = new Login();
        model.addAttribute("login", login);
        return "/home";
    }

    @PostMapping("/login")
    public String login(Login login, Model model) {
        User user = userDAO.checkLogin(login);
        if (user == null) {
            return "/error";
        } else {
            model.addAttribute("user", user);
            return "/user";
        }
    }
}
