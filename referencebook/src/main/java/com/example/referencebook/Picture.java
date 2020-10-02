package com.example.referencebook;

public class Picture {
    private String name;
    private String description;
    private int image;

    public Picture(String name, String description, int image){

        this.name=name;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return this.image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
