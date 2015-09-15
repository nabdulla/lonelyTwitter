package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by nabdulla on 9/14/15.
 */
public class BadMood extends Mood {
    public BadMood (String mood, Date date) {
        super(mood,date);
    }

    public BadMood (String mood) {
        super(mood);
        this.setMood(mood);
    }

    public String whatMood() {
        setMood("Bad");
        return mood;
    }
}
