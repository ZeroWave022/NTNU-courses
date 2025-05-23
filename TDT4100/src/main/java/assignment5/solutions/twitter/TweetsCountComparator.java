package assignment5.solutions.twitter;

import java.util.Comparator;

public class TweetsCountComparator implements Comparator<TwitterAccount> {
    @Override
    public int compare(TwitterAccount a1, TwitterAccount a2) {
        return Integer.compare(a2.getTweetCount(), a1.getTweetCount());
    }
}
