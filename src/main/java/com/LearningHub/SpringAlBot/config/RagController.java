package com.LearningHub.SpringAlBot.config;

import com.LearningHub.SpringAlBot.service.RagService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RagController {

    private final RagService ragService;

    public RagController(RagService ragService) {
        this.ragService = ragService;
    }

    @PostMapping("/ingest")
    public String ingest() {
        return ragService.ingest();
    }

    @GetMapping("/ask")
    public String ask(@RequestParam String question) {
        return ragService.ask(question);
    }
}
