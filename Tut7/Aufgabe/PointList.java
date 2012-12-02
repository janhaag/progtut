/**
 * This class represents a doubly-linked list of Points
 */
public class PointList {
    /**
     * Insert a Point such that <pre>get(index) == p</pre>.
     * It is illegal for the index to be outside
     * the range <pre>0 &lt;= index &lt;= size()</pre>.
     * @param p the Point to insert
     * @param index where to insert the point
     */
    public void add(Point p, int index) {
    }

    /**
     * Equivalent to <pre>add(p, 0)</pre>.
     * @param p the point to insert
     */
    public void add(Point p) {
    }

    /**
     * Equivalent to <pre>add(p, 0)</pre>.
     * @param p the point to insert
     */
    public void addFirst(Point p) {
    }

    /**
     * Equivalent to <pre>add(p, size())</pre>.
     * @param p the point to insert
     */
    public void addLast(Point p) {
    }

    /**
     * Test whether or not a Point is contained in this list.
     * @param p the point to search
     * @return true iff the point was found
     */
    public boolean contains(Point p) {
    }

    /**
     * Retrieve the Point at the given index.
     * It is illegal for the index to be outside
     * the range <pre>0 &lt;= index &lt; size()</pre>.
     * @param index the index of the Point
     * @return the Point
     */
    public Point get(int index) {
    }

    /**
     * Equivalent to <pre>get(0)</pre>.
     * @return the Point
     */
    public Point getFirst() {
    }

    /**
     * Equivalent to <pre>get(size() - 1)</pre>.
     * @return the Point
     */
    public Point getLast() {
    }

    /**
     * Find a Point in the list.
     * @param p the Point to search
     * @return the index if the point is found else -1
     */
    public int indexOf(Point p) {
    }

    /**
     * Check if the list contains any elements.
     * @return true iff the list contains no elements
     */
    public boolean isEmpty() {
    }

    /**
     * Remove the element at index.
     * It is illegal for the index to be outside
     * the range <pre>0 &lt;= index &lt; size()</pre>.
     * @param the index to remove from
     */
    public void remove(int index) {
    }

    /**
     * Remove the given Point if it is contained in the List.
     * Otherwise, no action will be taken.
     * @param p the Point to remove
     */
    public void remove(Point p) {
    }

    /**
     * Equivalent to <pre>remove(0)</pre>.
     */
    public void removeFirst() {
    }

    /**
     * Equivalent to <pre>remove(size() - 1)</pre>.
     */
    public void removeLast() {
    }

    /**
     * The number of Points in this list.
     * @return a number &ge; 0 indicating the number of Points in this list
     */
    public int size() {
    }

    //Optional:

    /**
     * Sort this list.
     * The sorted list will have the Points in ascending order by their euclidean distance from the origin.
     */
    public void sortByEuclideanDistance() {
    }

    /**
     * Sort this list.
     * The sorted list will have the Points in ascending order by their manhattan distance from th origin.
     */
    public void sortByManhattenDistance() {
    }

    /**
     * Reverse the order of the Points in this list.
     * This is probably most useful in conjunction with the sorting methods.
     */
    public void reverse() {
    }
}

