package binf6380_20150902;

import java.util.Random;

public class lab2_exercise 
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
				int a;
				a = x.nextInt(4);
				if (a == 0)
					sequence = sequence + "A";
				else if (a == 1)
					sequence = sequence + "C";
				else if (a == 2)
					sequence = sequence + "G";
				else if (a == 3)
					sequence = sequence + "T";
			}
			if (sequence.equals("AAA"))		//was using ==, but that tests for same OBJECT, not value, found answer on stackoverflow (http://stackoverflow.com/questions/513832/how-do-i-compare-strings-in-java)
				count_of_AAA ++;
			System.out.println(sequence);
//			System.out.println(count_of_AAA);
		}
//		System.out.println(sequence);
		System.out.println(count_of_AAA);
	}
}
