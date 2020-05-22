package com.manycode.app.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;




@Configuration
@EnableWebSocketMessageBroker
public class WsConfig implements WebSocketMessageBrokerConfigurer{
	
	private static final Logger LOGGER=LoggerFactory.getLogger(WsConfig.class);

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		//WebSocketMessageBrokerConfigurer.super.registerStompEndpoints(registry);
		LOGGER.info("....registerStompEndpoints");
		registry.addEndpoint("/manycode").withSockJS();
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		//WebSocketMessageBrokerConfigurer.super.configureMessageBroker(registry);
		LOGGER.info("....configureMessageBroker");
		registry.enableSimpleBroker("/topic");
		registry.setApplicationDestinationPrefixes("/app");
	}
	
}
