package com.LearningHub.SpringAlBot.service;

import com.LearningHub.SpringAlBot.dto.LanguageOutput;

public interface TestAiService {
    public LanguageOutput testAiModel(String prompt);
}
