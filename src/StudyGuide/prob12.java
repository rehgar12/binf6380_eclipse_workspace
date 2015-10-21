package StudyGuide;

public class prob12 
{
	static float[] a = {0,1,2,3,4};
	
	public static float[] reverseArray(float[] floatArray)
	{

		int halfLength = floatArray.length/2;
		
		
		for( int x=0; x<halfLength; x++ )
		{
			float temp = floatArray[x];
			floatArray[x] = floatArray[floatArray.length - x - 1];
			floatArray[floatArray.length - x - 1] = temp;
		}
		
		return floatArray;
	}
	
	public static void main(String[] args)
	{
		for( float i : a )
		{
			System.out.println(i);
		}
		reverseArray(a);
		for( float i : a )
		{
			System.out.println(i);
		}
		
		
		
	}
}
