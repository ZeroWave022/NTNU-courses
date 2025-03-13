package assignment5.twitter;

import java.util.Comparator;

public class FollowersCountComparator implements Comparator<TwitterAccount> {
    @Override
    public int compare(TwitterAccount a1, TwitterAccount a2) {
        return Integer.compare(a2.getFollowers().size(), a1.getFollowers().size());
    }
}
