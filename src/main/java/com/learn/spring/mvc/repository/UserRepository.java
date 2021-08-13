package com.learn.spring.mvc.repository;

import org.springframework.stereotype.Repository;
import com.learn.spring.mvc.model.User;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;


@Repository
public class UserRepository {
  
  private List<User> userList;
  
  public UserRepository() {
    userList = new ArrayList<User>() {{
    	add(new User(1L, "Daniel Rocha", "rocha@daniel"));
    	add(new User(2L, "Rocha Daniel", "daniel@rocha"));
    }};
  }

  public List<User> getAllUsers() {
    return userList;
  }

  public User save(User user) {
    if(findById(user.getId()).isPresent()) {
      int index = -1;
      for(var i = 0; i < userList.size(); i++) {
        var u = userList.get(i);
        if(u.getId().equals(user.getId())) {
          index = i;
            break;
         }
       }
		
       if(index != -1) {
         userList.set(index, user);
       }
       
      return user;
	}
	  
	Long id = Long.parseLong(String.format("%d", userList.size() + 1));
	user.setId(id);
    userList.add(user);
    return user;
  }

  public List<User> findAll() {
	return userList ;
  }

  public Optional<User> findById(Long id) {
	for(var user : userList) {
	  if(user.getId().equals(id)) {
	    return Optional.<User>of(user);
	  }
	}
	
	return Optional.<User>ofNullable(null);
  }

  public Optional<User> delete(User user) {
    int  index = -1; 
	for(var i = 0; i < userList.size(); i++) {
      var u = userList.get(i);
      if(u.getId().equals(user.getId())) {
        index = i;
        break;
      }
    }
    
	if(index != -1) {
	  userList.remove(index);
	}
	
    return Optional.<User>of(user);
  }
}