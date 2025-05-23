package assignment5.suggestedsolutions.twitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class TwitterAccount {

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
		// Streams solution:
		// return this.tweets.parallelStream().mapToInt(Tweet::getRetweetCount).sum();

		int count = 0;

		for (Tweet tweet : this.tweets) {
			count += tweet.getRetweetCount();
		}

		return count;
	}

	public int getFollowerCount() {
		return this.followers.size();
	}

	public List<TwitterAccount> getFollowers(Comparator<TwitterAccount> comparator) {
		// Streams solution:
		// return
		// this.followers.stream().sorted(comparator).collect(Collectors.toList());

		List<TwitterAccount> followersCopy = new ArrayList<>(this.followers);

		if (comparator == null) {
			return followersCopy;
		}

		followersCopy.sort(comparator);
		return followersCopy;
	}

	@Override
	public String toString() {
		return String.format("[Username: %s - %d tweets]", this.getUserName(),
				this.getTweetCount());
	}
}
