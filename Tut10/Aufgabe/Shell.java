/**
 * This class implements a simple shell to test the functionalities of the
 * KITBook.
 *
 * @author Karlsruhe Institute of Technology, IPD Pretschner/Snelting
 */
public final class Shell {

	/** the prompt of this shell */
	private static final String PROMPT = "kitbook> ";

	/** command to list all the members of the KITBook */
	private static final String CMD_LIST = "list";

	/** command to reset the KITBook */
	private static final String CMD_RESET = "reset";

	/** command to show the friends of a given person */
	private static final String CMD_SHOW_FRIENDS = "list-friends";

	/** command to add the friendship between to given persons */
	private static final String CMD_ADD_FRIENDS = "add-friendship";

	/** command to remove the friendship between to given persons */
	private static final String CMD_REMOVE_FRIENDS = "remove-friendship";

	/** command to list the interests of a person */
	private static final String CMD_SHOW_INTERESTS = "list-interests";

	/** command to post a link on a profile */
	private static final String CMD_POST_LINK = "posts-link";

	/** command to list all links posted on a profile */
	private static final String CMD_ALL_LINKS = "all-links";

	/** command to terminate the shell */
	private static final String CMD_QUIT = "quit";

	/** command to add a person to the kitbook */
    private static final String CMD_ADD_PERSON = "add";

	/** command to show information about a person */
    private static final String CMD_INFO_PERSON = "info";

	/** command to find a matching advertisement for a person */
    private static final String CMD_AD_FOR_PERSON = "advertise";

	/** command to find the most similar person */
    private static final String CMD_MOST_SIMILAR = "most-similar";

	/** command to sort all persons by similarity to a given person */
    private static final String CMD_SORT_ALL = "sort-all";

    /** command to sort all friends of a person by similarity */
    private static final String CMD_SORT_FRIENDS = "sort-friends";

    /** describes the similarity mechanism based on the common interests */
    private static final String OPT_SORT_COUNT = "count";

    /** describes the cosine-based similarity mechanism */
    private static final String OPT_SORT_WEIGHT = "weight";

    /** describes the similarity mechanism based on the common friends */
    private static final String OPT_SORT_FRIENDS = "friends";

    /** describes a similarity mechanism which takes both common friends and common interests into account */
    private static final String OPT_SORT_COMBO = "combo";

	/** time of the KITBook */
	private static final Timestamp DEFAULT_TIME = new Timestamp(0, 0, 1, 1, 2011);

	/**
	 * Private constructor. This is a Utility class that should not be
	 * instantiated.
	 */
	private Shell() {
	}

	/**
	 * main method - realizes the shell
	 *
	 * @param args
	 *            command-line arguments - not used here!
	 */
	public static void main(String[] args) {
		boolean quit = false;
		KITBook kitbook = createDefaultKITBook();

		while (!quit) {
			final String[] tokens = Terminal.askString(PROMPT).trim().split("\\s+");
			final String cmd = tokens[0].toLowerCase();

			if (CMD_LIST.equals(cmd)) {
				printlnArray(kitbook.getPersons());
			} else if (CMD_ADD_PERSON.equals(cmd)) {
				if (tokens.length >= 3) {
					final String name = tokens[1];
					Person p = kitbook.findPerson(name);

					if (p == null) {
						final String date = tokens[2];
						final Timestamp dob = parseTimestamp(date);

						if (dob != null) {
							p = new Person(name, dob);
							kitbook.addPerson(p);
						}
					} else {
						error("A person with the name '" + name	+ "' already exists.");
					}
				} else {
					error("Provide name of person as argument.");
				}
			} else if (CMD_ALL_LINKS.equals(cmd)) {
				printlnArray(Link.PREDEFINED);
		    } else if (CMD_INFO_PERSON.equals(cmd) || CMD_SHOW_FRIENDS.equals(cmd) || CMD_ADD_FRIENDS.equals(cmd)
				    || CMD_REMOVE_FRIENDS.equals(cmd) || CMD_SHOW_INTERESTS.equals(cmd) || CMD_SORT_ALL.equals(cmd)
				    || CMD_POST_LINK.equals(cmd) || CMD_AD_FOR_PERSON.equals(cmd) || CMD_MOST_SIMILAR.equals(cmd)
				    || CMD_SORT_FRIENDS.equals(cmd)) {
				if (tokens.length >= 2) {
					final String name = tokens[1];
					final Person p = kitbook.findPerson(name);

					if (p != null) {
						doPersonCmd(kitbook, p, tokens);
					} else {
						error("A person with the name '" + name + "' does not exist.");
					}
				} else {
					error("Provide name of person as argument.");
				}
			} else if (CMD_RESET.equals(cmd)) {
				kitbook = createDefaultKITBook();
			} else if (CMD_QUIT.equals(cmd)) {
				quit = true;
			} else {
				error("Unknown command: '" + cmd + "'");
			}
		}
	}

