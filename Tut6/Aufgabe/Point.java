/**
 * This class represents a Point in a two-dimensional plain
 */
public class Point {
	private double x;
	private double y;

    /**
     * Create a Point with coordinates x and y.
     * @param x the x coordinate
     * @param y the y coordinate
     */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

    /**
     * Read the x coordinate of this Point.
     * @return the x coordinate
     */
	public double getX() {
		return this.x;
	}

    /**
     * Read the y coordinate of this Point.
     * @return the y coordinate
     */
	public double getY() {
		return this.y;
	}

    /**
     * Checks if two Points are the same.
     * @return true iff both points have the same coordinates
     */
	public boolean equals(Point p) {
		return 	this.x == p.x &&
			this.y == p.y;
	}

    /**
     * Compute the euclidean distance from the origin.
     * @return the euclidean distance from the origin
     */
	public double euclideanDistance() {
		return Math.sqrt(x * x + y * y);
	}

    /**
     * Compute the manhattan distance from the origin.
     * This is the sum of the coordinates' absolute values.
     * @return the manhattan distance from the origin
     */
    public double manhattanDistance() {
        return Math.abs(x) + Math.abs(y);
    }
}
