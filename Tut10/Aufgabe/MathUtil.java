/**
 * Provides some math operations.
 * @author Karlsruhe Institute of Technology, IPD Pretschner/Snelting
 *
 */
public final class MathUtil {

    /**
     * Private constructor - to avoid instantiation of utility class.
     */
	private MathUtil() {
	}

	/**
	 * Calculates the scalar product of the two specified vectors.
	 *
	 * If they differ in their length, <code>0</code> is returned.
	 *
	 * @param v1 the 1st vector
	 * @param v2 the 2nd vector
	 * @return The scalar product of the two vectors, or <code>0</code>,
	 * 		if their length differ.
	 */
	public static double scalarProduct(double[] v1, double[] v2) {
		if (v1 == null) {
			throw new IllegalArgumentException();
		} else if (v2 == null) {
			throw new IllegalArgumentException();
		}

		if (v1.length != v2.length) {
			return 0;
		}

		int result = 0;

		for (int i = 0; i < v1.length; i++) {
			result += v1[i] * v2[i];
		}

		return result;
	}

	/**
	 * Computes the cosine of the angle between two given vectors.
	 * @param v1 first vector
	 * @param v2 second vector
	 * @return the cosine of the angle between two given vectors
	 */
	public static double cosine(double[] v1, double[] v2) {
		if (v1 == null) {
			throw new IllegalArgumentException();
		} else if (v2 == null) {
			throw new IllegalArgumentException();
		}

		final double sprod = scalarProduct(v1, v2);
		final double norm = Math.sqrt(scalarProduct(v1, v1));
		final double otherNorm = Math.sqrt(scalarProduct(v2, v2));

		return sprod / (norm * otherNorm);
	}

}
