package com.LearningHub.SpringAlBot.controller;

import com.LearningHub.SpringAlBot.dto.GenericOutput;
import com.LearningHub.SpringAlBot.service.TestAiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ai")
public class TestAIController {

    Logger log = LoggerFactory.getLogger(TestAIController.class);


    private  TestAiService testAiService;

    public TestAIController(TestAiService testAiService) {
        this.testAiService = testAiService;
    }

    @GetMapping("/test")
    public ResponseEntity<List<GenericOutput>> testAiModel(@RequestParam String query) {
        List<GenericOutput> response = testAiService.testAiModel(query);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
