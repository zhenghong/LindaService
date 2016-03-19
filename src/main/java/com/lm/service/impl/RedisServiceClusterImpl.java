package com.lm.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lm.service.RedisServiceCluster;

import redis.clients.jedis.JedisCluster;

@Service("redisCluster")
public class RedisServiceClusterImpl implements RedisServiceCluster {

	@Autowired
	JedisCluster jc;

	// String
	public void setString(String key, String value){

		jc.set(key, value);
	}

	public void delString(String key){

		jc.del(key);
	}

	public String getString(String key, String value){

		return jc.get(key);
	}

	// hash
	public void addHash(String key, Map<String,String> value){

		jc.hmset(key, value);
	}

	public void delHash(String key){

		jc.del(key);
	}

	public void setHash(String key, String cKey, String cValue){

		jc.hset(key, cKey, cValue);
	}

	public String getHash(String key, String cKey){

		return jc.hget(key, cKey);
	}

	// list
	public void addList(String key, String... value){

		jc.lpush(key, value);
	}

	public void delList(String key){

		jc.del(key);
	}

	public Long getLenList(String key){

		return jc.llen(key);
	}

	public void setIndexList(String key, Long index, String value){

		jc.lset(key, index, value);
	}

	public String getList(String key, Long index){

		return jc.lindex(key, index);
	}

	public List<String> getAllList(String key, Long start, Long end){

		return jc.lrange(key, start, end);
	}

	// set
	public void addSet(String key, String... value){

		jc.sadd(key, value);
	}

	public void delSet(String key){

		jc.del(key);
	}

	public void delSomeSet(String key, String... value){

		jc.srem(key, value);
	}

	public Set<String> getAllSet(String key){

		return jc.smembers(key);
	}

	// sorted set
	public void addZSet(String key, Map<String,Double> value){

        jc.zadd(key, value);
	}

	public void delZSet(String key){

		jc.del(key);
	}

	public void delSomeZSet(String key, String... value){

		jc.zrem(key, value);
	}

	public Set<String> getAllZSet(String key, long start, long end){

		return jc.zrange(key, start, end);
	}

}
