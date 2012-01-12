/**
 * This class models a link to a website. It is represented by the address of
 * the website and some topics associated with that site.
 * @author Karlsruhe Institute of Technology, IPD Pretschner/Snelting
 */
public class Link {

	/** link to "kicker.de" */
	public static final Link KICKER = new Link("kicker.de", new Topic[] { Topic.SOCCER });

	/** link to "sport1.de" */
	public static final Link SPORT1 =
		new Link("sport1.de", new Topic[] { Topic.SOCCER, Topic.RACING, Topic.SWIMMING, Topic.VOLLEYBALL });

	/** link to "formula1.com" */
	public static final Link FORMULA1 = new Link("formula1.com", new Topic[] { Topic.RACING });

	/** link to "rockhall.com" */
	public static final Link ROCKHALL = new Link("rockhall.com", new Topic[] { Topic.ROCK });

	/** link to "grooveshark.com" */
	public static final Link GROOVESHARK =
		new Link("grooveshark.com", new Topic[] { Topic.ROCK, Topic.DUBSTEP, Topic.CLASSIC, Topic.JAZZ });

	/** link to "www.classicfm.co.uk" */
	public static final Link CLASSICFM = new Link("www.classicfm.co.uk", new Topic[] { Topic.CLASSIC });

	/** collection of predefined links */
	public static final Link[] PREDEFINED = new Link[] { KICKER, SPORT1, FORMULA1, ROCKHALL, GROOVESHARK, CLASSICFM };

	/** address of this link */
	private final String url;

	/** topics associated to the linked website */
	private final Topic[] associatedTopics;

	/**
	 * Constructs a new link to the given website, which is associated to the given topics.
	 * @param url address of the linked website
	 * @param topics topics associated to the linked website
	 */
	public Link(String url, Topic[] topics) {
		if (url == null) {
			throw new IllegalArgumentException();
		} else if (topics == null) {
			throw new IllegalArgumentException();
		}

		this.url = url;
		this.associatedTopics = topics.clone();
	}

	/**
	 * This method is called when this link is added to the given profile, for example
	 * when a person likes it.
	 * @param p profile to which this link is added
	 */
	public void likedBy(AbstractProfile p) {
		if (p == null) {
			throw new IllegalArgumentException();
		}

		for (Topic t : associatedTopics) {
			p.addInterestFor(t);
		}
	}

	/**
	 * Returns a string representation to this link
	 * @return a string representation to this link
	 */
	public String toString() {
		return "Link(" + url + ")";
	}

	/**
	 * Returns {@code true}, if this instance and the specified {@link Link} are equal.
	 *
	 * @param other the other link
	 * @return {@code true}, if this instance and the specified {@link Link} equal, {@code false} otherwise
	 */
	public boolean equals(Link other) {
		return other != null && url.equals(other.url);
	}

	/**
	 * Returns the link to the given address. That link is one of the {@link Link#PREDEFINED statically
	 * declared links}.
	 * If none of the constants points to the given address, {@code null} is returned.
	 *
	 * @param url address to which the link is to be returned
	 * @return the link to the given address
	 */
	public static Link find(String url) {
		if (url == null) {
			throw new IllegalArgumentException();
		}

		for (Link l : PREDEFINED) {
			if (url.equals(l.url)) {
				return l;
			}
		}

		return null;
	}

}
