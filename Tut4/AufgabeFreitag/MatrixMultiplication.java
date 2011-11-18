
class MatrixMultiplication {


    public static double[][] multiply(double[][] a, double[][] b) {

        int m = a.length;
        int p = b.length;
        int n = b[0].length;

        double[][] result = new double[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                double value = 0;
                if (a[i].length != p) {
                    return null;
                }


                for (int k = 0; k < p; k++) {
                    value += a[i][k] * b[k][j];

                    if (b[k].length != n) {
                        return null;
                    }
                }
                result[i][j] = value;

            }
        }

        
        return result;

    }

    public static void main(String[] args) {
       double[][] a = {
           {2.0, 3.0 },
           {2.5, 4.0 },
           {1.5, 0.5 }};

       double[][] b = {
           {4.0, 4.2, 2.3},
           {1.4, 4.1, 0}};

       double[][] result = multiply(a, b);

       if (result == null) {
           System.out.println("Fehler in den Matrixvorgaben.");
           System.exit(1);
       }


       for (int i = 0; i < result.length; i++) {
           System.out.print("{");
           for (int j = 0; j < result[0].length; j++) {
               System.out.print(result[i][j] + "\t");
           }
           System.out.print("}\n");
       }

    }

}
