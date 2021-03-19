package com.springboot.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class RedisReciever implements MessageListener  {

	private static final Logger LOGGER = LoggerFactory.getLogger(RedisReciever.class);


	public void onMessage(Message message, byte[] pattern) {
		// TODO Auto-generated method stub
		Jedis jedis = new Jedis("localhost",6379);
		System.out.println(jedis.blpop(0,"messageTest"));
		LOGGER.info("Received data - " + message.toString() + " from Topic - " + new String(pattern));
	}
}