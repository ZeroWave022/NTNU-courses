package assignment5.solutions.twitter;

public class Tweet {
    private TwitterAccount owner;
    private Tweet originalTweet;
    private String text;
    private int retweets;

    public Tweet(TwitterAccount account, String text) {
        this.owner = account;
        this.text = text;
    }

    public Tweet(TwitterAccount account, Tweet originalTweet) {
        if (account == originalTweet.getOwner())
            throw new IllegalArgumentException("Cannot retweet own tweet");

        this.owner = account;
        while (originalTweet.originalTweet != null) {
            originalTweet = originalTweet.originalTweet;
        }
        this.originalTweet = originalTweet;
        this.originalTweet.incrementRetweets();
        this.text = this.originalTweet.getText();
    }

    public TwitterAccount getOwner() {
        return owner;
    }

    public Tweet getOriginalTweet() {
        return originalTweet;
    }

    public String getText() {
        return text;
    }

    public int getRetweetCount() {
        return this.retweets;
    }

    public void incrementRetweets() {
        if (this.originalTweet != null) {
            this.originalTweet.retweets += 1;
        } else {
            this.retweets += 1;
        }
    }
}
