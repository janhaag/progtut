/**
 * The class {@code Message} represents a message.
 * @author  Karlsruhe Institute of Technology, IPD Pretschner/Snelting
 */
public class Message {

	/** the text of the message */
	private final String text;

	/** the time at which the message is sent */
	private final Timestamp time;

	/** the sender of the message */
	private final Person issuer;

	/**
	 * Constructs a message with the given values.
	 * @param text the content of the message, may be <code>null</code>
	 * @param time the time at which the message was sent
	 * @param owner the sender of the message
	 */
	public Message(String text, Timestamp time, Person owner) {
		if (text == null) {
			throw new IllegalArgumentException();
		} else if (time == null) {
			throw new IllegalArgumentException();
		} else if (owner == null) {
			throw new IllegalArgumentException();
		}

		this.text = text;
		this.time = time;
		this.issuer = owner;
	}

	/**
	 * Returns this message's sending time.
	 * @return this message's sending time
	 */
	public Timestamp getTime() {
		return time;
	}

	/**
	 * Returns this message's issuer.
	 * @return this message's issuer
	 */
	public Person getIssuer() {
		return issuer;
	}

	/**
	 * Returns this message's text.
	 * @return this message's text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Returns a string representation of this message.
	 * @return a string representation of this message
	 */
	public String toString() {
		return issuer + ": '" + text + "'";
	}

	/**
	 * Returns {@code true}, if this instance and the specified {@link Message} are equal, {@code false}
	 * otherwise.
	 *
	 * @param other the other message
	 * @return {@code true}, if this instance and the specified {@link Message} equal, {@code false} otherwise
	 */
	public boolean equals(Message other) {
		return other != null && text.equals(other.text) && time.equals(other.time) && issuer.equals(other.issuer);
	}

}
