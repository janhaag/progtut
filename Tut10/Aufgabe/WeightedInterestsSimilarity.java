/**
 * This class provides a cosine-based similarity mechanism which takes the
 * profiles' interest lists into account. Given two profiles, the weights
 * of their respective interest lists are copied into vectors. Subsequently,
 * the cosine of the angle between these vectors is calculated by means
 * of the well-known formula involving the scalar product. The result is
 * a number between 0 (vectors orthogonal / totally different topics) and
 * one (vectors are equal up to a multiplicative constant / same topics and
 * weight ratios)
 * @author  Karlsruhe Institute of Technology, IPD Pretschner/Snelting
 */
public final class WeightedInterestsSimilarity extends ProfileSimilarity {

	/** the only instance of this class */
	public static final WeightedInterestsSimilarity INSTANCE = new WeightedInterestsSimilarity();

	/**
	 * private constructor
	 */
	private WeightedInterestsSimilarity() {
	}

	/**
	 * Computes the similarity between the two given profiles as the cosine of
	 * the angle between the profiles' interest weight vectors
	 * @param p1 first profile
	 * @param p2 second profile
	 * @return the cosine of
	 * the angle between the profiles' interest weight vectors
	 */
	public double compute(AbstractProfile p1, AbstractProfile p2) {
		if (p1 == null) {
			throw new IllegalArgumentException();
		} else if (p2 == null) {
			throw new IllegalArgumentException();
		}

		final Topic[] t = createCombinedTopics(p1, p2);

		final double[] p1Vector = new double[t.length];
		final double[] p2Vector = new double[t.length];

		for (int index = 0; index < t.length; index++) {
			final Topic topic = t[index];

			final double p1Weight = p1.getInterestWeight(topic);
			p1Vector[index] = p1Weight;

			final double p2Weight = p2.getInterestWeight(topic);
			p2Vector[index] = p2Weight;
		}

		return MathUtil.cosine(p1Vector, p2Vector);
	}

	/**
	 * Helper method for {@link #compute(AbstractProfile, AbstractProfile)}. Collects
	 * and returns all the topics to which at least one of the two given profiles is associated.
	 * @param p1 first profile
	 * @param p2 second profile
	 * @return all the topics to which at least one of the two given profiles is associated
	 */
	private static Topic[] createCombinedTopics(AbstractProfile p1, AbstractProfile p2) {
		final InterestList list = new InterestList();

		for (Topic t1 : p1.getInterests()) {
			list.add(t1);
		}

		for (Topic t2 : p2.getInterests()) {
			list.add(t2);
		}

		return list.getTopics();
	}

}
