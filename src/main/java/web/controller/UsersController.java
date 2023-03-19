package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String startUsers(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
        model.addAttribute("users", userService.getUsers().stream().limit(count).collect(Collectors.toList()));
        return "allUsers";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user){
        userService.add(user);
        return "redirect: /users/all";
    }
    @GetMapping("/new")
    public String newUser(Model model ) {
        model.addAttribute("user", new User());
        return "new";
    }
}
