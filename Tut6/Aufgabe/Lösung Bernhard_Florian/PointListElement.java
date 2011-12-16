
public class PointListElement {
    private Point point;
    private PointListElement next;

    public PointListElement(Point point, PointListElement next) {
        this.point = point;
        this.next = next;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public PointListElement getNext() {
        return next;
    }

    public void setNext(PointListElement next) {
        this.next = next;
    }
}
