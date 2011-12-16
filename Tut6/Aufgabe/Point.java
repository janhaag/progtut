public class Point {
	private double x;
	private double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public boolean equals(Point p) {
		return 	this.x == p.x &&
			this.y == p.y; 
	}


	public double distanceToOrigin() {
		return Math.sqrt(x * x + y * y);
	}
}
