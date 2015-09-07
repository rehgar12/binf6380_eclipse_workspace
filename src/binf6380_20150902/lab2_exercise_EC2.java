package binf6380_20150902;

import java.util.*;

public class lab2_exercise_EC2
{
	public static void main(String[] args)
	{
		double pA = 0.12;
		double pC = 0.38;
		double pG = 0.39;
		double pT = 0.11;


		
		
		
		
		
		
//	iterating for 10000 simulated experiments
		for( int y=0; y<10000; y++ )
		{
//	iterating for 10000 simulated sequences
			for( int yy=0; yy<10000; yy++ )
			{
				String sequence = "";
				Random x = new Random();
				for( int z=0; z<3; z++ )
				{
					float a = x.nextFloat();
					if (a <= 0.12)
						sequence = sequence + "A";
					else if (a > 0.12 && a <= 0.50)
						sequence = sequence + "C";
					else if (a > 0.50 && a <= 0.89)
						sequence = sequence + "G";
					else if (a > 0.89 && a <= 1.00)
						sequence = sequence + "T";
				}

				
				
				
				
				
//				System.out.println(sequence);
			}
			System.out.println(y);
		}
	}
}
