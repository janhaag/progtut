/**
 * The class {@code Person} models a person in the KITBook. A person has a name and a birthday.
 * @author  Karlsruhe Institute of Technology, IPD Pretschner/Snelting
 */
public class Person {

	/** name of the person */
	private String name;

	/** birthday of the person */
	private Timestamp birthday;

	/**
	 * Constructs a new person with the given name and birthday.
	 * @param name name of the person
	 * @param birthday birthday of the person
	 */
	public Person(String name, Timestamp birthday) {
		if (name == null) {
			throw new IllegalArgumentException();
		} else if (birthday == null) {
			throw new IllegalArgumentException();
		}

		this.name = name;
		this.birthday = birthday;
	}

	/**
	 * Returns this person's birthday.
	 * @return this person's birthday
	 */
	public Timestamp getBirthday() {
		return birthday;
	}

	/**
	 * Returns this person's name.
	 * @return this person's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns this person's zodiac.
	 * @return this person's zodiac
	 */
	public String getZodiac() {
		return birthday.getZodiac();
	}

	/**
	 * Returns a string representation of this person.
	 * @return a string representation of this person
	 */
	public String toString() {
		return name + " (*" + birthday.getDay() + "." + birthday.getMonth() + "." + birthday.getYear() + ")";
	}

	/**
	 * Returns {@code true}, if this instance and the specified {@link Person} are equal, {@code false} otherwise.
	 *
	 * @param other the other person
	 * @return {@code true}, if this instance and the specified {@link Person} equal, {@code false} otherwise
	 */
	public boolean equals(Person other) {
		return other != null && name.equals(other.name) && birthday.equals(other.birthday);
	}

}

