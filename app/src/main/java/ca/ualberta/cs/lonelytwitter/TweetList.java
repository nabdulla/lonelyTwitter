package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by nabdulla on 9/28/15.
 */
public class TweetList {
    public ArrayList<Tweet> getTweets() {
        return tweets;
    }

    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void add(Tweet tweet){
        tweets.add(tweet);

    }
    public void delete(Tweet tweet){
        tweets.remove(tweet);

    }
    public boolean contains(Tweet tweet){
        return tweets.contains(tweet);

    }
    public TweetList getTweets(TweetList tweets) {

        //taken from http://stackoverflow.com/questions/18441846/how-to-sort-an-arraylist-in-java
        Collections.sort(tweets.getTweets(), new Comparator<Tweet>() {
            @Override
            public int compare(Tweet tweet1, Tweet tweet2) {

                return tweet1.getDate().compareTo(tweet2.getDate());

            }
        });
        return tweets;
    }
}
