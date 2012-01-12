/**
 * The class {@code PersonProfile} represents the profile, a {@link Person member} of the KITBook (in the following: the <it>owner</it> of the profile).
 * 
 * It stores the current status and the inbox of the owner. Additionally, - as inherited from {@link AbstractProfile} - it maintains 
 * collections of associated topics and befriended {@code PersonProfile}s. The topics associated to a {@code PersonProfile} are the topics, 
 * which the owner of this profile is interested in. <br>
 * It is possible to post {@link Link links} on a person's profile. If such a link
 * is posted, the topics connected to that link are added to this profile's topics,
 * indicating that the profile's owner is interested in those topics. <br>
 * Furthermore, befriended {@code PersonProfile}s can be added and removed. 
 * @author  Karlsruhe Institute of Technology, IPD Pretschner/Snelting
 */
public class PersonProfile extends AbstractProfile {

	/** the maximum number of friends a member can have */
	public static final int MAX_FRIENDS = 20;

	/** the maximum number of links a member can post on his profile */
	public static final int MAX_LINKS = 30;

	/** the person to which this profile belongs */
	private final Person owner;

	/** current status of this profile's owner */
	private Message status;

	/** last school of this profile's owner */
	private School school;

	/** inbox of this profile's owner */
	private Message lastIncomingMessage;

	/** the friends of this profile */
	private final PersonProfile[] friends = new PersonProfile[MAX_FRIENDS];

	/** the current number of friends of this profile */
	private int currentFriendCount = 0;

	/** the links posted on this profile */
	private final Link[] links = new Link[MAX_LINKS];

	/** the current number of links posted on this profile */
	private int currentLinkCount = 0;

	/**
	 * Constructs a new profile for the given person.
	 * @param owner the owner of the new profile
	 */
	public PersonProfile(Person owner) {
		if (owner == null) {
			throw new IllegalArgumentException();
		}

		this.owner = owner;
	}

	/**
	 * Returns this profile's owner, or the person described by this profile, respectively.
	 * @return this profile's owner
	 */
	public Person getOwner() {
		return owner;
	}

	/**
	 * Returns this profile's owner's status.
	 * @return this profile's owner's status
	 */
	public Message getStatus() {
		return status;
	}

	/**
	 * Returns this profile's owner's last school.
	 * @return this profile's owner's last school
	 */
	public School getSchool() {
		return school;
	}

	/**
	 * Sets this profile's owner's last school.
	 * @param school the new school
	 */
	public void setSchool(School school) {
		this.school = school;
	}

	/**
	 * Sets the status of this profile.
	 * @param message text representing the new status of this profile
	 * @param time time at which the status update occurred
	 */
	public void setStatus(String message, Timestamp time) {
		if (time == null) {
			throw new IllegalArgumentException();
		}

		this.status = new Message(message, time, owner);
	}

	/**
	 * Stores the given message in this profile's inbox.
	 * @param msg message to recieve
	 */
	public void receiveMessage(Message msg) {
		if (msg == null) {
			throw new IllegalArgumentException();
		}

		this.lastIncomingMessage = msg;
	}

	/**
	 * Returns the last incoming message of this profile.
	 * @return the last incoming message of this profile
	 */
	public Message getLastIncomingMessage() {
		return lastIncomingMessage;
	}

	/**
	 * Returns whether this profile is befriended with the given profile
	 * @param p profile to check friendship
	 * @return true, if this profile is befriended with the given profile,
	 * false otherwise
	 */
	public boolean isBefriendedWith(PersonProfile p) {
		if (p == null) {
			throw new IllegalArgumentException();
		}

		for (int i = 0; i < currentFriendCount; i++) {
			if (p.equals(friends[i])) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Adds the given profile to the friends of this profile, if it was not
	 * already contained. Otherwise, nothing happens.
	 * @param p profile to add to friends
	 * @return {@code true} of given profile has not been a friend of this profile,
	 * {@code false} otherwise
	 */
	public boolean addFriendship(PersonProfile p) {
		if (p == null) {
			throw new IllegalArgumentException();
		}

		if (!isBefriendedWith(p) && currentFriendCount < MAX_FRIENDS) {
			friends[currentFriendCount] = p;
			currentFriendCount++;

			return true;
		} else {
			return false;
		}
	}

	/**
	 * Removes the given profile from the friends of this profile, if it is
	 * contained. Otherwise, nothing happens.
	 * @param p profile to remove
	 * @return {@code true} of given profile has been a friend of this profile,
	 * {@code false} otherwise
	 */
	public boolean removeFriendship(PersonProfile p) {
		if (p == null) {
			throw new IllegalArgumentException();
		}

		if (isBefriendedWith(p)) {
			int indexOfP = -1;

			for (int i = 0; i < currentFriendCount && indexOfP < 0; i++) {
				if (p.equals(friends[i])) {
					indexOfP = i;
				}
			}

			for (int i = indexOfP; i < currentFriendCount - 1; i++) {
				friends[i] = friends[i + 1];
			}

			friends[currentFriendCount - 1] = null;
			currentFriendCount--;

			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns the number of friends of this profile.
	 * @return the number of friends of this profile
	 */
	public int getNumberOfFriends() {
		return currentFriendCount;
	}

	/**
	 * Returns the friends of this profile.
	 * @return the friends of this profile
	 */
	public PersonProfile[] getFriends() {
		final PersonProfile[] copy = friends.clone();

		return copy;
	}

	/**
	 * Posts a link on this profile.
	 * @param link link to be posted
	 */
	public void postLink(Link link) {
		if (link == null) {
			throw new IllegalArgumentException();
		}

		if (!containsLink(link) && currentLinkCount < MAX_LINKS) {
			links[currentLinkCount] = link;
			currentLinkCount++;
		}

		link.likedBy(this);
	}

	/**
	 * Returns whether the given link has been posted on this profile.
	 * @param link link to check
	 * @return true if the given link has been posted on this profile, false
	 * otherwise
	 */
	private boolean containsLink(Link link) {
		assert link != null;

		for (int i = 0; i < currentLinkCount; i++) {
			if (link.equals(links[i])) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Returns the links which have been posted on this profile.
	 * @return the links which have been posted on this profile
	 */
	public Link[] getLinks() {
		Link[] copy = links.clone();

		return copy;
	}

	/**
	 * Returns the number of common interests of this and the given profile.
	 * @param other other profile
	 * @return the number of common interests of this and the given profile
	 */
	public int countSimilarities(PersonProfile other) {
		if (other == null) {
			throw new IllegalArgumentException();
		}

		int similar = 0;

		for (Topic topic : getInterests()) {
			if (other.hasInterestFor(topic)) {
				similar++;
			}
		}

		return similar;
	}

	/**
	 * Returns a string representation of this profile.
	 * @return a string representation of this profile
	 */
	public String toString() {
		return "Profile of " + owner + " - " + getNumberOfFriends() + " friends.";
	}

}
