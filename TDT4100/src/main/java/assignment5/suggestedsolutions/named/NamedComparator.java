package assignment5.suggestedsolutions.named;

import java.util.Comparator;

public class NamedComparator implements Comparator<Named> {

	@Override
	public int compare(Named named1, Named named2) {
		int diff = named1.getFamilyName().compareToIgnoreCase(named2.getFamilyName());

		if (diff != 0) {
			return diff;
		}
		return named1.getGivenName().compareToIgnoreCase(named2.getGivenName());
	}
}
