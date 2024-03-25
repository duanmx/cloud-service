package com.duan.common.redis.utils;

import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 * 
 * @author duanmx
 */
@Component
public class RedisUtil {

	@Resource
	private RedisTemplate<String,String> redisTemplate;

	public RedisUtil() {
	}

	public boolean set(String key, String value) {
		boolean result = false;

		try {
			ValueOperations<String, String> operations = this.redisTemplate.opsForValue();
			operations.set(key, value);
			result = true;
		} catch (Exception var5) {
			var5.printStackTrace();
		}

		return result;
	}

	public boolean set(String key, String value, long expireTime) {
		boolean result = false;

		try {
			ValueOperations<String, String> operations = this.redisTemplate.opsForValue();
			operations.set(key, value);
			this.redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
			result = true;
		} catch (Exception var7) {
			var7.printStackTrace();
		}

		return result;
	}

	public boolean set(String key, String value, long expireTime, TimeUnit timeUnit) {
		boolean result = false;

		try {
			ValueOperations<String, String> operations = this.redisTemplate.opsForValue();
			operations.set(key, value);
			this.redisTemplate.expire(key, expireTime, timeUnit);
			result = true;
		} catch (Exception var8) {
			var8.printStackTrace();
		}

		return result;
	}

	public boolean exists(String key) {
		return this.redisTemplate.hasKey(key);
	}

	public String get(String key) {
		String result = null;
		ValueOperations<String, String> operations = this.redisTemplate.opsForValue();
		result = operations.get(key);
		return result;
	}

	public void remove(String key) {
		if (this.exists(key)) {
			this.redisTemplate.delete(key);
		}

	}

	public void removePattern(String pattern) {
		Set<String> keys = this.redisTemplate.keys(pattern);
		if (keys.size() > 0) {
			this.redisTemplate.delete(keys);
		}

	}

	public void remove(String... keys) {
		String[] var2 = keys;
		int var3 = keys.length;

		for(int var4 = 0; var4 < var3; ++var4) {
			String key = var2[var4];
			this.remove(key);
		}

	}

	public List<String> keys(String pattern) {
		Set<String> keys = this.redisTemplate.keys(pattern);
		List<String> list = new ArrayList();
		list.addAll(keys);
		return list;
	}

	public List<String> like(String pattern) {
		List<String> values = new ArrayList();
		Set<String> keys = this.redisTemplate.keys(pattern);
		Iterator var4 = keys.iterator();
		while(var4.hasNext()) {
			String key = (String)var4.next();
			if (this.exists(key)) {
				values.add(this.get(key));
			}
		}
		return values;
	}


	public void setHashValue(String key, String key2, String obj) {
		this.redisTemplate.opsForHash().put(key, key2, obj);
	}

	public Boolean expire(String key, long time) {
		if (time > 0L) {
			this.redisTemplate.expire(key, time, TimeUnit.SECONDS);
		}

		return true;
	}

	public Long getExpire(String key) {
		return this.redisTemplate.getExpire(key, TimeUnit.SECONDS);
	}

	public Boolean hasKey(String key) {
		return this.redisTemplate.hasKey(key);
	}

	public Long incr(String key, long delta) {
		return this.redisTemplate.opsForValue().increment(key, delta);
	}

	public Long decr(String key, long delta) {
		return this.redisTemplate.opsForValue().increment(key, -delta);
	}

	public Object hGet(String key, String hashKey) {
		return this.redisTemplate.opsForHash().get(key, hashKey);
	}

	public Boolean hSet(String key, String hashKey, String value, long time) {
		this.redisTemplate.opsForHash().put(key, hashKey, value);
		return this.expire(key, time);
	}

	public void hSet(String key, String hashKey, String value) {
		this.redisTemplate.opsForHash().put(key, hashKey, value);
	}

	public Map<Object, Object> hGetAll(String key) {
		return this.redisTemplate.opsForHash().entries(key);
	}

	public Boolean hSetAll(String key, Map<String, String> map, long time) {
		this.redisTemplate.opsForHash().putAll(key, map);
		return this.expire(key, time);
	}

	public void hSetAll(String key, Map<String, String> map) {
		this.redisTemplate.opsForHash().putAll(key, map);
	}

	public void hDel(String key, String... hashKey) {
		this.redisTemplate.opsForHash().delete(key, hashKey);
	}

	public Boolean hHasKey(String key, String hashKey) {
		return this.redisTemplate.opsForHash().hasKey(key, hashKey);
	}

	public Long hIncr(String key, String hashKey, Long delta) {
		return this.redisTemplate.opsForHash().increment(key, hashKey, delta);
	}

	public Long hDecr(String key, String hashKey, Long delta) {
		return this.redisTemplate.opsForHash().increment(key, hashKey, -delta);
	}

	public Set<String> sMembers(String key) {
		return this.redisTemplate.opsForSet().members(key);
	}

	public Long sAdd(String key, long time, String... values) {
		Long count = this.redisTemplate.opsForSet().add(key, values);
		this.expire(key, time);
		return count;
	}

	public Boolean sIsMember(String key, String value) {
		return this.redisTemplate.opsForSet().isMember(key, value);
	}

	public Long sSize(String key) {
		return this.redisTemplate.opsForSet().size(key);
	}

	public Long sRemove(String key, String... values) {
		return this.redisTemplate.opsForSet().remove(key, values);
	}

	public List<String> lRange(String key, long start, long end) {
		return this.redisTemplate.opsForList().range(key, start, end);
	}

	public Long lSize(String key) {
		return this.redisTemplate.opsForList().size(key);
	}

	public String lIndex(String key, long index) {
		return this.redisTemplate.opsForList().index(key, index);
	}

	public Long lPush(String key, String value) {
		return this.redisTemplate.opsForList().rightPush(key, value);
	}

	public Long lPush(String key, String value, long time) {
		Long index = this.redisTemplate.opsForList().rightPush(key, value);
		this.expire(key, time);
		return index;
	}
	public Long lPushAll(String key, String... values) {
		return this.redisTemplate.opsForList().rightPushAll(key, values);
	}
	public Long lPushAll(String key, Long time, String... values) {
		Long count = this.redisTemplate.opsForList().rightPushAll(key, values);
		this.expire(key, time);
		return count;
	}
	public Long lRemove(String key, long count, String value) {
		return this.redisTemplate.opsForList().remove(key, count, value);
	}
}