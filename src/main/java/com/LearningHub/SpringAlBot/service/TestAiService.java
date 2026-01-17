package com.LearningHub.SpringAlBot.service;

import com.LearningHub.SpringAlBot.dto.GenericOutput;

import java.util.List;

public interface TestAiService {
    public List<GenericOutput> testAiModel(String prompt);
}
