package com.back;

public class WiseSaying {
    private int id;
    private String author;
    private String content;

    public WiseSaying(int id, String author, String content){
        this.id = id;
        this.author = author;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }
}
