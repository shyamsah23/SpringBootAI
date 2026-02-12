package com.LearningHub.SpringAlBot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class RagService {

    private final ChatClient client;
    private final VectorStore vectorStore;

    Logger log = LoggerFactory.getLogger(RagService.class);

    public RagService(ChatClient client, VectorStore vectorStore) {
        this.client = client;
        this.vectorStore = vectorStore;
    }

    public String ask(String question) {

        var documents = vectorStore.similaritySearch(
                SearchRequest.builder()
                        .query(question)
                        .topK(2)
                        .build()
        );
        String context = documents.stream()
                .map(document -> document.getText())
                .collect(Collectors.joining("\n\n"));
        String prompt = """
            You are a helpful AI assistant.
                            Answer ONLY from the provided context.
                            If not found, say "I don't know".
            
                            Context:
                            %s
            
                            Question:
                            %s
            """.formatted(context,question);
        log.info("The Final Prompt is = [{}}",prompt);

        String response = client.prompt().user(prompt).call().content();
        return response;
    }


}
