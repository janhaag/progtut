public class TestRig {
    private static Function1<Integer, Integer> add42 =
        new Function1<Integer, Integer>() {
            public Integer call(Integer i) {
                return i + 42;
            }
        };
    private static Function1<Integer, Boolean> even =
        new Function1<Integer, Boolean>() {
            public Boolean call(Integer i) {
                return i % 2 == 0;
            }
        };

    public static void main(String... args) {
        FancyListImpl<Integer> l = new FancyListImpl<Integer>();
        l.add(1);
        l.add(2);
        l.add(3);
        System.out.println(l);
        System.out.println(l.map(add42));
        System.out.println(l.filter(even));
    }
}
