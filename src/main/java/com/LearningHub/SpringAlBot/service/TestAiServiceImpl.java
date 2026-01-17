package com.LearningHub.SpringAlBot.service;

import com.LearningHub.SpringAlBot.dto.GenericOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestAiServiceImpl implements TestAiService{

    Logger logger = LoggerFactory.getLogger(TestAiServiceImpl.class);

    private final ChatClient client;

    public TestAiServiceImpl(ChatClient.Builder builder) {
        this.client = builder.build();
    }

    @Override
    public List<GenericOutput> testAiModel(String prompt) {
        List<GenericOutput> response = client.prompt(prompt).call()
                .entity(new ParameterizedTypeReference<List<GenericOutput>>() {});
        return response;
    }
}
