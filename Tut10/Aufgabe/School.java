/**
 * This class models a school. A school is represented by its name and address.
 * @author  Karlsruhe Institute of Technology, IPD Pretschner/Snelting
 */
public class School {

	/** name of the school */
	private final String name;

	/** address of the school */
	private final String address;

	/**
	 * Constructs a new school with the given name and address.
	 * @param name name of the new school
	 * @param address address of the new school
	 */
	public School(String name, String address) {
		if (name == null) {
			throw new IllegalArgumentException();
		} else if (address == null) {
			throw new IllegalArgumentException();
		}

		this.name = name;
		this.address = address;
	}

	/**
	 * Returns this school's name.
	 * @return this school's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns this school's address.
	 * @return this school's address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Returns a string representation of this school.
	 * @return a string representation of this school
	 */
	public String toString() {
		return name;
	}

	/**
	 * Returns {@code true}, if this instance and the specified {@link School} are equal.
	 *
	 * @param other the other school
	 * @return {@code true}, if this instance and the specified {@link School} equal, {@code false} otherwise
	 */
	public boolean equals(School other) {
		return other != null && name.equals(other.name) && address.equals(other.address);
	}

}
