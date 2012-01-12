/**
 * This class implements a similarity mechanism based on common friends. Given
 * two profiles, their common friends are counted. Subsequently, that number is
 * divided by the number of friends of at least one of the two profiles, resulting
 * in a value between 0 (totally different friends) and 1 (absolutely same friends).
 * @author  Karlsruhe Institute of Technology, IPD Pretschner/Snelting
 */
public final class CountSameFriendsSimilarity extends ProfileSimilarity {

	/** the only instance of this class */
	public static final CountSameFriendsSimilarity INSTANCE = new CountSameFriendsSimilarity();

	/**
	 * Private constructor - avoids multiple instances of this class
	 */
	private CountSameFriendsSimilarity() {
	}

	/**
	 * Computes a similarity value between the two given abstract profiles based
	 * on the common friends. The value is normalized with respect to the number
	 * of profiles which are befriended with at least one of the given profiles.
	 * @param p1 first profile
	 * @param p2 second profile
	 * @return a similarity value between the two given abstract profiles
	 */
	public double compute(AbstractProfile p1, AbstractProfile p2) {
		if (p1 == null) {
			throw new IllegalArgumentException();
		} else if (p2 == null) {
			throw new IllegalArgumentException();
		}

		int count = 0;
		int numberOfAllFriends = 0;

		for (PersonProfile pp1 : p1.getFriends()) {
			numberOfAllFriends++;
			if (p2.isBefriendedWith(pp1)) {
				count++;
			}
		}

		for (PersonProfile pp2 : p2.getFriends()) {
			if (!p1.isBefriendedWith(pp2)) {
				numberOfAllFriends++;
			}
		}

		return ((double) count) / ((double) numberOfAllFriends);
	}

}
