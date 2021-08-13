package com.learn.spring.mvc.spring.mvc.repository;

import org.springframework.stereotype.Repository;
import com.learn.spring.mvc.spring.mvc.model.User;

import java.util.List;
import java.util.ArrayList;


@Repository
public class UserRepository {
  private List<User> userList;
  public UserRepository() {
    userList = new ArrayList<User>();
  }

  public List<User> getAllUsers() {
    


    return userList;
  }

  public User save(User user) {
    userList.add(user);
    return user;
  }
}