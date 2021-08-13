package com.learn.spring.mvc.spring.mvc.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


public class User {

  @NotNull
  private String name;

  @NotNull
  @Email(message="Email inválido")
  @NotBlank(message="Email não preenchido")
  private String email;

  public User(){}

  public User(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
