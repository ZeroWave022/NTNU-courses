package assignment5.twitter;

import java.util.ArrayList;
import java.util.Comparator;
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

    public List<TwitterAccount> getFollowers() {
        return this.followers;
    }

    public List<TwitterAccount> getFollowers(Comparator<TwitterAccount> comparator) {
        return this.followers.stream().sorted(comparator).toList();
    }

    public static void main(String[] args) {
        Comparator<TwitterAccount> c = new TweetsCountComparator();
        TwitterAccount user = new TwitterAccount("user");
        TwitterAccount john = new TwitterAccount("john");
        TwitterAccount victoria = new TwitterAccount("victoria");
        victoria.tweet("tweet");
        john.follow(user);
        victoria.follow(user);
        System.out.println(user.getFollowers(c).stream().map(a -> a.getUserName()).toList());
    }
}
