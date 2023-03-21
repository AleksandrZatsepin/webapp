package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/allUsers")
    public String startUsers(ModelMap model) {
        model.addAttribute("users", userService.getUsers());
        return "/users/allUsers";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute("user") User user){
        userService.add(user);
        return "redirect: /users/allUsers";
    }
    @GetMapping("/new")
    public String newUser(Model model ) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model,@PathVariable("id") long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/edit";
    }
    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user){
        userService.updateUser(user);
        return  "redirect: /users/allUsers";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@ModelAttribute("user") User user){
        userService.remove(user);
        return  "redirect: /users/allUsers";
    }
}
