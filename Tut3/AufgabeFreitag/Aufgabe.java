    class Aufgabe {
        long fak_while(short n) {
		long res = n >= 0 ? 1 : -1;
		while (n > 0) {
			res *= n;
			n--;
		}
		return res;
        }

        long fak_doWhile(short n) {
		short i = 1;
		long res = 1;
		do {
			res *= i;
			i++;
		} while (i >= n);
        }

        long fak_for(short n) {
		long res = 1;
		for (; n > 0; n--) {
			res *= n;
		}
		return res;
        }

	
    }
