package binf6380_20150909;

import java.util.*;		//Daniel Zyska suggested the use of the Scanner util for user input


public class aa_drill_withTime
{
	private static final Random RANDOM = new Random();
	private static final float[] FREQS =
	{
	0.05f, 0.05f, 0.05f, 0.05f, 0.05f, 
	0.05f, 0.05f, 0.05f, 0.05f, 0.05f, 
	0.05f, 0.05f, 0.05f, 0.05f, 0.05f, 
	0.05f, 0.05f, 0.05f, 0.05f, 0.05f
	};
	
	public static final String[] SHORT_NAMES = 
	{
	"A","R", "N", "D", "C", "Q", "E",
	"G",  "H", "I", "L", "K", "M", "F",
	"P", "S", "T", "W", "Y", "V" 
	};

	public static final String[] FULL_NAMES = 
	{
	"alanine","arginine", "asparagine",
	"aspartic acid", "cysteine",
	"glutamine",  "glutamic acid",
	"glycine" ,"histidine","isoleucine",
	"leucine",  "lysine", "methionine",
	"phenylalanine", "proline",
	"serine","threonine","tryptophan",
	"tyrosine", "valine"
	};
	
	
	public static void main(String[] args)
	{
		//combining short and full name arrays into a hashmap
		HashMap<String, String> aa_Hash = new HashMap<>();
//		System.out.println(SHORT_NAMES.length);
//		System.out.println(");
		for( int x=0; x<SHORT_NAMES.length; x++)
		{
			aa_Hash.put(SHORT_NAMES[x], FULL_NAMES[x]);
		}	
		//CHECK: iterate through hashmap and print each key,value pair
		Iterator<String> keySetIterator = aa_Hash.keySet().iterator();
		while(keySetIterator.hasNext())
		{
			String key = keySetIterator.next();
//			System.out.println("key: " + key + " value " + aa_Hash.get(key));
		}
		
		
		//TIMING
		long startTime = System.currentTimeMillis();
		long waitTime = 30000;
		long endTime = startTime+waitTime;
		while( System.currentTimeMillis()<endTime );
		{	
			Scanner user_input = new Scanner(System.in);
			//display a random AA from the array
			int count = 0;
			//y is number of times to go through entire list of aa's
			for( int y=0; y<4; y++ )
			{
				float f = RANDOM.nextFloat();
				float sum = 0.0f;		
				for( int x=0; x<SHORT_NAMES.length; x++ )
				{
					String user_guess = "";
					sum+=FREQS[x];
					
					
					//for the random aa printed to screen, get user input
					if( f<=sum )
					{
						System.out.print("What is the single letter code of: "+FULL_NAMES[x]+"?	");
						user_guess = user_input.next();
						String user_guess_upper = user_guess.toUpperCase();
						if( FULL_NAMES[x].equals(aa_Hash.get(user_guess_upper)))
						{
							System.out.println("			Correct!");
							count++;
						}
						else
						{
							System.out.println("	Nope! The single letter code for "+FULL_NAMES[x]+" is "+SHORT_NAMES[x]);
						}
					}
				}
			}
			System.out.println("You answered "+count+" correct!");
		}
	}
}
