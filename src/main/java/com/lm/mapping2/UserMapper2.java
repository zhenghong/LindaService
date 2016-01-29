package com.lm.mapping2;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lm.model.User;

@Component
public interface UserMapper2 {
	
	User getUserEntityById(String userId);
	
	List<User> getUserEntities();
	
	int insertUser(User userEntity);
}
