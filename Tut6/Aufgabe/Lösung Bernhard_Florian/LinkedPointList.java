public class LinkedPointList {

    private PointListElement firstElement = null;
    private int size = 0;

    public void add(Point p, int index) {
        if (index <= 0) {
            addFirst(p);
        } else if (index > size) {
            addLast(p);
        } else {
            PointListElement element = getListElement(index - 1);
            PointListElement newElement = new PointListElement(p, element.getNext());
            element.setNext(newElement);
            size++;
        }
    }

    public void add(Point p) {
        addLast(p);
    }

    public void addFirst(Point p) {
        firstElement = new PointListElement(p, firstElement);
        size++;
    }

    public void addLast(Point p) {
        if (isEmpty()) {
            addFirst(p);
        } else {
            getListElement(size - 1).setNext();
            size++;
        }

    }

    public boolean contains(Point p) {
        return indexOf(p) != -1;
    }

    public Point get(int index) {
        PointListElement result = getListElement(index);
        if (result != null) {
            return result.getPoint();
        } else {
            return null;
        }
    }

    private PointListElement getListElement(int index) {
        PointListElement element = firstElement;
        if (index < 0 || index >= size) {
            element = null;
        } else {
            for (int i = 0; i <= index; i++) {
                element = element.getNext();
            }
        }
        return element;
    }

    public Point getFirst() {
        if (!isEmpty()) {
            return firstElement.getPoint();
        } else {
            return null;
        }
    }

    public Point getLast() {
        return get(size - 1);
    }

    public int indexOf(Point p) {
        PointListElement current = firstElement;
        int currentIndex = 0;
        while (current != null && !current.getPoint().equals(p)) {
            current = current.getNext();
            currentIndex++;
        }
        if (current != null) {
            return currentIndex;
        } else {
            return -1;
        }
    }

    public boolean isEmpty() {
        return firstElement == null;
    }

    public void remove(int index) {
        if (index <= 0) {
            removeFirst();
        } else if (index >= size - 1) {
            removeLast();
        } else {
            PointListElement element = getListElement(index - 1);
            element.setNext(element.getNext().getNext());
            size--;
        }
    }

    public void remove(Point p) {
        int index = indexOf(p);
        if (index != -1) {
            remove(index);
        }
    }

    public void removeFirst() {
        if (!isEmpty()) {
            firstElement = firstElement.getNext();
            size--;
        }
    }

    public void removeLast() {
        if (!isEmpty()) {
            getListElement(size - 2).setNext(null);
            size--;
        }
    }

    public int size() {
        return size;
    }

    //Optional:
    public void sortByDistanceToOrigin() {
    }
}

