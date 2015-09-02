package binf6380_20150902;

import java.util.Random;

public class lab2_exercise_EC1
{
	public static void main(String[] args)
	{
		int count_of_AAA = 0;
		String AAA = "AAA";
		for( int y=0; y<1000; y++ )
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
			if (sequence.equals("AAA"))
				count_of_AAA ++;
			System.out.println(sequence);
//			System.out.println(count_of_AAA);
		}
//		System.out.println(sequence);
		System.out.println(count_of_AAA);
	}
}
