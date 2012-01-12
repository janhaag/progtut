/**
 * This class models the profile of a website. It is connected to that website by a {@link Link link}. The
 * topics associated to a {@code SiteProfile} are the topics associated to that link.<br>
 * A {@code SiteProfile} has no befriended {@link PersonProfile person profiles}.
 * @author  Karlsruhe Institute of Technology, IPD Pretschner/Snelting
 */
public class SiteProfile extends AbstractProfile {

	/** link to the website described by this profile */
	private final Link site;

	/**
	 * Constructs a new {@code SiteProfile} from the given link
	 * @param site the new profile's owning web site
	 */
	public SiteProfile(Link site) {
		if (site == null) {
			throw new IllegalArgumentException();
		}

		this.site = site;
		this.site.likedBy(this);
	}

	/**
	 * Returns the friends of this profile. A site profile has no friends, thus
	 * 0 is returned.
	 * @return 0
	 */
	public int getNumberOfFriends() {
		return 0;
	}

	/**
	 * Returns whether this profile is befriended with the given person's profile.
	 * Since a site profile has no friends, {@code false} is returned.
	 * @param p person profile to be checked for friendship
	 * @return {@code false}
	 */
	public boolean isBefriendedWith(PersonProfile p) {
		return false;
	}

	/**
	 * Returns all the friends of this profile. Since a site profile has no
	 * friends, an empty array is returned.
	 * @return an empty array
	 */
	public PersonProfile[] getFriends() {
		return new PersonProfile[0];
	}

	/**
	 * Returns the link to the web site represented by this profile.
	 * @return the link to the web site represented by this profile
	 */
	public Link getSite() {
		return site;
	}

	/**
	 * Returns a string representation of this site profile.
	 * @return a string representation of this site profile
	 */
	public String toString() {
		return "SiteProfile of " + site;
	}

	/**
	 * Returns the site profiles of the {@link Link#PREDEFINED predefined websites}.
	 * @return the site profiles of the {@link Link#PREDEFINED predefined websites}
	 */
	public static SiteProfile[] getPredefinedSiteProfiles() {
		final SiteProfile[] all = new SiteProfile[Link.PREDEFINED.length];

		for (int i = 0; i < all.length; i++) {
			all[i] = new SiteProfile(Link.PREDEFINED[i]);
		}

		return all;
	}

}
