package binf6380_20150909;

public class timer 
{
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		long waitTime = 5000;
		long endTime = startTime + waitTime;
		int eTime;
		
		do
		{
			float elapsedTime = (System.currentTimeMillis()-startTime)/1000f;
			
			for( int i=0; i<5; i++ )
			{
//				if( elapsedTime = i )
				{
				System.out.println("i");
				}
			}
		} while( System.currentTimeMillis()<endTime );
	}
}
