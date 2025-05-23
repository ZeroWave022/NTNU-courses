package assignment4.solutions;

import java.util.ArrayList;
import java.util.List;

public class TwitterAccount {
    private String username;
    private List<Tweet> tweets = new ArrayList<>();
    private List<TwitterAccount> following = new ArrayList<>();
    private List<TwitterAccount> followers = new ArrayList<>();

    public TwitterAccount(String username) {
        this.username = username;
    }

    public String getUserName() {
        return this.username;
    }

    public void follow(TwitterAccount account) {
        if (!this.following.contains(account))
            this.following.add(account);
        if (!account.isFollowedBy(this))
            account.followers.add(this);
    }

    public void unfollow(TwitterAccount account) {
        if (this.following.contains(account))
            this.following.remove(account);
        if (account.isFollowedBy(this))
            account.followers.remove(this);
    }

    public boolean isFollowing(TwitterAccount account) {
        return this.following.contains(account);
    }

    public boolean isFollowedBy(TwitterAccount account) {
        return this.followers.contains(account);
    }

    public void tweet(String text) {
        tweets.add(new Tweet(this, text));
    }

    public void retweet(Tweet tweet) {
        tweets.add(new Tweet(this, tweet));
    }

    public Tweet getTweet(int n) {
        return this.tweets.get(this.tweets.size() - n);
    }

    public int getTweetCount() {
        return this.tweets.size();
    }

    public int getRetweetCount() {
        return this.tweets.stream().mapToInt(tweet -> tweet.getRetweetCount()).sum();
    }
}
