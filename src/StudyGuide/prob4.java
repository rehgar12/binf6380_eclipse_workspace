package StudyGuide;

public class prob4 
{
	static void skipEveryOther(String s)
	{
		char[] charArray = s.toCharArray();
		for( int x=0; x<charArray.length; x++ )
		{
			//zero all bits but leave the least significant bit
			//unchanged and check if the result is 0
			if( (x & 1) == 0 )
			{
			System.out.println(charArray[x]);
			}
		}
	}
	
	public static void main(String[] args)
	{
		skipEveryOther("this is just wacky, and it works!");
	}
}
