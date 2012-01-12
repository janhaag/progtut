/**
 * This class represents the KITBook itself. It stores and administers
 * the profiles of the KITBook's members and their relationships.
 * @author  Karlsruhe Institute of Technology, IPD Pretschner/Snelting
 */
public class KITBook {

	/** the profiles stored in this KITBook */
	private final PersonProfile[] profiles;

	/** the current number of profiles stored in this KITBook */
	private int currentSize = 0;

	/** the current time of this KITBook */
	private Timestamp currentTime;

	/** returned if a profile is not contained in this KITBooks's internal profile array */
	private static final int NOT_CONTAINED = -1;

	/** default maximal size of this KITBook */
	public static final int DEFAULT_SIZE = 50;

	/**
	 * Constructs a new KITBook with the initial time. The size of this KITBook is set to the default of at most
	 * 50 persons.
	 * @param currentTime initial time of the new KITBook
	 */
	public KITBook(Timestamp currentTime) {
		this(DEFAULT_SIZE, currentTime);
	}

	/**
	 * Constructs a new KITBook with the given maximum size and the given initial time.
	 * @param maxSize maximum number of profiles stored in the new KITBook
	 * @param currentTime initial time of the new KITBook
	 */
	public KITBook(int maxSize, Timestamp currentTime) {
		if (maxSize < 0) {
			throw new IllegalArgumentException();
		} else if (currentTime == null) {
			throw new IllegalArgumentException();
		}

		this.profiles = new PersonProfile[maxSize];
		this.currentTime = currentTime;
	}

	/**
	 * Returns the profile of the given person, if the given person is a member
	 * of this KITBook. Otherwise, {@code null} is returned.
	 * @param p person of which the profile is to be returned
	 * @return the profile of the given person, if the given person is a member
	 * of this KITBook, {@code null} otherwise
	 */
	public PersonProfile getProfile(Person p) {
		if (p == null) {
			throw new IllegalArgumentException();
		}

		PersonProfile result = null;

		for (int i = 0; i < currentSize && result == null; i++) {
			if (p.equals(profiles[i].getOwner())) {
				result = profiles[i];
			}
		}

		return result;
	}

	/**
	 * Returns whether the given person is a member of this KITBook.
	 * @param p person to be checked
	 * @return {@code true} if the given person is a member of this KITBook, {@code false} otherwise
	 */
	public boolean containsPerson(Person p) {
		if (p == null) {
			throw new IllegalArgumentException();
		}

		return getProfile(p) != null;
	}

	/**
	 * Checks whether the two given persons are friends. If
	 * one of the given persons is not a member of the KITBook, then {@code false}
	 * is returned.
	 * @param p1 first person
	 * @param p2 second person
	 * @return {@code true} if p1 and p2 are friends, {@code false} otherwise
	 */
	public boolean areFriends(Person p1, Person p2) {
		if (p1 == null) {
			throw new IllegalArgumentException();
		} else if (p2 == null) {
			throw new IllegalArgumentException();
		}

		if (containsPerson(p1) && containsPerson(p2) && !p1.equals(p2)) {
			final PersonProfile prof1 = getProfile(p1);
			final PersonProfile prof2 = getProfile(p2);

			return prof1.isBefriendedWith(prof2) && prof2.isBefriendedWith(prof1);
		}

		return false;
	}

	/**
	 * Adds the friendship between the two given persons, if they have not been friends before.
	 * Otherwise, nothing happens. Additionally returns whether the friendship was successfully added. 
	 * @param p1 first person
	 * @param p2 second person
	 * @return {@code true}, if p1 and p2 have not been friends before, {@code false} otherwise.
	 */
	public boolean addFriendship(Person p1, Person p2) {
		if (p1 == null) {
			throw new IllegalArgumentException();
		} else if (p2 == null) {
			throw new IllegalArgumentException();
		}

		boolean newFriends = false;

		if (containsPerson(p1) && containsPerson(p2) && !p1.equals(p2)) {
			final PersonProfile prof1 = getProfile(p1);
			final PersonProfile prof2 = getProfile(p2);

			if (!prof1.isBefriendedWith(prof2) && !prof2.isBefriendedWith(prof1)) {
				prof1.addFriendship(prof2);
				prof2.addFriendship(prof1);
				newFriends = true;
			}
		}

		return newFriends;
	}

