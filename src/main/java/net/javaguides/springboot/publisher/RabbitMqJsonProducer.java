package net.javaguides.springboot.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.dto.User;

@Service
public class RabbitMqJsonProducer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqJsonProducer.class);
	
	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	
	@Value("${rabbitmq.json.routing.key}")
	private String routingJsonKey;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendJsonMessage(User user) {
		LOGGER.info(String.format("Json Message sent -> %s", user.toString()));
		rabbitTemplate.convertAndSend(exchange, routingJsonKey, user);
	}

}
