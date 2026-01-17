package com.LearningHub.SpringAlBot.dto;

public class LanguageOutput {
    private String name;
    private String description;
    private String foundedYear;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFoundedYear() {
        return foundedYear;
    }

    public void setFoundedYear(String foundedYear) {
        this.foundedYear = foundedYear;
    }

    public LanguageOutput() {
    }

    public LanguageOutput(String name, String description, String foundedYear) {
        this.name = name;
        this.description = description;
        this.foundedYear = foundedYear;
    }
}
