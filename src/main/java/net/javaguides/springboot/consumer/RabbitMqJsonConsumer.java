package net.javaguides.springboot.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.dto.User;

@Service
public class RabbitMqJsonConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqJsonConsumer.class);
	
	@RabbitListener(queues = {"${rabbitmq.json.queue.name}"})
	public void consumeJsonMessage(User user) {
		LOGGER.info(String.format("Received Json Message -> %s", user.toString()));
	}

}
