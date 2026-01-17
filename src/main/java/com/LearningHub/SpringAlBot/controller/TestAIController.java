package com.LearningHub.SpringAlBot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class TestAIController {

    Logger log = LoggerFactory.getLogger(TestAIController.class);

    private final ChatClient client;

    public TestAIController(ChatClient.Builder builder) {
        this.client = builder.build();
    }

    @GetMapping("/test")
    public String testAiModel(@RequestParam String query) {
        String response  = client.prompt(query).call().content();
        log.info(response);
        return response;
        

    }
}
