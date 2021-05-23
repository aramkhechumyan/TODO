package com.example.todo;

public final class TodoModel {
    private final String title;
    private final String description;
    private final String time;

    public TodoModel(String title, String description, String time) {
        this.title = title;
        this.description = description;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTime() {
        return time;
    }
}
