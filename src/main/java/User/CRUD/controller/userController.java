package User.CRUD.controller;


import User.CRUD.model.User;
import User.CRUD.service.UserService;
import User.CRUD.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class userController {

    @Autowired
    private UserService userService;


    //    @GetMapping(value = "/")
//    public ModelAndView allUsers() {
//        List<User> users = userService.allUsers();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("allusers");
//        modelAndView.addObject("userList", users);
//        return modelAndView;
//    }
    @GetMapping(value = "/")
    public String allUsers(Model model) {
        List<User> users = userService.allUsers();
        model.addAttribute("userList", users);
        return "allusers";
    }

//    @GetMapping(value = "/edit/{id}")
//    public ModelAndView editPage(@PathVariable int id) {
//        User user = userService.getById(id);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("edit");
//        modelAndView.addObject("user", user);
//        return modelAndView;
//    }
@GetMapping(value = "/edit/{id}")
public String editPage(@PathVariable int id, Model model){
    User user = userService.getById(id);
    model.addAttribute("user", user);
    return "edit";
}

//    @PostMapping(value = "/edit")
//    public ModelAndView editUser(@ModelAttribute("user") User user) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("redirect:/");
//        userService.edit(user);
//        return modelAndView;
//    }
    @PostMapping(value = "/edit")
    public String editUser(@ModelAttribute("user") User user){
        userService.edit(user);
        return "redirect:/";
    }

    //    @GetMapping(value = "/add")
//    public ModelAndView addPage() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("add");
//        return modelAndView;
//    }
    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("user", new User());
        return "/add";
    }

    //    @PostMapping(value = "/add")
//    public ModelAndView addUser(@ModelAttribute("user") User user) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("redirect:/");
//        userService.add(user);
//        return modelAndView;
//    }
    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/";
    }


    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        User user = userService.getById(id);
        userService.remove(user);
        return "redirect:/";
    }
}