	/**
	 * Removes the friendship between the two given persons, if they have been friends before.
	 * Otherwise, nothing happens. Additionally returns whether the friendship was successfully removed.
	 * @param p1 first person
	 * @param p2 second person
	 * @return {@code true}, if p1 and p2 have been friends before, {@code false} otherwise.
	 */
	public boolean removeFriendship(Person p1, Person p2) {
		if (p1 == null) {
			throw new IllegalArgumentException();
		} else if (p2 == null) {
			throw new IllegalArgumentException();
		}

		boolean haveBeenFriends = false;

		if (containsPerson(p1) && containsPerson(p2) && !p1.equals(p2)) {
			final PersonProfile prof1 = getProfile(p1);
			final PersonProfile prof2 = getProfile(p2);

			if (prof1.isBefriendedWith(prof2) && prof2.isBefriendedWith(prof1)) {
				prof1.removeFriendship(prof2);
				prof2.removeFriendship(prof1);
				haveBeenFriends = true;
			}
		}

		return haveBeenFriends;
	}

	/**
	 * Lets the inner clock of this KITBook tick one minute forward and returns the former timestamp.
	 * @return the timestamp before the call of this method.
	 */
	public Timestamp tickTime() {
		final Timestamp time = currentTime;
		currentTime = currentTime.tick();

		return time;
	}

	/**
	 * Sends a message with a certain content from the given sender to the given
	 * recipient.
	 * @param from sender of message to be sent
	 * @param to recipient of message to be sent
	 * @param message text of message to be sent
	 */
	public void sendMessage(Person from, Person to, String message) {
		if (from == null || !containsPerson(from)) {
			throw new IllegalArgumentException("Cannot send message from " + from);
		} else if (to == null || !containsPerson(to)) {
			throw new IllegalArgumentException("Cannot send message to " + to);
		} else if (message == null) {
			throw new IllegalArgumentException();
		}

		final Message msg = new Message(message, tickTime(), from);
		final PersonProfile pTo = getProfile(to);
		pTo.receiveMessage(msg);
	}

	/**
	 * Adds the given person to the KITBook if he or she is no member. Otherwise, nothing happens.
	 * Additionally returns whether the person was actually added.
	 * @param p person to add
	 * @return {@code true}, if the given person is no member, {@code false} otherwise
	 */
	public boolean addPerson(Person p) {
		if (p == null) {
			throw new IllegalArgumentException();
		} else if (currentSize >= profiles.length) {
			throw new IllegalStateException("KITBook has reached maximal number of persons: " + profiles.length);
		}

		boolean isNewMember = false;

		if (!containsPerson(p) && currentSize < profiles.length) {
			final PersonProfile prof = new PersonProfile(p);
			profiles[currentSize] = prof;
			currentSize++;
			isNewMember = true;
		}

		return isNewMember;
	}

	/**
	 * Removes the given person from the KITBook if he or she is a member. Otherwise,
	 * nothing happens. Additionally returns whether the person was actually removed.
	 * @param p person to remove
	 * @return {@code true}, if the given person has been a member, {@code false} otherwise
	 */
	public boolean removePerson(Person p) {
		if (p == null) {
			throw new IllegalArgumentException();
		}

		final PersonProfile prof = getProfile(p);

		if (prof != null) {
			remove(prof);
		}

		return prof != null;
	}

	/**
	 * Removes the given profile from the profile array and updates the current
	 * size. Assumes that the given profile is actually present in the profiles array.
	 * @param p profile to remove
	 */
	private void remove(PersonProfile p) {
		assert p != null;

		final int index = getProfileNumber(p);
		assert index !=  NOT_CONTAINED;

		for (int i = index; i < currentSize - 1; i++) {
			profiles[i] = profiles[i + 1];
		}

		profiles[currentSize - 1] = null;
		currentSize--;
	}

	/**
	 * Returns the current number of members in this KITBook.
	 * @return the current number of members in this KITBook
	 */
	public int getSize() {
		return currentSize;
	}

	/**
	 * Returns all members of the KITBook.
	 * @return all members of the KITBook
	 */
	public Person[] getPersons() {
		final Person[] ret = createPersonArray(profiles, currentSize);

		return ret;
	}

	/**
	 * Returns the index of the given profile in the profile array. If the
	 * given profile is not contained, {@link #NOT_CONTAINED} is returned.
	 * @param p profile to search in the profile array
	 * @return the index of the given profile in the profile array, or {@link
	 * #NOT_CONTAINED} if the profile is not contained
	 */
	private int getProfileNumber(PersonProfile p) {
		assert p != null;

		int result = NOT_CONTAINED;

		for (int index = 0; index < currentSize && result == NOT_CONTAINED; index++) {
			final PersonProfile current = profiles[index];

			if (current.equals(p)) {
				result = index;
			}
		}

		return result;
	}

