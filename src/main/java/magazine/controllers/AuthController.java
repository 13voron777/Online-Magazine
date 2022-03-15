package magazine.controllers;

import magazine.persistence.dao.services.interfaces.RoleSimpleService;
import magazine.persistence.dao.services.interfaces.UserSimpleService;
import magazine.persistence.model.Role;
import magazine.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

@Controller
public class AuthController {
    @Autowired
    private UserSimpleService userSimpleService;

    @Autowired
    private RoleSimpleService roleSimpleService;

    @GetMapping(value = "/main")
    public String main() {
        return "main";
    }

    @GetMapping(value = "/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String registrationPage() {
        return "registration";
    }

    @PostMapping("/register")
    public String registerNewUser(HttpServletRequest request) {
        User user = new User();
        user.setLogin(request.getParameter("login"));
        user.setPassword("{noop}" + request.getParameter("password"));
        Role role = new Role();
        role.setRole("ROLE_USER");
        role.setUsername(user.getLogin());
        user.setRoles(Collections.singletonList(role));
        userSimpleService.addUser(user);
        roleSimpleService.addRole(role);
        return "redirect: login";
    }
}
