/**
 * This class models a profile in KITBook. It not only covers the {@link PersonProfile profiles of the 
 * KITBook's members} but also {@link SiteProfile profiles of websites}. Every profile maintains 
 * a collection of associated (or interesting) topics and provides some information about 
 * befriended {@code PersonProfile}s.<p>
 * Both the information about topics and befriended profiles can be used to {@link ProfileSimilarity compute 
 * similarities}
 * between profiles. In particular, the similarity between a person's profile and a website's profile can be computed
 * to estimate how interesting a website is to a person.
 * @author Karlsruhe Institute of Technology, IPD Pretschner/Snelting
 *
 */
public abstract class AbstractProfile {

	/** the topics associated to this profile */
	private final InterestList interests = new InterestList();

	/**
	 * Returns whether the given topic is associated to this profile.
	 * @param topic topic to check
	 * @return {@code true} if the given topic is associated to this profile,
	 * {@code false} otherwise
	 */
	public final boolean hasInterestFor(Topic topic) {
		if (topic == null) {
			throw new IllegalArgumentException();
		}

		return interests.contains(topic);
	}

	/**
	 * Adds the given topic to the topics associated to this profile,<br>
	 * if the given topic is not associated to this profile yet. 
	 * Otherwise, nothing happens. Additionally, it is returned whether the topic was actually 
	 * added.
	 * @param topic topic to add
	 * @return {@code true} if the topic is not contained in the list of interests, {@code false}
	 * otherwise
	 */
	public final boolean addInterestFor(Topic topic) {
		if (topic == null) {
			throw new IllegalArgumentException();
		}

		return interests.add(topic);
	}

	/**
	 * Removes the given topic from the topics associated to this profile,<br>
	 * if it is contained. Otherwise, nothing happens. Additionally, it is returned whether the topic was actually 
	 * removed. 
	 * @param topic topic to remove
	 * @return whether the topic is contained in the list of interests
	 */
	public final boolean removeInterestFor(Topic topic) {
		if (topic == null) {
			throw new IllegalArgumentException();
		}

		return interests.remove(topic);
	}

	/**
	 * Returns the topics associated to this profile.
	 * @return the topics associated to this profile
	 */
	public final Topic[] getInterests() {
		return interests.getTopics();
	}

	/**
	 * Returns the weight of the given topic in this profile's topic collection.
	 * @param topic topic to return the weight of
	 * @return the weight of the given topic in this profile's topic collection
	 */
	public final double getInterestWeight(Topic topic) {
		if (topic == null) {
			throw new IllegalArgumentException();
		}

		double result = 0.0;

		if (interests.contains(topic)) {
			result = (double) interests.getWeight(topic);
		}

		return result;
	}

	/**
	 * Returns the number of friends of this profile.
	 * @return the number of friends of this profile
	 */
	public abstract int getNumberOfFriends();

	/**
	 * Returns whether this profile is befriended with the given profile
	 * @param p profile to check friendship for
	 * @return true, if this profile is befriended with the given profile,
	 * false otherwise
	 */
	public abstract boolean isBefriendedWith(PersonProfile p);

	/**
	 * Returns the friends of this profile.
	 * @return the friends of this profile
	 */
	public abstract PersonProfile[] getFriends();

}
