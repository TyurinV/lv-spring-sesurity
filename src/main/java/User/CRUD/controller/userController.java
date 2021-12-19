package User.CRUD.controller;


import User.CRUD.model.User;
import User.CRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class userController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/admin/all")
    public String allUsers(Model model) {
        List<User> users = userService.allUsers();
        model.addAttribute("userList", users);
        return "allusers";
    }

    @GetMapping(value = "/admin/edit/{id}")
    public String editPage(@PathVariable int id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userService.edit(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/add")
    public String addPage(Model model) {
        model.addAttribute("user", new User());
        return "/add";
    }

    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/admin/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        User user = userService.getById(id);
        userService.remove(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/User")
    public String getUser(Model model, Authentication authentication){
        User user = userService.getUserByName(authentication.getName());
        model.addAttribute("user", user);
        return "user";
    }
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "loginsss";
    }


}

