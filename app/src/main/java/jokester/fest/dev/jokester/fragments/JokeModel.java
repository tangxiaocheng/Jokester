package jokester.fest.dev.jokester.fragments;

/**
 * Created by randy on 10/9/17.
 */

public class JokeModel {
    String author;
    String body;
    String title;
    String uid;
    long viewCount;

    public JokeModel() {
    }

    public JokeModel(String author, String body, String title, String uid, long viewCount) {
        this.author = author;
        this.body = body;
        this.title = title;
        this.uid = uid;
        this.viewCount = viewCount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public long getViewCount() {
        return viewCount;
    }

    public void setViewCount(long viewCount) {
        this.viewCount = viewCount;
    }
}
