/**
 * This class encapsulates a similarity computation mechanism. It provides
 * a method which takes two profiles and computes a similarity value
 * based on their friends and/or interests. Since there are several different possibilities
 * to compute such a similarity value, this method is, like this class,
 * abstract. Concrete subclasses specify the respective concrete computation.
 * @author Karlsruhe Institute of Technology, IPD Pretschner/Snelting
 *
 */
public abstract class ProfileSimilarity {

	/**
	 * Computes a similarity value between the two given abstract profiles.
	 * @param p1 first profile
	 * @param p2 second profile
	 * @return a similarity value between the two given abstract profiles
	 */
	public abstract double compute(AbstractProfile p1, AbstractProfile p2);

}
