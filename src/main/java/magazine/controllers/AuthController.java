package magazine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping(value = "/login")
    public String loginPage() {
        return "login";
    }
}
