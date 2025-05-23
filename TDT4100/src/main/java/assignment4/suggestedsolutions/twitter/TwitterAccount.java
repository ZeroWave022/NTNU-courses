package assignment4.suggestedsolutions.twitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class TwitterAccount {

	// You actually only need to instantiate one list (could also be following, but
	// it will be
	// advantageous in oving5 to do it this way). One advantage of using a set is
	// that it doesn't
	// allow duplicates, so you don't have to check whether the user is already
	// following the other
	// user
	private final Collection<TwitterAccount> followers = new HashSet<>();
	private final List<Tweet> tweets = new ArrayList<>();
	private final String userName;

	public TwitterAccount(String username) {
		if (username == null) {
			throw new IllegalArgumentException("Username cannot be null");
		}

		this.userName = username;
	}

	public String getUserName() {
		return this.userName;
	}

	public void follow(TwitterAccount otherUser) {
		if (otherUser == this) {
			throw new IllegalStateException("You cannot follow yourself");
		}
		if (otherUser == null) {
			throw new IllegalArgumentException("User cannot be null");
		}

		otherUser.followers.add(this);
	}

	public void unfollow(TwitterAccount otherUser) {
		otherUser.followers.remove(this);
	}

	public boolean isFollowing(TwitterAccount otherUser) {
		return otherUser.followers.contains(this);
	}

	public boolean isFollowedBy(TwitterAccount otherUser) {
		return this.followers.contains(otherUser);
	}

	public void tweet(String text) {
		Tweet tweet = new Tweet(this, text);
		this.tweets.add(tweet);
	}

	public void retweet(Tweet tweet) {
		Tweet retweet = new Tweet(this, tweet);
		this.tweets.add(retweet);
	}

	public Tweet getTweet(int i) {
		return this.tweets.get(this.tweets.size() - i);
	}

	public int getTweetCount() {
		return this.tweets.size();
	}

	public int getRetweetCount() {
		int count = 0;

		for (Tweet tweet : this.tweets) {
			count += tweet.getRetweetCount();
		}

		return count;
	}

	@Override
	public String toString() {
		return String.format("[Username: %s - %d tweets]", this.userName, this.getTweetCount());
	}
}
