package com.siwoosiwoo.gachon_arnavigation_1011;

public class Post {
    private String id;
    private String text;

    public Post() {
        // Empty constructor required for Firebase database mapping
    }

    public Post(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}
