package com.LearningHub.SpringAlBot.controller;

import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ai/")
public class PineConeTestController {

    private final VectorStore vectorStore;

    public PineConeTestController(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    @GetMapping("pinecone")
    public void testPineConeDB() {
        List<Document> documents = List.of(
                new Document("Spring AI integrates AI into Java applications",
                        Map.of("source", "spring")),
                new Document("Pinecone is a vector database for similarity search",
                        Map.of("source", "pinecone")),
                new Document("Gemini provides powerful embedding models",
                        Map.of("source", "gemini"))
        );

        vectorStore.add(documents);
        System.out.println("Document Inserted Successfully");
    }

    @GetMapping("/pinecone/search")
    public List<Map<String, Object>> search(
            @RequestParam String query,
            @RequestParam(defaultValue = "3") int topK
    ) {
        List<Document> ans = vectorStore.similaritySearch(
                SearchRequest.builder()
                        .query(query)
                        .topK(topK)
                        .build()
        );

        System.out.println(ans);

        return ans.stream().map(document ->
                    Map.of("content", document.getText(),
                            "metadata",document.getMetadata(),
                            "score",document.getScore()
                    )
                ) .toList();
    }
}