	/**
	 * Performs the given command on the given kitbook and person.
	 *
	 * @param kitbook kitbook to operate on
	 * @param p person to operate on
	 * @param tokens command and parameters
	 */
	private static void doPersonCmd(KITBook kitbook, Person p, String[] tokens) {
		assert kitbook != null;
		assert p != null;
		assert tokens != null;
		assert tokens.length > 0;

		final String cmd = tokens[0];

		if (CMD_INFO_PERSON.equals(cmd)) {
			final PersonProfile prof = kitbook.getProfile(p);
			printInfo(prof);
		} else if (CMD_SHOW_FRIENDS.equals(cmd)) {
			final Person[] friends = kitbook.getFriends(p);
			printlnArray(friends);
		} else if (CMD_SHOW_INTERESTS.equals(cmd)) {
			final PersonProfile prof = kitbook.getProfile(p);
			printInterests(prof);
		} else if (CMD_MOST_SIMILAR.equals(cmd)) {
			if (tokens.length >= 3) {
				final String sortType = tokens[2];
				final ProfileSimilarity sim = getSimilarity(sortType);

				if (sim != null) {
					final Person similar = kitbook.findMostSimilarTo(p, sim);
					println(similar.toString());
				}
			} else {
				error("Provide name of person as argument and type of similarity algorithm.");
			}
		} else if (CMD_SORT_ALL.equals(cmd)) {
			if (tokens.length >= 3) {
				final String sortType = tokens[2];
				final ProfileSimilarity sim = getSimilarity(sortType);
				if (sim != null) {
					final Person[] similar = kitbook.sortAllBySimilarity(p, sim);
					printlnArray(similar);
				}
			} else {
				error("Provide name of person as argument and type of similarity algorithm.");
			}
		} else if (CMD_SORT_FRIENDS.equals(cmd)) {
			if (tokens.length >= 3) {
				final String sortType = tokens[2];
				final ProfileSimilarity sim = getSimilarity(sortType);
				if (sim != null) {
					final Person[] similar = kitbook.sortFriendsBySimilarity(p, sim);
					printlnArray(similar);
				}
			} else {
				error("Provide name of person as argument and type of similarity algorithm.");
			}
		} else if (CMD_AD_FOR_PERSON.equals(cmd)) {
			final SiteProfile tgt = kitbook.findAdvertisement(p, SiteProfile.getPredefinedSiteProfiles());
			println("Advertising for " + tgt.getSite());
		} else if (CMD_ADD_FRIENDS.equals(cmd)) {
			if (tokens.length >= 3) {
				final String name2 = tokens[2];
				final Person p2 = kitbook.findPerson(name2);

				if (p2 != null) {
					kitbook.addFriendship(p, p2);
				} else {
					error("No person with the name '" + name2 + "' found.");
				}
			} else {
				error("Provide names of the two persons as argument.");
			}
		} else if (CMD_REMOVE_FRIENDS.equals(cmd)) {
			if (tokens.length >= 3) {
				final String name2 = tokens[2];
				final Person p2 = kitbook.findPerson(name2);

				if (p2 != null) {
					kitbook.removeFriendship(p, p2);
				} else {
					error("No person with the name '" + name2 + "' found.");
				}
			} else {
				error("Provide names of the two persons as argument.");
			}
		} else if (CMD_POST_LINK.equals(cmd)) {
			if (tokens.length >= 3) {
				final String url = tokens[2];
				final Link link = Link.find(url);

				if (p != null && link != null) {
					final PersonProfile prof = kitbook.getProfile(p);
					prof.postLink(link);
				} else {
					error("No link to '" + tokens[2] + "' found.");
				}
			} else {
				error("Provide name of person and topic as argument.");
			}
		}
	}

	/**
	 * Prints the interests of the given person profile.
	 *
	 * @param p person profile to print interests of
	 */
	private static void printInterests(PersonProfile p) {
		for (Topic t : p.getInterests()) {
			println(t + "(" + p.getInterestWeight(t) + ")");
		}
	}

    /**
     * Prints information about the given person profile.
     * @param p person profile to print information about
     */
	private static void printInfo(PersonProfile p) {
		final Person owner = p.getOwner();
		println("Name  : " + owner.getName());
		println("date of birth: " + owner.getBirthday() + " (" + owner.getZodiac() + ")");

		if (p.getSchool() != null) {
			println("School: " + p.getSchool());
		}

		if (p.getStatus() != null) {
			final Message st = p.getStatus();
			println("Status: '" + st.getText() + "' (" + st.getTime() + ")");
		}

		if (p.getLastIncomingMessage() != null) {
			println("Inbox : " + p.getLastIncomingMessage());
		}
	}

