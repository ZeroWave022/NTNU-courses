package assignment5.suggestedsolutions.twitter;

import java.util.Comparator;

/**
 * Sorterer twitteraccountene basert på antall følgere.
 * {@link TwitterAccount}-kontoen med flest
 * følgere vil havne først.
 */
public class FollowersCountComparator implements Comparator<TwitterAccount> {

	@Override
	public int compare(TwitterAccount a1, TwitterAccount a2) {
		return Integer.compare(a2.getFollowerCount(), a1.getFollowerCount());
	}
}
