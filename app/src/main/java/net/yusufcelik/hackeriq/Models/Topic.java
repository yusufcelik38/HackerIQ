package net.yusufcelik.hackeriq.Models;

public class Topic {
    private int id;
    private String title;
    private String description;

    public Topic(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {

        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }




}