    /**
     * Returns a ProfileSimilarity instance that corresponds to the given option.
     * @param sort description of the similarity mechanism
     * @return ProfileSimilarity instance that corresponds to the given option
     */
	private static ProfileSimilarity getSimilarity(String sort) {
		assert sort != null;

		ProfileSimilarity sim = null;

		if (OPT_SORT_COUNT.equals(sort)) {
			sim = CountSameInterestsSimilarity.INSTANCE;
		} else if (OPT_SORT_FRIENDS.equals(sort)) {
			sim = CountSameFriendsSimilarity.INSTANCE;
		} else if (OPT_SORT_WEIGHT.equals(sort)) {
			sim = WeightedInterestsSimilarity.INSTANCE;
		} else if (OPT_SORT_COMBO.equals(sort)) {
			sim = new CompositeProfileSimilarity(CountSameFriendsSimilarity.INSTANCE,
					CountSameInterestsSimilarity.INSTANCE);
		} else {
			error("Unknown similarity type: '" + sort + "'");
		}

		return sim;
	}

    /**
	 * Creates and returns a KITBook instance.
	 *
	 * @return a KITBook instance
	 */
	private static KITBook createDefaultKITBook() {
		KITBook kitbook = new KITBook(DEFAULT_TIME);

		School school = new School("Goethe-Gymnasium Karlsruhe", "Renckstrasse 2, 76133 Karlsruhe");

		Timestamp p1dob = new Timestamp(0, 0, 1, 5, 1992);
		Person p1 = new Person("Andrea", p1dob);

		PersonProfile p1prof = null;
		if (kitbook.addPerson(p1)) {
			p1prof = kitbook.getProfile(p1);
			p1prof.setSchool(school);
			p1prof.setStatus("Hello from person 1", kitbook.tickTime());
		}

		Timestamp p2dob = new Timestamp(0, 0, 10, 7, 1992);
		Person p2 = new Person("Peter", p2dob);

		PersonProfile p2prof = null;
		if (kitbook.addPerson(p2)) {
			p2prof = kitbook.getProfile(p2);
			p2prof.setSchool(school);
			p2prof.setStatus("Hello from person 2", kitbook.tickTime());
		}

		Timestamp p3dob = new Timestamp(0, 0, 28, 1, 1993);
		Person p3 = new Person("Daniel", p3dob);

		PersonProfile p3prof = null;
		if (kitbook.addPerson(p3)) {
			p3prof = kitbook.getProfile(p3);
			p3prof.setSchool(school);
			p3prof.setStatus("Hello from person 3", kitbook.tickTime());
		}

		kitbook.addFriendship(p1, p2);
		kitbook.addFriendship(p2, p3);

		kitbook.sendMessage(p1, p3, "Hallo, wie gehts?");

		p1prof.postLink(Link.CLASSICFM);
		p1prof.addInterestFor(Topic.SWIMMING);
		p1prof.postLink(Link.KICKER);
		p2prof.postLink(Link.GROOVESHARK);
		p3prof.postLink(Link.FORMULA1);
		p3prof.postLink(Link.ROCKHALL);

		return kitbook;
	}

	/**
	 * Prints an error message.
	 *
	 * @param err
	 *            error message to print
	 */
	private static void error(String err) {
		println("Error! " + err);
	}

	private static String arrayToString(Object[] array) {
		String ret = "[";

		for (int i = 0; i < array.length; i++) {
			ret += array[i];

			if (i < array.length - 1) {
				ret += ", ";
			}
		}

		ret += "]";

		return ret;
	}

	private static void println(String s) {
		System.out.println(s);
	}

	private static void printlnArray(Object[] array) {
		println(arrayToString(array));
	}

	/**
	 * Tries to convert the given string into a timestamp. If conversion fails,
	 * {@code null} is returned.
	 *
	 * @param date
	 *            string to convert
	 * @return the timestamp described by the given string - {@code null} if
	 *         conversion fails
	 */
	private static Timestamp parseTimestamp(String date) {
		final String[] parts = date.split("\\.");

		Timestamp time = null;

		if (parts.length == 3) {
			try {
				final int day = Integer.parseInt(parts[0]);
				final int month = Integer.parseInt(parts[1]);
				final int year = Integer.parseInt(parts[2]);

				time = new Timestamp(0, 0, day, month, year);
			} catch (NumberFormatException exc) {
				error(exc.getMessage());
			}
		} else {
			error("Please provide date of birth in the format dd.mm.yyyy (e.g. 03.06.1983).");
		}

		return time;
	}

}
