package binf6380_20150902;

import java.util.Random;

public class lab2_exercise 
{
	public static void main(String[] args)
	{
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
			System.out.println(sequence + " ");
			}
//		System.out.println(sequence);
	}
}
