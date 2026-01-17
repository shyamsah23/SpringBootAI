package com.LearningHub.SpringAlBot.service;

import com.LearningHub.SpringAlBot.dto.LanguageOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class TestAiServiceImpl implements TestAiService{

    Logger logger = LoggerFactory.getLogger(TestAiServiceImpl.class);

    private final ChatClient client;

    public TestAiServiceImpl(ChatClient.Builder builder) {
        this.client = builder.build();
    }

    @Override
    public LanguageOutput testAiModel(String prompt) {
        LanguageOutput response = client.prompt(prompt).call().entity(LanguageOutput.class);
        return response;
    }
}
