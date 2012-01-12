/**
 * This class models a duplicate-free list of topics. Such lists are used to store the
 * different topics, which a person's profile is interested in.
 * @author  Karlsruhe Institute of Technology, IPD Pretschner/Snelting
 */
public class InterestList {

	/** The first element of the list */
	private InterestListElem first;

	/**
	 * Returns the number of topics stored in this list.
	 * @return the number of topics stored in this list
	 */
	public int getSize() {
		int size = 0;
		InterestListElem current = first;

		while (current != null) {
			size++;
			current = current.getNext();
		}

		return size;
	}

	/**
	 * Returns the topics contained in this list as an array.
	 * @return the elements of this list as an array
	 */
	public Topic[] getTopics() {
		final Topic[] topics = new Topic[getSize()];

		int index = 0;
		InterestListElem current = first;

		while (current != null) {
			topics[index] = current.getTopic();
			current = current.getNext();
			index++;
		}

		return topics;
	}

	/**
	 * Adds the given topic to this list, if it is not already contained. If
	 * it is already contained, its weight is increased and {@code false} is returned.
	 * If not, {@code true} is returned.
	 * @param topic the topic to add.
	 * @return true if the topic was not already contained in this list, false
	 * otherwise
	 */
	public boolean add(Topic topic) {
		if (topic == null) {
			throw new IllegalArgumentException();
		}

		if (!contains(topic)) {
			final InterestListElem newElem = new InterestListElem(topic);

			if (first != null) {
				newElem.setNext(first);
			}
			first = newElem;

			return true;
		} else {
			InterestListElem elem = find(topic);
			elem.increaseWeight();

			return false;
		}
	}

	/**
	 * Removes the given topic from this list, if it is already contained, and
	 * returns {@code true} in that case. If not, nothing happens and 
	 * {@code false} is returned. 
	 * @param topic the topic to remove
	 * @return true, if the removal had an effect, i.e. the topic to be removed
	 * was contained in this list, false otherwise
	 */
	public boolean remove(Topic topic) {
		if (topic == null) {
			throw new IllegalArgumentException();
		}

		final InterestListElem elem = find(topic);

		if (elem != null) {
			InterestListElem prev = findPrev(elem);

			if (prev != null) {
				prev.setNext(elem.getNext());
			}

			if (elem == first) {
				first = elem.getNext();
			}

			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method finds and returns the predecessor of the given {@link InterestListElem element}
	 * in this list. If the given element is the head of the list, null is returned.
	 * Otherwise, the element {@code e} is returned, such that {@code e.getNext()} is the given
	 * element.
	 * @param elem the element of which the predecessor is to be returned
	 * @return null, if the given element is the head of this list, otherwise
	 * the element e, such that e.getNext() is the given element.
	 */
	private InterestListElem findPrev(InterestListElem elem) {
		assert  elem != null;

		InterestListElem current = first;
		InterestListElem prev = null;

		while (current != null) {
			if (current == elem) {
				return prev;
			}

			prev = current;
			current = current.getNext();
		}

		return null;
	}

	/**
	 * Finds and returns the {@link InterestListElem element} of this list, which represents
	 * the given topic. If there is no such element, {@code null} is returned.
	 * @param topic topic of which the representing {@link InterestListElem element}
	 * is to be returned
	 * @return the {@link InterestListElem element} of this list, which represents
	 * the given topic, {@code null} if no such element exists in this list
	 */
	private InterestListElem find(Topic topic) {
		assert topic != null;

		InterestListElem current = first;

		while (current != null) {
			if (current.isTopic(topic)) {
				return current;
			}

			current = current.getNext();
		}

		return null;
	}

	/**
	 * Returns whether the given topic is contained in this list.
	 * @param topic the topic to check
	 * @return {@code true} if the topic is contained in this list, {@code false} otherwise.
	 */
	public boolean contains(Topic topic) {
		if (topic == null) {
			throw new IllegalArgumentException();
		}

		return find(topic) != null;
	}

	/**
	 * Returns a string representation of this list.
	 * @return a string representation of this list
	 */
	public String toString() {
		return "InterestList (" + getSize() + ") - first: " + first;
	}

	/**
	 * Returns the weight of the given topic in this interest list.
	 * @param topic given topic
	 * @return the weight of the given topic in this interest list
	 */
	public double getWeight(Topic topic) {
		if (topic == null) {
			throw new IllegalArgumentException();
		}

		final InterestListElem elem = find(topic);

		return (elem == null ? 0 : elem.getWeight());
	}

}
