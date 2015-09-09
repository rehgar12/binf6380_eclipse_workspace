package binf6380_20150902;

import java.util.*;

public class hashmap_expectedvalues
{
	public static void main(String[] args)
	{
		

		
		
		
		//	Building Hashmap of all possible 3-mers of A,C,G,T (64 keys)		
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
		
		//	Calculating expected value for each 3-mer in the HashMap
		//assign probabilities of each nucleotide for eValue calculations
		double pA = 0.12;
		double pC = 0.38;
		double pG = 0.39;
		double pT = 0.11;
		double eValue = 0;
		
		//iterate through 64 keys, evaluate each letter of each 3-mer
		Iterator<String> keySetIterator = ThreeMer_expectedValues.keySet().iterator();
		while(keySetIterator.hasNext())
		{
			eValue = 0;
			String key = keySetIterator.next();
			System.out.println(key);
			//splitting each key into a String array, auto-assigns index 0 = ""
			String codonArray[] = key.split("");
			
			for( int k=0; k<codonArray.length; k++ ) 
			{
				System.out.println(codonArray[k]);
			}
			
			if( codonArray[1].equals("A") );
				eValue = pA;
				for( int i=2; i<4; i++)
				{
					if( codonArray[i].equals("A") );
						eValue *= pA;
					if( codonArray[i].equals("C") );
						eValue *= pC;
					if( codonArray[i].equals("G") );
						eValue *= pG;
					if( codonArray[i].equals("T") );
						eValue *= pT;
				}
			if( codonArray[1].equals("C") );
				eValue = pC;
				for( int i=2; i<4; i++)
				{
					if( codonArray[i].equals("A") );
						eValue *= pA;
					if( codonArray[i].equals("C") );
						eValue *= pC;
					if( codonArray[i].equals("G") );
						eValue *= pG;
					if( codonArray[i].equals("T") );
						eValue *= pT;
				}
			if( codonArray[1].equals("G") );
				eValue = pG;
				for( int i=2; i<4; i++)
				{
					if( codonArray[i].equals("A") );
						eValue *= pA;
					if( codonArray[i].equals("C") );
						eValue *= pC;
					if( codonArray[i].equals("G") );
						eValue *= pG;
					if( codonArray[i].equals("T") );
						eValue *= pT;
				}
			if( codonArray[1].equals("T") );
				eValue = pT;
				for( int i=2; i<4; i++)
				{
					if( codonArray[i].equals("A") );
						eValue *= pA;
					if( codonArray[i].equals("C") );
						eValue *= pC;
					if( codonArray[i].equals("G") );
						eValue *= pG;
					if( codonArray[i].equals("T") );
						eValue *= pT;
				}
			

			System.out.println(eValue);
		
			System.out.println("key: " + key + " value " + ThreeMer_expectedValues.get(key));
			//RESETTING eValue!!!!!!!!!!!!!!!
			//eValue = 0;
		}
	
		
		
		
		
	}
}
