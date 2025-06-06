package assignment5.solutions.twitter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FollowersCountComparatorTest {

	private TwitterAccount aaron;
	private TwitterAccount ben;
	private TwitterAccount charlie;
	private FollowersCountComparator comparator;

	@BeforeEach
	public void SetUp() {
		aaron = new TwitterAccount("aaron");
		ben = new TwitterAccount("ben");
		charlie = new TwitterAccount("charlie");
		comparator = new FollowersCountComparator();
	}

	@Test
	@DisplayName("Sjekk at sammenlikningen basert på følgere")
	public void testCompare() {
		aaron.follow(ben);
		ben.follow(aaron);
		assertEquals(0, comparator.compare(aaron, ben), "Aaron og Ben skulle vært like");

		charlie.follow(ben);
		assertTrue(comparator.compare(aaron, ben) > 0, "Aaron skulle vært etter Ben ");
		assertTrue(comparator.compare(ben, aaron) < 0, "Ben skulle vært før Aaron");
	}
}