	/**
	 * Returns a person in the KITBook which is, according to the given similarity
	 * mechanism, most similar to the given person. If the given person is no
	 * member in the KITBook, {@code null} is returned.<br>
	 * If an actual person is returned, it is guaranteed to be different from the
	 * given person. Consequently, if the given person is the only person in the KITBook, {@code null}
	 * is returned. 
	 * @param p person to which the most similar person is to be found
	 * @param sim similarity mechanism to be used
	 * @return a person in the KITBook which is, according to the given similarity
	 * mechanism, most similar to the given person, or {@code null} if the given person is no or the only member of the KITBook
	 */
	public Person findMostSimilarTo(Person p, ProfileSimilarity sim) {
		if (p == null) {
			throw new IllegalArgumentException();
		} else if (sim == null) {
			throw new IllegalArgumentException();
		}

		Person mostSimilar = null;

		if (containsPerson(p)) {
			final PersonProfile prof = getProfile(p);
			assert prof != null;
			final PersonProfile[] allExceptP = getAllExceptThisPerson(p);

			if (allExceptP.length > 0) {
				final int indexSimilar = findMostSimilarProfile(prof, allExceptP, sim);
				final PersonProfile pSimilar = allExceptP[indexSimilar];

				mostSimilar = pSimilar.getOwner();
			}
		}

		return mostSimilar;
	}

	/**
	 * Returns the index of the profile of the given profile array that is, according to
	 * the given similarity mechanism, most similar to the given profile.
	 * @param p profile for which a most similar profile is to be computed
	 * @param profiles profiles from which a most similar profile is to be computed
	 * @param sim similarity mechanism to be used
	 * @return index of the profile that is most similar to the given profile.
	 * profile
	 */
	private static int findMostSimilarProfile(AbstractProfile p, AbstractProfile[] profiles, ProfileSimilarity sim) {
		assert p != null;
		assert profiles != null;
		assert profiles.length > 0;
		assert sim != null;

		int maxIndex = NOT_CONTAINED;
		double maxSimilarities = -1;

		for (int i = 0; i < profiles.length; i++) {
			double similarities = sim.compute(p, profiles[i]);

			if (similarities > maxSimilarities) {
				maxSimilarities = similarities;
				maxIndex = i;
			}
		}

		assert maxIndex != NOT_CONTAINED;

		return maxIndex;
	}

	/**
	 * Finds a site profile from the given array, which matches the given person's profile
	 * the most according to the similarity of interests.
	 * @param p person to find a matching site profile for
	 * @param sites possible site profiles
	 * @return a site profile from the given array, which matches the given person's profile
	 * the most according to the similarity of interests
	 */
	public SiteProfile findAdvertisement(Person p, SiteProfile[] sites) {
		if (p == null) {
			throw new IllegalArgumentException();
		} else if (sites == null) {
			throw new IllegalArgumentException();
		}

		SiteProfile mostSimilar = null;

		if (containsPerson(p) && sites.length > 0) {
			final PersonProfile prof = getProfile(p);
			final int indexSimilar = findMostSimilarProfile(prof, sites, WeightedInterestsSimilarity.INSTANCE);
			mostSimilar = sites[indexSimilar];
		}

		return mostSimilar;
	}

	/**
	 * Returns the friends of the given person in the KITBook. If
	 * the given person has no friends or is no member of the KITBook, {@code null} is returned
	 * @param p given person
	 * @return the friends of the given person in the KITBook, {@code null}
	 * if person is no member or has no friends
	 */
	public Person[] getFriends(Person p) {
		if (p == null) {
			throw new IllegalArgumentException();
		}

		Person[] result = null;

		if (containsPerson(p)) {
			final PersonProfile prof = getProfile(p);
			final PersonProfile[] friends = prof.getFriends();
			result = createPersonArray(friends, friends.length);
		}

		return result;
	}

	/**
	 * Finds and returns a member of the KITBook with the given name, if existent.
	 * If no member with the given name exists, {@code null} is returned.
	 * @param name name to search in KITBook
	 * @return a member of the KITBook with the given name. If no member
	 * with the given name exists, {@code null} is returned.
	 */
	public Person findPerson(String name) {
		if (name == null) {
			throw new IllegalArgumentException();
		}

		for (Person p : getPersons()) {
			if (p.getName().equals(name)) {
				return p;
			}
		}

		return null;
	}

