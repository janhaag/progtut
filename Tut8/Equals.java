public class Point {
    private int x;
    private int y;

    @override
    public boolean equals(Object o) {
        if (o instanceof Point) {
            return x == o.x && y == o.y;
        }
        return false;
    }
}

public class Point3d extends Point {
    private int z;

    @Override
    public boolean equals(Object o) {
        if (o instanceof Point3d) {
            return z == o.z && super.equals(o);
        }
        return super.equals(o);
    }
}
