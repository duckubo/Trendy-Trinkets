package com.team5.model;

public class Feedback {
    private int id;
    private String description;
    private byte[] photo;

    public Feedback(int id, String description, byte[] photo) {
        this.id = id;
        this.description = description;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public byte[] getPhoto() {
        return photo;
    }
}
