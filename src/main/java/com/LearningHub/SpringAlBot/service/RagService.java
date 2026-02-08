package com.LearningHub.SpringAlBot.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;


@Service
public class RagService {

    private final VectorStore vectorStore;
    private final ChatClient ragChatClient;


    public RagService(VectorStore vectorStore, ChatClient ragChatClient) {
        this.vectorStore = vectorStore;
        this.ragChatClient = ragChatClient;
    }

    // Step 1: Ingest documents into Pinecone
    public String ingest() {
        List<Document> documents = List.of(
                new Document("Spring Boot is a Java framework for building microservices."),
                new Document("Spring AI allows integration of AI models like Gemini into Spring applications."),
                new Document("Pinecone is a vector database used for similarity search in RAG systems.")
        );

        vectorStore.add(documents);

       return "Done Insertion";
    }

    public String ask(String question) {
        List<Document> similarDocs = vectorStore.similaritySearch(question);

        String context = similarDocs.stream()
                .map(Document::getFormattedContent)
                .collect(Collectors.joining("\n"));

        String prompt = """
            Use the following context to answer the question.
            If the answer is not present in the context, say you don't know.

            Context:
            %s

            Question:
            %s
            """.formatted(context, question);

        return ragChatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }
}
