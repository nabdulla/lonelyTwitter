package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import junit.framework.TestCase;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import static java.util.Arrays.sort;

/**
 * Created by nabdulla on 9/28/15.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testAddTweet() {
        try {
            list = new TweetList();
            list.add(new NormalTweet("test"));
        } catch (IllegalArgumentException exception);
    }

    public void testDoubleAdd() {
        Tweet tweet = new NormalTweet("test");
        Tweet tweet1 = new NormalTweet("test");


    }

    public void testDelete() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        list.delete(tweet);
        assertTrue(list.contains(tweet));
    }

    public void testContains() {
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        assertTrue(list.contains(tweet));
    }

    public void testGetTweets(){
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        Tweet tweet1 = new NormalTweet("test2");
        list.add(tweet1);
        list.add(tweet);
        list.getTweets();

    }

    public void testHasTweet(){
        TweetList list = new TweetList();

    }

    public void testRemoveTweet() {

    }

    public void testGetCount() {

    }
}