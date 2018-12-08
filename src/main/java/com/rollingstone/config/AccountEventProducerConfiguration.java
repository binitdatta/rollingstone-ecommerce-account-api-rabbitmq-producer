package com.rollingstone.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

@Configuration
public class AccountEventProducerConfiguration {

	@Value("${account.exchange.name}")
	private  String accountExchangeName;
	
	@Value("${account.queue.name}")
	private  String accountQueueName;
	
	@Value("${account.routing.key}")
	private  String accountRoutingKeyName;
	
	
	/* Creating a bean for the Account Message queue Exchange */
	@Bean
	public TopicExchange getAccountTopicExchange() {
		return new TopicExchange(accountExchangeName);
	}
	
	/* Creating a bean for the Account Message queue */
	@Bean
	public Queue getAccountQueue() {
		return new Queue(accountQueueName);
	}
	
	/* Binding between Exchange and Queue using routing key */
	@Bean
	public Binding bindAccountQueueForExchange() {
		return BindingBuilder.bind(getAccountQueue()).to(getAccountTopicExchange()).with(accountRoutingKeyName);
	}
	
	@Bean
	public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
		return new MappingJackson2MessageConverter();
	}
	
	@Bean
	public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
		DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
		factory.setMessageConverter(consumerJackson2MessageConverter());
		return factory;
	}

	public void configureRabbitListeners(final RabbitListenerEndpointRegistrar registrar) {
		registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
	}

}
