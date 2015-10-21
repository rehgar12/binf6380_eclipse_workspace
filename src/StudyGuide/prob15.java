package StudyGuide;

import java.util.ArrayList;
import java.util.List;

public class prob15 
{
	public static List<Integer> getEvenNumbers( List<Integer> inList )
	{
		List<Integer> evenNumberList = new ArrayList<Integer>();
		
		for( int y : inList )
		{
			if( (y & 1) == 0 )
			{
				evenNumberList.add(y);
			}
		}
		
		return evenNumberList;
	}
	

	
	
	public static void main(String[] args)
	{
		List<Integer> listOfNumbers = new ArrayList<Integer>();
		for( int x=-4; x<9; x++ )
		{
			listOfNumbers.add(x);
		}
		for( int x : listOfNumbers )
		{
			System.out.println(x);
		}
		System.out.println("-------------");
		for( int x : getEvenNumbers(listOfNumbers) )
		{
			System.out.println(x);
		}
	}
}
