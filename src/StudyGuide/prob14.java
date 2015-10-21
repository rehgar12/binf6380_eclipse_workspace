package StudyGuide;

import java.math.BigDecimal;

public class prob14 
{
	public static void main(String[] args)
	{
		System.out.println( 1.00 - 9 * 0.10 );
		
		System.out.println( 100 - 9 * 10 );
		
		BigDecimal bd = new BigDecimal("1.00");
		for( int x=0; x<9; x++ )
		{
			bd = bd.subtract(new BigDecimal("0.10"));
		}
		System.out.println(bd.toString());
	}
}
