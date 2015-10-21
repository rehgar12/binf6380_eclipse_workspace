package StudyGuide;

public class prob10 
{
	
	
	public static void main(String[] args) throws Exception
	{
		long startTime = System.currentTimeMillis();
		
		StringBuilder buff = new StringBuilder();
		
		for( int x=0; x < 10000; x++)
			buff.append(x);
			
		float numSeconds = (System.currentTimeMillis() - startTime) / 1000f;

		System.out.println( numSeconds + " seconds"  );
		//System.out.println(buff);
	
	}

}
