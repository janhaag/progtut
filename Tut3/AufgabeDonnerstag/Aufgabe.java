    class Aufgabe {
        long fak_while(short n) {
            long res = 1;
            while (n > 0) {
                res *= n;
                n--;
            }
            return res;
        }

        long fak_doWhile(short n) {
            long res = 1;
            if (n < 0) {
                System.out.println("Error ...");
                return -1;
            }
            do {
                res *= n;
                n--;
            } while (n > 0);
            return res;
        }

        long fak_for(short n) {
            long res = 1;
            for (; n > 1; n--) {
                res *= n;
            }
            return res;
        }
    }
