public class Aufgabe1 {
    public static void main(int n) {
        _(1, n, n);
    }

    private static void _(int n, int x, int y) {
        if (x <= 0) t(y); else b(n, x, y);
    }

    private static void s(int n) {
        if (n <= 0) return; p(32); s(n - 1);
    }

    private static void a(int n) {
        if (n <= 0) return; p(42); a(n - 1);
    }

    private static void t(int n) {
        if (n <= 0) return; s(n); p(124); p(10);
    }

    private static void b(int n, int x, int y) {
        s(x); a(n); p(10); _(n + 2, x - 1, y);
    }

    private static void p(int c) {
        System.out.print((char)c);
    }

    public static void main(String... args) {
        if (args.length == 1) {
            int i = 0;
            try {
                i = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Please pass in a number.");
            }
            main(i);
        } else {
            System.out.println("Please pass in a number.");
        }
    }
}
