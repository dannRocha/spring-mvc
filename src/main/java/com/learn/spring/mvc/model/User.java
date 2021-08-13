package com.learn.spring.mvc.model;

import javax.validation.constraints.NotBlank;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class User {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
	
  @NotNull
  private String name;

  @NotNull
  @Email(message="Email inválido")
  @NotBlank(message="Email não preenchido")
  private String email;
  

  public User(){}
  
  public User(
    @NotNull Long id, 
    @NotNull String name,
    @NotNull @Email(message = "Email inválido") @NotBlank(message = "Email não preenchido") String email
  ) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
}

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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
