package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
/**
 * Created by nabdulla on 9/14/15.
 */
public class GoodMood extends Mood {
    public GoodMood (String mood, Date date) {
        super(mood,date);
    }

    public GoodMood (String mood) {
        super(mood);
        this.setMood(mood);
    }

    public String whatMood() {
        setMood("Good");
        return mood;
    }
}
