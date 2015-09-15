package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
/**
 * Created by nabdulla on 9/14/15.
 */
public class NormalTweet extends Tweet implements Tweetable{
    public NormalTweet (String tweet, Date date) {
        super(tweet,date);
    }

    public NormalTweet(String text) {
        super(text);
        this.setText(text);
    }

    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
