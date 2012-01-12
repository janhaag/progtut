/**
 * Represents an element of a {@list InterestList list of topics}. Contains
 * the represented topic and a reference to the next element of the list.
 * Additionally, a weight models how strong the interest in the contained topic
 * is.
 * @author Karlsruhe Institute of Technology, IPD Pretschner/Snelting
 */
final class InterestListElem {

	/** the topic represented by this element */
	private final Topic topic;

	/** reference of the next element of the list */
	private InterestListElem next;

	/** specifies how strong the interest in the contained topic is */
	private double weight;

	/** default weight - used, whenever a weight is omitted */
	private static final double DEFAULT_WEIGHT = 1.0;

	/**
	 * Constructs a new InterestListElem object from the given topic.
	 * @param topic the topic which the new InterestListElem represents
	 */
	InterestListElem(Topic topic) {
		this(topic, DEFAULT_WEIGHT);
	}

	/**
	 * Constructs a new InterestListElem object from the given topic and weight.
	 * @param topic the topic which the new InterestListElem represents
	 * @param weight the initial weight of this topic
	 */
	InterestListElem(Topic topic, double weight) {
		assert topic != null;
		assert weight >= 0;

		this.topic = topic;
		this.weight = weight;
	}

	/**
	 * Returns whether this element represents the given topic.
	 * @param other topic to be checked
	 * @return {@code true} if this elements represents the given topic,
	 * {@code false} otherwise.
	 */
	boolean isTopic(Topic other) {
		return topic.equals(other);
	}

	/**
	 * Returns the next element of the list.
	 * @return the next element of the list
	 */
	InterestListElem getNext() {
		return next;
	}

	/**
	 * Returns whether this element has a next element.
	 * @return {@code true} if there is a next element, {@code false} otherwise
	 */
	boolean hasNext() {
		return next != null;
	}

	/**
	 * Sets the next element.
	 * @param next new next element
	 */
	void setNext(InterestListElem next) {
		this.next = next;
	}

	/**
	 * Returns the represented topic.
	 * @return the represented topic
	 */
	Topic getTopic() {
		return topic;
	}

	/**
	 * Returns a string representation of this element.
	 * @return a string representation of this element
	 */
	public String toString() {
		return "<'" + topic.getKeyword() + "':" + weight + ">";
	}

	/**
	 * Increases the weight of the contained topic by the given amount.
	 * That number has to be non-negative, otherwise an IllegalArgumentExeption
	 * is thrown.
	 * @param amount amount by which the weight is to be increased
	 */
	public void increaseWeight(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException();
		}

		weight += amount;
	}

	/**
	 * Increases the weight of the contained topic by {@link #DEFAULT_WEIGHT}.
	 */
	public void increaseWeight() {
		increaseWeight(DEFAULT_WEIGHT);
	}

	/**
	 * Returns the weight of the contained topic.
	 * @return the weight of this topic
	 */
	public double getWeight() {
		assert weight >= 0;

		return weight;
	}

}
