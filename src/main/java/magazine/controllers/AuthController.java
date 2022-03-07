package magazine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class AuthController {
    //@Autowired
    //private UserService userService;

    @GetMapping(value = "/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping(value = "/firstPage")
    public String firstPage() {
        return "common/firstPage";
    }

    /*@GetMapping("/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }*/
}
