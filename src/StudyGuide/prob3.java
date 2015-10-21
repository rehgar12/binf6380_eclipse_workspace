package StudyGuide;

public class prob3
{
	static int bothPositive(int firstNum, int secondNum)
	{
		int x = firstNum;
		int y = secondNum;
		int result = 0;
		
		if( x > 0 && y > 0 )
		{
			result = 1;
		}		
		return result;
	}
	
	public static void main(String[] args)
	{
		System.out.println(bothPositive(4, -5));
	}
}
