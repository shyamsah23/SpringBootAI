package com.LearningHub.SpringAlBot.dto;

public class GenericOutput {
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

    public GenericOutput() {
    }

    public GenericOutput(String name, String description, String foundedYear) {
        this.name = name;
        this.description = description;
        this.foundedYear = foundedYear;
    }
}
