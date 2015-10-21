package StudyGuide;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class prob11 
{
	public static void main(String[] args) throws Exception
	{
		List<String> list = new ArrayList<String>();
		list.add("what0");
		list.add("what1");
		list.add("what2");
		
		for( String x : list)
		{
			System.out.println(x);
		}
		
		System.out.println("a break is what we need here");
		
		for( Iterator<String> i = list.iterator(); i.hasNext(); )
		{
			String x = i.next();
			System.out.println(x);
			
		}
	}
}
