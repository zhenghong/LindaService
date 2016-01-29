package com.lm.mapping;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lm.model.User;

@Component
public interface UserMapper {
	
	User getUserEntityById(String userId);
	
	List<User> getUserEntities();
	
	int insertUser(User userEntity);
	
	void delUser(String userId);
}
