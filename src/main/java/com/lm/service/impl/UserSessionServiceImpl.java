package com.lm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.lm.model.User;
import com.lm.service.UserSessionService;
import com.lm.utils.SessionToolUtil;

public class UserSessionServiceImpl implements UserSessionService {

	@Autowired
	private RedisTemplate<String, User> redisTemplate;

	public String add(User user) {

		String sid = new SessionToolUtil().generateSessionId();

		ValueOperations<String, User> valueops = redisTemplate.opsForValue();
		valueops.set(sid, user);

		return sid;
	}

	public User get(String id) {

		ValueOperations<String, User> valueops = redisTemplate.opsForValue();
		User user = valueops.get(id);
		return user;
	}

	public void delete(String id) {

		redisTemplate.delete(id);
	}

}
