package com.example.mystdprj.model;

public class NotifyContent {
    int SubIdx;
    String Category;
    String Subject;
    String Content;

    public NotifyContent(int subIdx, String category, String subject, String content) {
        SubIdx = subIdx;
        Category = category;
        Subject = subject;
        Content = content;
    }

    public int getSubIdx() {
        return SubIdx;
    }

    public String getCategory() {
        return Category;
    }

    public String getSubject() {
        return Subject;
    }

    public String getContent() {
        return Content;
    }
}
