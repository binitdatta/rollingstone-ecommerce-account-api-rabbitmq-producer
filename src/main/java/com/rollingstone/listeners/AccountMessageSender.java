package com.rollingstone.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * Account Message sender to convert and send the account object message to account queue using exchange.
 * @author Binit Datta
 *
 */

@Component
public class AccountMessageSender {
	
	private static final Logger log = LoggerFactory.getLogger(AccountMessageSender.class);
	
	/**
	 * 
	 * @param rabbitTemplate
	 * @param accountExchange
	 * @param accountRoutingKey
	 * @param accountData
	 */
	public void sendMessage(RabbitTemplate rabbitTemplate, String accountExchange, String accountRoutingKey, Object accountData) {
		log.info("Sending message to the account queue using accountRoutingKey {}. Message= {}", accountRoutingKey, accountData);
		rabbitTemplate.convertAndSend(accountExchange, accountRoutingKey, accountData);
		log.info("The account message has been sent to the account queue.");
	}
}
