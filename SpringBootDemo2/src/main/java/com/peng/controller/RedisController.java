package com.peng.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peng.utils.RedisOperator;
@RestController
public class RedisController {
	private Logger logger=LoggerFactory.getLogger(RedisController.class);
	@Autowired
	private RedisOperator redisOperator;
	@GetMapping("/test")
	public String test() {
		logger.info("redisOperator="+redisOperator);
		redisOperator.set("hello", "hello world");
		return redisOperator.get("hello");
	}
	@GetMapping("/test1")
	public long test1() {
		redisOperator.expire("hello", 10);
		return redisOperator.ttl("hello");
	}
	

}
