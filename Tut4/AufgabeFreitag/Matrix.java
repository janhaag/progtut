



class Matrix
{


	static double[][] mul(double[][] m1, double[][] m2)
	{
		if(m1.length != m2[0].length)
		{
			System.out.println("Dulli");
			return null;
		}

		double[][] out = new double[m1.length][m2[0].length];

		for(int i = 0; i < m1.length; ++i)
		{
			for(int j = 0; j < m2[0].length; ++j)
			{
				for(int k = 0; k < m2.length; ++k)
				{
					out[i][j] += m1[i][k] * m2[k][j];
				}
			}
		} 

		return out;

	}


	public static void main(String... args)
	{
		double m1[][] = new double[][]	{ 	{ 1, 2, 5},
							{ 2, 3, 5} };

		double m2[][] = new double[][] {	{ 2, 3, 7},
							{ 8, 9, 9} };

		double res[][] = mul(m1, m2);

		if(res != null)
		{

			for(double[] i:res)
			{
				for(double j:i)
				{
					System.out.print( j + " " );
				}
				System.out.println("");
			}	
		}
	}

}
