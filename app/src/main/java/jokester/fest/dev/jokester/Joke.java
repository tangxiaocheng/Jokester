package jokester.fest.dev.jokester;

/**
 * Created by randy on 10/9/17.
 */

public class Joke {

   private String content;
    private   String time;
    private   String postUserId;
    private  String readingCount;
    private String jokeId;

    public Joke(String content, String time, String postUserId, String readingCount, String jokeId) {
        this.content = content;
        this.time = time;
        this.postUserId = postUserId;
        this.readingCount = readingCount;
        this.jokeId = jokeId;
    }

    public Joke(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPostUserId() {
        return postUserId;
    }

    public void setPostUserId(String postUserId) {
        this.postUserId = postUserId;
    }

    public String getReadingCount() {
        return readingCount;
    }

    public void setReadingCount(String readingCount) {
        this.readingCount = readingCount;
    }

    public String getJokeId() {
        return jokeId;
    }

    public void setJokeId(String jokeId) {
        this.jokeId = jokeId;
    }

    public String getContent() {

        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
