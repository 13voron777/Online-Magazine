package magazine.controllers;

import magazine.persistence.dao.services.interfaces.RoleSimpleService;
import magazine.persistence.dao.services.interfaces.UserSimpleService;
import magazine.persistence.model.Role;
import magazine.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @Autowired
    private UserSimpleService userSimpleService;

    @Autowired
    private RoleSimpleService roleSimpleService;

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
