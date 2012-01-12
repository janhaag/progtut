/**
 * This class provides a similarity mechanism which proceeds by combining
 * two given mechanisms to a weighted sum. For two given profiles, both
 * similarity values are computed and their weighted sum (for example
 * the average) is returned.
 *
 * @author Karlsruhe Institute of Technology, IPD Pretschner/Snelting
 */
public class CompositeProfileSimilarity extends ProfileSimilarity {

	/** first similarity mechanism */
	private final ProfileSimilarity ps1;

	/** second similarity mechanism */
	private final ProfileSimilarity ps2;

	/** weight of the first similarity mechanism in the weighted sum of the
	 * two mechanisms. The weight of the other mechanism is {@code 1 - ps1weight}.
	 */
	private final double ps1weight;

	/**
	 * Constructs a new CompositeProfileSimilarity which weights its two sub-mechanisms
	 * equally.
	 * @param ps1 first similarity mechanism
	 * @param ps2 second similarity mechanism
	 */
	public CompositeProfileSimilarity(ProfileSimilarity ps1, ProfileSimilarity ps2) {
		this(ps1, ps2, 0.5);
	}

	/**
	 * Constructs a new CompositeProfileSimilarity with the given values.
	 * @param ps1 first similarity mechanism
	 * @param ps2 second similarity mechanism
	 * @param ps1weight factor with which the first mechanism is weighted.
	 */
	public CompositeProfileSimilarity(ProfileSimilarity ps1, ProfileSimilarity ps2, double ps1weight) {
		if (ps1weight < 0.0 || ps1weight > 1.0) {
			throw new IllegalArgumentException("Weight has to be in the interval [0, 1], but was " + ps1weight);
		} else if (ps1 == null) {
			throw new IllegalArgumentException();
		} else if (ps2 == null) {
			throw new IllegalArgumentException();
		}

		this.ps1 = ps1;
		this.ps2 = ps2;
		this.ps1weight = ps1weight;
	}

	/**
	 * Computes the similarity value between the two given abstract profiles by evaluating the
	 * sub-mechanisms and then weighting them with {@link #ps1weight}.
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

		final double ps1result = ps1.compute(p1, p2);
		final double ps2result = ps2.compute(p1, p2);

		return (ps1weight * ps1result) + ((1 - ps1weight) * ps2result);
	}

}
