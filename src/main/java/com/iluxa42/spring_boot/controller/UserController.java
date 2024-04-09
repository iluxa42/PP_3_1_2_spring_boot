package com.iluxa42.spring_boot.controller;

import com.iluxa42.spring_boot.entity.User;
import com.iluxa42.spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

        if (userService.getAllUsers().isEmpty()) {
            userService.saveUser(new User("Ivan", "Ivanov", 35, 1200, "ivanovich81@gmail.com"));
            userService.saveUser(new User("Victor", "Petrov", 22, 950, "petrovich3000@mail.ru"));
            userService.saveUser(new User("Софья", "Риановна", 43, 1030, "sophico11@yahoo.com"));
            userService.saveUser(new User("Sidr", "Sidorov", 31, 870, "sidr.sidr@list.ru"));
            userService.saveUser(new User("Петр", "Лебедев", 39, 720, "lebed.white@yahoo.com"));
        }
    }

    @GetMapping("/")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "all-users";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-info";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/updateUser")
    public String updateUser(@RequestParam int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user-info";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}