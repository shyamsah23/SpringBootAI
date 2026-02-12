package com.LearningHub.SpringAlBot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;


@Service
public class DocumentLoaderService {

    Logger logger = LoggerFactory.getLogger(DocumentLoaderService.class);

    private final VectorStore vectorStore;

    public DocumentLoaderService(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }
    // This was done for testing Purpose
//    @PostConstruct
//    public void loadDocument() {
//        logger.info("Started Adding the docs in pineCone database");
//        List<Document> docs = List.of(
//                new Document("PineCone is very Usefull"),
//                new Document("PineCone is an vector database for AI Applications"),
//                new Document("Gemini is a Large Language model by google , it is like chatgpt")
//        );
//
//        vectorStore.add(docs);
//    }
}
