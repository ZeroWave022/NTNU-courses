package assignment4.suggestedsolutions.twitter;

public class Tweet {

	private final String text;
	private final Tweet originalTweet;
	private final TwitterAccount owner;
	private int retweetCount = 0;

	public Tweet(TwitterAccount owner, String text) {
		if (owner == null) {
			throw new IllegalArgumentException("Owner cannot be null");
		}
		if (text == null) {
			throw new IllegalArgumentException("Text cannot be null");
		}

		this.owner = owner;
		this.text = text;
		this.originalTweet = null;
	}

	public Tweet(TwitterAccount owner, Tweet originalTweet) {
		if (owner == null) {
			throw new IllegalArgumentException("Owner cannot be null");
		}
		if (originalTweet == null) {
			throw new IllegalArgumentException("Original tweet cannot be null");
		}

		Tweet originalOriginalTweet = originalTweet.getOriginalTweet();

		if (originalTweet.getOwner() == owner
				|| (originalOriginalTweet != null && originalOriginalTweet.getOwner() == owner)) {
			throw new IllegalArgumentException("A tweet cannot be a retweet from the same author");
		}

		this.owner = owner;
		this.originalTweet = (originalOriginalTweet != null ? originalOriginalTweet : originalTweet);
		this.originalTweet.retweetCount++;
		this.text = this.originalTweet.getText();
	}

	public String getText() {
		return this.text;
	}

	public TwitterAccount getOwner() {
		return this.owner;
	}

	public Tweet getOriginalTweet() {
		return this.originalTweet;
	}

	public int getRetweetCount() {
		return this.retweetCount;
	}

	@Override
	public String toString() {
		return String.format("[%s: %s%s]", this.owner.getUserName(), this.text,
				(this.originalTweet == null ? ""
						: " - retweet of " + this.originalTweet.getOwner().getUserName()));
	}
}
