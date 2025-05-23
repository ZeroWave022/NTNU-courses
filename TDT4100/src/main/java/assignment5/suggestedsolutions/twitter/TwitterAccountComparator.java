package assignment5.suggestedsolutions.twitter;

import java.util.Comparator;

/**
 * Sorterer {@link TwitterAccount}-kontoer basert på følgende kriterier: Antall
 * følgere, antall
 * tweets og brukernavn.
 * 
 * @see FollowersCountComparator#compare(TwitterAccount, TwitterAccount)
 * @see TweetsCountComparator#compare(TwitterAccount, TwitterAccount)
 * @see UserNameComparator#compare(TwitterAccount, TwitterAccount)
 */
public class TwitterAccountComparator implements Comparator<TwitterAccount> {

    private final FollowersCountComparator followersCountComparator = new FollowersCountComparator();
    private final TweetsCountComparator tweetsCountComparator = new TweetsCountComparator();
    private final UserNameComparator userNameComparator = new UserNameComparator();

    @Override
    public int compare(TwitterAccount twitterAccount1, TwitterAccount twitterAccount2) {
        int diff = this.followersCountComparator.compare(twitterAccount1, twitterAccount2);

        if (diff != 0) {
            return diff;
        }

        diff = this.tweetsCountComparator.compare(twitterAccount1, twitterAccount2);

        if (diff != 0) {
            return diff;
        }
        return this.userNameComparator.compare(twitterAccount1, twitterAccount2);
    }
}
