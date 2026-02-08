package com.LearningHub.SpringAlBot.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ChatClientConfig {

    @Bean
    ChatClient chatClient(ChatClient.Builder builder){

        return  builder.build();
    }
}