	/**
	 * Given a person p, returns all the other persons in this KITBook sorted by
	 * similarity with respect to the given similarity mechanism.
	 * @param p given person - all the other persons are sorted by similarity to this person
	 * @param similarity similarity mechanism to be used
	 * @return all the persons in this KITBook (except for the given one), sorted by
	 * similarity to the given person, with respect to the given similarity mechanism
	 */
	public Person[] sortAllBySimilarity(Person p, ProfileSimilarity similarity) {
		if (p == null) {
			throw new IllegalArgumentException();
		} else if (similarity == null) {
			throw new IllegalArgumentException();
		}

		Person[] result = null;

		if (containsPerson(p)) {
			final PersonProfile prof = getProfile(p);
			final PersonProfile[] allExceptP = getAllExceptThisPerson(p);
			sortBySimilarityTo(allExceptP, prof, similarity);
			result = createPersonArray(allExceptP, allExceptP.length);
		}

		return result;
	}
	
	
	/**
	 * Given a person p, returns all the profiles registered in the KITBook except for
	 * p's profile.
	 * @param p person whose profile is to be excluded
	 * @return all the profiles registered in the KITBook except for
	 * p's profile.
	 */
	private PersonProfile[] getAllExceptThisPerson(Person p) {
		assert p != null;
		assert containsPerson(p);

		final PersonProfile[] allExceptP = new PersonProfile[getSize() - 1];
		int index = 0;

		for (int i = 0; i < currentSize; i++) {
			final PersonProfile cur = profiles[i];

			// do not add p to the list of persons to sort
			if (!p.equals(cur.getOwner())) {
				allExceptP[index] = cur;
				index++;
			}
		}

		return allExceptP;
	}

	/**
	 * Given a person p, returns all the friends of p sorted by
	 * similarity with respect to the given similarity mechanism.
	 * @param p given person - all the other persons are sorted by similarity to this person
	 * @param similarity similarity mechanism to be used
	 * @return all the persons in this KITBook (except for the given one), sorted by
	 * similarity to the given person, with respect to the given similarity mechanism
	 */
	public Person[] sortFriendsBySimilarity(Person p, ProfileSimilarity similarity) {
		if (p == null) {
			throw new IllegalArgumentException();
		} else if (similarity == null) {
			throw new IllegalArgumentException();
		}

		Person[] result = null;

		if (containsPerson(p)) {
			final PersonProfile prof = getProfile(p);
			final PersonProfile[] friends = prof.getFriends();
			sortBySimilarityTo(friends, prof, similarity);
			result = createPersonArray(friends, friends.length);
		}

		return result;
	}

	/**
	 * Given an abstract profile p and an array of persons, sorts the person array by similarity of
	 * their respective profiles to p. For similarity computation, the given similarity mechanism is
	 * used.
	 * @param p given profile
	 * @param profiles array which is to be sorted by similarity to the given profile
	 * @param similarity similarity mechanism to be used
	 */
	private void sortBySimilarityTo(PersonProfile[] profiles, PersonProfile p, ProfileSimilarity similarity) {
		// selection sort
		for (int splitAt = 0; splitAt < profiles.length; splitAt++) {
			double maxSim = 0;
			int maxIndex = splitAt;

			// search friends with maximal similarity
			for (int index = splitAt; index < profiles.length; index++) {
				final PersonProfile otherProf = profiles[index];
				double curSim = similarity.compute(p, otherProf);

				if (curSim > maxSim) {
					maxSim = curSim;
					maxIndex = index;
				}
			}

			final PersonProfile maxPerson = profiles[maxIndex];

			// free space for maxPerson
			for (int i = maxIndex; i > splitAt; i--) {
				profiles[i] = profiles[i - 1];
			}

			// swap
			profiles[splitAt] = maxPerson;
		}
	}
	
	/**
	 * Returns a person array, which contains the owners of the first {@code numberOfPersons} 
	 * profiles from the given profile array. This method is a helper method for {@link #getFriends(Person)}
	 * and {@link #getPersons()}.
	 * @param profiles profile array to extract the person array from
	 * @param numberOfPersons size of person array to return
	 * @return an array of persons which contains the owners of first {@code numberOfPersons}
	 * profiles from the given profile array
	 */
	private static Person[] createPersonArray(PersonProfile[] profiles, int numberOfPersons) {
		assert profiles != null;
		assert numberOfPersons >= 0;
		assert profiles.length >= numberOfPersons;

		final Person[] persons = new Person[numberOfPersons];

		for (int i = 0; i < numberOfPersons; i++) {
			assert profiles[i] != null;
			persons[i] = profiles[i].getOwner();
		}

		return persons;
	}

}
