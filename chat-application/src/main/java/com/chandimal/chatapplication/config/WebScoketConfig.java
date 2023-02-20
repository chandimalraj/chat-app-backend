package com.chandimal.chatapplication.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebScoketConfig implements WebSocketMessageBrokerConfigurer {

    //set up a message broker that can handle messages sent from the client to the server and vice versa.
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        registry.setApplicationDestinationPrefixes("/app");

        //any message sent to a destination starting with /chatroom and /user will be handled by the simple message broker.
        //topics are created and managed by message broker
        registry.enableSimpleBroker("/chatroom","/user");

        //configure the prefix that is added to the destination of a user-specific message
        registry.setUserDestinationPrefix("/user");

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        //define the endpoint URL(s) that clients can use to establish WebSocket connections with the server
       registry.addEndpoint("ws").setAllowedOriginPatterns("*").withSockJS();
    }
}
