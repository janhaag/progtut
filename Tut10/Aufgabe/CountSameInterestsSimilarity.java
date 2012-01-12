/**
 * This class implements a similarity mechanism based on common interests. Given
 * two profiles, their common interests are counted. Subsequently, that number is
 * divided by the number of topics, in which at least one of the two profiles is
 * interested, resulting in a value between 0 (totally different interests) and
 * 1 (totally equal interests).
 * @author  Karlsruhe Institute of Technology, IPD Pretschner/Snelting
 */
public final class CountSameInterestsSimilarity extends ProfileSimilarity {

	/** the only instance of this class */
	public static final CountSameInterestsSimilarity INSTANCE = new CountSameInterestsSimilarity();

	/**
	 * Private constructor - avoids multiple instances of this class
	 */
	private CountSameInterestsSimilarity() {
	}

	/**
	 * Computes a similarity value between the two given abstract profiles based
	 * on the common interests. The value is normalized with respect to the number
	 * of all topics in which at least one of the profiles is interested.
	 * @param p1 first profile
	 * @param p2 second profile
	 * @return a similarity value between the two given abstract profiles based
	 * on their common interests
	 */
	public double compute(AbstractProfile p1, AbstractProfile p2) {
		if (p1 == null) {
			throw new IllegalArgumentException();
		} else if (p2 == null) {
			throw new IllegalArgumentException();
		}

		int count = 0;
		int numberOfAllTopics = 0;

		for (Topic t1 : p1.getInterests()) {
			numberOfAllTopics++;
			if (p2.hasInterestFor(t1)) {
				count++;
			}
		}

		for (Topic t2 : p2.getInterests()) {
			if (!p1.hasInterestFor(t2)) {
				numberOfAllTopics++;
			}
		}

		return ((double) count) / ((double) numberOfAllTopics);
	}

}
