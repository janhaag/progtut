/**
 * This class tests the functionalities introduced in this exercise
 * @author Karlsruhe Institute of Technology, IPD Pretschner/Snelting
 */
public final class Main {

	/**
	 * Private constructor. This is a Utility class that should not be instantiated.
	 */
	private Main() {
	}

	/**
	 * main method
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {
		Timestamp currentTime = new Timestamp(34, 12, 10, 10, 2011);

		KITBook kitbook = new KITBook(10, currentTime);

		School school = new School("Goethe-Gymnasium Karlsruhe", "Renckstra�e 2, 76133 Karlsruhe");

		Timestamp p1dob = new Timestamp(0, 0, 1, 5, 1992);
		Person p1 = new Person("Andrea", p1dob);

		PersonProfile p1prof = null;
		if (kitbook.addPerson(p1)) {
			p1prof = kitbook.getProfile(p1);
			p1prof.setStatus("Hello from person 1", currentTime);
			p1prof.setSchool(school);
		}

		Timestamp p2dob = new Timestamp(0, 0, 10, 7, 1992);
		Person p2 = new Person("Peter", p2dob);


		PersonProfile p2prof = null;
		if (kitbook.addPerson(p2)) {
			p2prof = kitbook.getProfile(p2);
			p2prof.setSchool(school);
			p2prof.setStatus("Hello from person 2", currentTime);
		}


		Timestamp p3dob = new Timestamp(0, 0, 28, 1, 1993);
		Person p3 = new Person("Daniel", p3dob);

		PersonProfile p3prof = null;
		if (kitbook.addPerson(p3)) {
			p3prof = kitbook.getProfile(p3);
			p3prof.setSchool(school);
			p3prof.setStatus("Hello from person 3", currentTime);
		}


		kitbook.addFriendship(p1, p2);
		kitbook.addFriendship(p2, p3);

		kitbook.areFriends(p1, p3);

		kitbook.containsPerson(p2);

		kitbook.sendMessage(p1, p3, "Hallo, wie gehts?");
		Message msg = p3prof.getLastIncomingMessage();
		Person sender = msg.getIssuer();

		sender.getZodiac();
		PersonProfile profSender = kitbook.getProfile(sender);
		profSender.getStatus();
		sender.getName();

		kitbook.tickTime();

		// neu in blatt 3
		Person[] friendsOfP2 = kitbook.getFriends(p2);

		PersonProfile pr3 = kitbook.getProfile(p3);
		pr3.getNumberOfFriends();
		kitbook.removeFriendship(p3, p2);
		pr3.getNumberOfFriends();


		p1prof.postLink(Link.CLASSICFM);
		p1prof.addInterestFor(Topic.SWIMMING);
		p1prof.postLink(Link.KICKER);
		p2prof.postLink(Link.GROOVESHARK);
		p3prof.postLink(Link.FORMULA1);
		p3prof.postLink(Link.ROCKHALL);

		if (p2prof.hasInterestFor(Topic.SWIMMING)) {
			p2prof.removeInterestFor(Topic.SWIMMING);
		}

		Person similar = kitbook.findMostSimilarTo(p1, CountSameInterestsSimilarity.INSTANCE);
		PersonProfile similarProf = kitbook.getProfile(similar);
		p1prof.countSimilarities(similarProf);
		similarProf.countSimilarities(p1prof);

		if (!kitbook.areFriends(p1, similar)) {
			kitbook.addFriendship(p1, similar);
		}
	}

}
