package StudyGuide;

public class prob2 
{
	static int numGCs(String stringToCount)
	{
		int numGC = 0;
		//String str = new String(stringToCount);
		char[] stcArray = stringToCount.toCharArray();
		for( int x=0; x<stcArray.length; x++ )
			if( stcArray[x] == 'G' || stcArray[x] == 'g' || stcArray[x] == 'C' || stcArray[x] == 'c')
			{
				numGC++;
			}
		
		return numGC;
	}
	
	public static void main(String[] args)
	{
		String stringToCount = "there are 5 g's and 2 c's in this statement, gggg, c";
		System.out.println(numGCs(stringToCount));
	}
}
