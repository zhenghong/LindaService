package com.lm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lm.mapping.UserMapper;
import com.lm.model.User;
import com.lm.service.UserService;

@Service("usi")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	//private MessageSender messageSender;

	@Transactional(readOnly = false, rollbackFor = Exception.class)	
	public void insert() {

//		User user = new User();
//		user.setUserId("997");
//		this.userMapper.insertUser(user);

		//this.userMapper2.insertUser(user);

//		Object[] args = new Object[] { "001" };
//		MesInfo mi = new MesInfo("usi2", "testTX", args);
//		messageSender.send(mi);

//		int i = 1 / 0;

	}

	public User getUserEntityById(String userId) {
		return this.userMapper.getUserEntityById(userId);
	}

	public List<User> getUserEntities() {
		return this.userMapper.getUserEntities();
	}

	public User insertUserEntity(User userEntity) {
		this.userMapper.insertUser(userEntity);
		return getUserEntityById(userEntity.getUserId());
	}

	@Async
	public void delete(String userId) {
		this.userMapper.delUser(userId);
	}

}
