package com.learn.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.learn.spring.mvc.expection.UserNotFoundException;
import com.learn.spring.mvc.model.User;
import com.learn.spring.mvc.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1")
public class UserController {

  private final UserRepository repository;

  public UserController(UserRepository repository) {
    this.repository = repository;
  }
  
  
  @GetMapping("/users")
  public List<User> users() {
	  return repository.findAll();
  }
  
  @GetMapping("/users/{id}")
  public ResponseEntity<Optional<User>> findById(@PathVariable Long id) {
	  var user = repository.findById(id);
	  if(!user.isPresent()) {
		 return ResponseEntity.notFound().build();
	  }
	  
	  return ResponseEntity.ok(user);
  }
  
  @PostMapping("/users")
  @ResponseStatus(HttpStatus.CREATED)
  public User createUser(@Valid @RequestBody User user) {
	  repository.save(user);
	  return user;
  }
  
  @PutMapping("/users")
  public ResponseEntity<User> updateUser(@Valid @RequestBody User user) {
    
	var userEntity = repository.findById(user.getId());
    if(!userEntity.isPresent()) {
      return ResponseEntity.notFound().build();
    }
    
	return ResponseEntity.ok(repository.save(user));
  }
  
  @DeleteMapping("/users/{id}")
  public ResponseEntity<Optional<User>> deleteById(@PathVariable Long id) {
    var user = repository.findById(id);
    if(!user.isPresent()) {
      return ResponseEntity.notFound().build();
    }
	
    return ResponseEntity.ok(repository.delete(user.get()));
  }
}
