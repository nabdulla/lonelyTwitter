package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by nabdulla on 9/14/15.
 *
 * We don't want to allow someone to go tweet.text = ""
 * we want to force them to call a mehod instead
 */
public abstract class Tweet {
    protected String text;
    private Date date;
    private ArrayList<Mood> moodList;

    public Tweet(String tweet, Date date) {
        text = tweet;
        this.date = new Date();
    }
    public Tweet(String tweet) {
        text = tweet;
        this.date = new Date();
    }
    public String getText() {
        return text;
    }

    //x.y in java is basically x->y in C

    public void setText(String text) {
        if (text.length() <= 140) {
            this.text = text;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public abstract Boolean isImportant();

    public abstract String whatMood();

}
