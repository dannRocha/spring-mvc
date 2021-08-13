package com.learn.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;

import com.learn.spring.mvc.model.User;
import com.learn.spring.mvc.repository.UserRepository;

import javax.validation.Valid;

@Controller
public class UserController {

  private final UserRepository repository;

  public UserController(UserRepository repository) {
    this.repository = repository;
  }


  @GetMapping("/users")
  public ModelAndView users() {
    var modelAndView = new ModelAndView();

    modelAndView.setViewName("usersView");
    modelAndView.addObject("users", repository.getAllUsers());

    return modelAndView;
  }

  @GetMapping("/register")
  public ModelAndView register() {
    var modelAndView = new ModelAndView();
    
    modelAndView.setViewName("registerView");
    modelAndView.addObject("user", new User());

    return modelAndView;
  }

  @PostMapping("/user")
  public String registerUser(@Valid @ModelAttribute User user, BindingResult result) {

    if(result.hasErrors()) {
      return "registerView";
    }

    repository.save(user);

    return "redirect:users";
  }
}
