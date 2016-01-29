package com.lm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lm.service.UserSessionServiceCluster;
import com.lm.utils.SessionToolUtil;

import redis.clients.jedis.JedisCluster;

@Service("ussiCluster")
public class UserSessionServiceClusterImpl implements UserSessionServiceCluster {

	@Autowired
	JedisCluster jedisCluster;

	public String add() {

		//System.out.println("add...............");
		
		String sid = new SessionToolUtil().generateSessionId();
		jedisCluster.set("sid", sid);
		
		System.out.println("add end......................");
		
		System.out.println("get sid......................"+jedisCluster.get("sid"));
		return sid;
	}

	public String get(String id) {

		String sid = jedisCluster.get("sid");
		return sid;
	}

	public void delete(String id) {

		jedisCluster.del(id);	
		
	}

}
