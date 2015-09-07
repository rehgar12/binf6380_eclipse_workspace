package binf6380_20150902;

import java.util.*;

public class hashmap_expectedvalues
{
	public static void main(String[] args)
	{
		

		
		
		
		//	Hashmap of all possible 3-mers of A,C,G,T (64 keys)		
		HashMap<String, Integer> ThreeMer_expectedValues = new HashMap<>();
		for( int b=0; b<4; b++ )
		{
			String codon = "";
			if ( b==0 )
				codon = "A";
			if ( b==1 )
				codon = "C";
			if ( b==2 )
				codon = "G";
			if ( b==3 )
				codon = "T";
			
			for( int c=0; c<4; c++ )
			{
				if ( c==0 )
					codon = codon + "A";
				if ( c==1 )
					codon = codon + "C";
				if ( c==2 )
					codon = codon + "G";
				if ( c==3 )
					codon = codon + "T";
				for( int d=0; d<4; d++ )
				{
					if ( d==0 )
						codon = codon + "A";
					if ( d==1 )
						codon = codon + "C";
					if ( d==2 )
						codon = codon + "G";
					if ( d==3 )	
						codon = codon + "T";
//					System.out.println(codon);
					//assign 3-mer as a key with value 0
					ThreeMer_expectedValues.put(codon, 0);
					//remove last (3rd) letter of 3-mer
					codon = codon.substring(0, codon.length()-1);
				}
				//remove last (2nd) letter of 2-mer
				codon = codon.substring(0, codon.length()-1);
			}
		}
//	
		
		
		//assign probabilities of each nucleotide for eValue calculations
		double pA = 0.12;
		double pC = 0.38;
		double pG = 0.39;
		double pT = 0.11;
		
		//iterate through 64 keys, evaluate each letter of each 3-mer
		Iterator<String> keySetIterator = ThreeMer_expectedValues.keySet().iterator();
		while(keySetIterator.hasNext())
		{
			String key = keySetIterator.next();
			
			char[] codonArray = key.toCharArray();
			double expectedValue = 0.0;
			for( char codonchar: codonArray )
			{
				if( Character.toString(codonchar).matches("A") )
			}
			
			System.out.println("key: " + key + " value " + ThreeMer_expectedValues.get(key));
		}
	
		
		
		
		
	}
}
