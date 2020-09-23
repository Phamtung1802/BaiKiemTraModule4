package com.tung.controller;
import com.tung.model.User;
import com.tung.model.Category;
import com.tung.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userServiceImpl;

    @Autowired
    private CategoryService categoryServiceImpl;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryServiceImpl.findAll();
    }

    @Validated
    @ModelAttribute("users")
    public Iterable<User> users(){
        return userServiceImpl.findAll();
    }

    @GetMapping("/")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("/user/list");
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/user/create");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveUser(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("/user/create");
            modelAndView.addObject("message", "New User Failed");
            return modelAndView;
        }
        userServiceImpl.save(user);
        ModelAndView modelAndView = new ModelAndView("/user/create");
        modelAndView.addObject("user", new User());
        modelAndView.addObject("message", "New User created successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteUser(@PathVariable String id){
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        User user=userServiceImpl.findFirstById(Long.parseLong(id));
        userServiceImpl.delete(user);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable String id){
        ModelAndView modelAndView = new ModelAndView("/user/edit");
        User user=userServiceImpl.findFirstById(Long.parseLong(id));
        modelAndView.addObject("user",user);
        return modelAndView;
    }
    @PostMapping("/edit/{id}")
    public ModelAndView save(@ModelAttribute("user") User user,@PathVariable String id)  {
        userServiceImpl.save(user);
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        modelAndView.addObject("categories",categoryServiceImpl.findAll());
        return modelAndView;
    }


}
