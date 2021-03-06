package binf6380_20150909;

import java.util.*;		//Daniel Zyska suggested the use of the Scanner util for user input


public class amino_acid_drill
{
	private static final Random RANDOM = new Random();
	
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
		int rightCount = 0;
		int wrongCount = 0;
		//combining short and full name arrays into a hashmap
		HashMap<String, String> aa_Hash = new HashMap<>();
//		System.out.println(SHORT_NAMES.length);
//		System.out.println(");
		for( int x=0; x<SHORT_NAMES.length; x++)
		{
			aa_Hash.put(SHORT_NAMES[x], FULL_NAMES[x]);
		}	
		//iterate through hashmap and print each key,value pair
		Iterator<String> keySetIterator = aa_Hash.keySet().iterator();
		while(keySetIterator.hasNext())
		{
	//		String key = keySetIterator.next();
//			System.out.println("key: " + key + " value " + aa_Hash.get(key));
		}

		//TIMING
		long startTime = System.currentTimeMillis();
		long waitTime = 30000;
		long endTime = startTime + waitTime;
		long elapsedTime;
		do
		{
			Scanner user_input = new Scanner(System.in);
			//display a random AA from the array
			int rand = RANDOM.nextInt(20);
//			System.out.println(rand);
			String user_guess = "";
			
			//for the random aa printed to screen, get user input
			System.out.print("What is the single letter code of: "+FULL_NAMES[rand]+"?	");
			user_guess = user_input.next();
			String user_guess_upper = user_guess.toUpperCase();
			
			
			if( FULL_NAMES[rand].equals(aa_Hash.get(user_guess_upper)))
			{
				rightCount++;
				elapsedTime = (System.currentTimeMillis()-startTime)/1000;
				System.out.println("			Correct! Score="+rightCount+" at "+elapsedTime+" seconds out of 30.");
			}
			else
			{
				System.out.println("You chose poorly.");
				System.exit(0);
			}
			user_input.close();
		} while( System.currentTimeMillis()<endTime );
		int total = rightCount+wrongCount;
		System.out.println("You answered "+rightCount+" correct out of"+total+".");
	}
}

