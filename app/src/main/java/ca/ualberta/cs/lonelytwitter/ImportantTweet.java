package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by nabdulla on 9/14/15.
 */
public class ImportantTweet extends Tweet implements Tweetable {
    public ImportantTweet(String tweet, Date date) {
        super(tweet, date);
    }

    public ImportantTweet(String text) {
        super(text);
        this.setText(text);
    }

    public Boolean isImportant() {
        return Boolean.TRUE;
    }

    public void setText(String text) {
        super.setText(text);
    }
}
