package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Observer;

import static java.util.Arrays.sort;

/**
 * Created by nabdulla on 9/28/15.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 implements MyObserver,MyObservable{

    private Boolean wasNotified = Boolean.FALSE;
    public ArrayList<MyObserver> observers;

    public TweetListTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void myNotify(Object observable){
        wasNotified = Boolean.TRUE;
    }

    public void testAddObserver(){
        TweetList list = new TweetList();
        list.addObserver(this);
        wasNotified = Boolean.FALSE;
        list.add(new NormalTweet("test"));
        //expect to be notified at this point
        assertTrue(wasNotified);
    }

    public void testTweetObserver(){
        TweetList list = new TweetList();
        list.addObserver(this);
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        wasNotified = Boolean.FALSE;
        tweet.setText("different");
        //expect to be notified at this point
        assertTrue(wasNotified);
    }

    public void testAddTweet() {
        TweetList list = new TweetList();
        try {
            list = new TweetList();
            list.add(new NormalTweet("test"));
        } catch (IllegalArgumentException exception){

        }
    }

    public void testDoubleAdd() {
        Tweet tweet = new NormalTweet("test");
        Tweet tweet1 = new NormalTweet("test");
        assertTrue(tweet.getText().compareTo(tweet1.getText()) == 0);

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

    private void notifyAllObservers(){
        for (MyObserver observer: observers){
            observer.myNotify(this);
        }
    }

    public void myNotify(MyObservable observable){
        notifyAllObservers();
    }

    public void addObserver(MyObserver observer){
        observers.add(observer);
    }
}