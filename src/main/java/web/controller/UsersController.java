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

    @GetMapping("/user")
    public String startUsers(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
        model.addAttribute("users", userService.getUsers().stream().limit(count).collect(Collectors.toList()));
        return null;
    }

    @PostMapping("/new")
    public String addtUser(@ModelAttribute("user") User user, Model model){
        userService.add(user);
        model.addAttribute(user);
        return "/new";
    }
    @GetMapping("/car")
    public String printCars( ) {

        return "car";
    }
}
