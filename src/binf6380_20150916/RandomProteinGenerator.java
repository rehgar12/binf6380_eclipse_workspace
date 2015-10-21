package binf6380_20150916;

import java.util.*;


public class RandomProteinGenerator
{
	public static final char[] AA_LETTERS =
	{
		'A', 'C', 'D', 'E',
		'F', 'G', 'H', 'I', 'K',
		'L', 'M', 'N', 'P', 'Q',
		'R', 'S', 'T', 'V', 'W',
		'Y'
	};
	private float[] AA_FREQS = new float[AA_LETTERS.length];
	private final Random RANDOM = new Random();

	//constructor
	public RandomProteinGenerator(boolean useUniformFrequencies)
	{
		if ( useUniformFrequencies == true )	//the random proteins have an equal probability of all 20 residues.
		{
			float uniformFreqs = (float) 1/AA_LETTERS.length;
			for( int x=0; x<AA_LETTERS.length; x++)
			{
				AA_FREQS[x] = uniformFreqs;
			}
		}
			
		if ( useUniformFrequencies == false )	//the 20 residues have a distribution of
		{
			float[] realisticFreqs =
				{
					0.072658f, 0.024692f, 0.050007f, 0.061087f,
					0.041774f, 0.071589f, 0.023392f, 0.052691f, 0.063923f,
					0.089093f, 0.023150f, 0.042931f, 0.052228f, 0.039871f,
					0.052012f, 0.073087f, 0.055606f, 0.063321f, 0.012720f,
					0.032955f
				};
			for( int x=0; x<AA_LETTERS.length; x++)
			{
				AA_FREQS[x] = realisticFreqs[x];
			}
		}
	}
	
	//Returns a randomly generated protein of length length.
	public String getRandomProtein(int length)
	{
		String randomProtein= "";	
			
		for( int y=0; y<length; y++ )
		{
			float f = RANDOM.nextFloat();
			float sum = 0.0f;
			for( int x=0; x<AA_LETTERS.length; x++ )
			{
				sum += AA_FREQS[x];
				//System.out.println(f + " " + sum);
				if( f <= sum )
				{
					randomProtein += Character.toString(AA_LETTERS[x]);
					break;
				}
			}
		}		
		//System.out.println(randomProtein);
		return randomProtein;
	}
	
	/*
	 * Returns the probability of seeing the given sequence
	 * given the underlying residue frequencies represented by
	 * this class.  For example, if useUniformFrequencies==false in 
	 * constructor, the probability of "AC" would be 0.072658 *  0.024692
	 */
	public double getExpectedFrequency(String protSeq)
	{
		double expectedFreq = 1;
		for( int x=0; x<protSeq.length(); x++ )
		{
			for( int y=0; y<AA_LETTERS.length; y++ )
			{
				if ( AA_LETTERS[y] == protSeq.charAt(x) )
				{
					expectedFreq *= AA_FREQS[y];
				}				
			}
		}
		return expectedFreq;
	}
	
	/*
	* calls getRandomProtein() numIterations times generating a protein with length equal to protSeq.length().
	 * Returns the number of time protSeq was observed / numIterations
	 */
	public double getFrequencyFromSimulation( String protSeq, int numIterations )
	{
		int protSeqCounter = 0;
		for( int x=0; x<numIterations; x++ )
		{
			String randomProteinSeq = getRandomProtein(3);
			if ( protSeq.equals(randomProteinSeq) )
			{
				protSeqCounter++;
			}
		}
		double freqFromSim = (double) protSeqCounter/numIterations;
		return freqFromSim;
	}
	
	public static void main(String[] args) throws Exception
	{
		//System.out.println(uniformGen.getRandomProtein(20));
		

		RandomProteinGenerator uniformGen = new RandomProteinGenerator(true);
		String testProtein = "ACD";
		int numIterations =  10000000;
		System.out.println(uniformGen.getExpectedFrequency(testProtein)); 
		// should be 0.05^3 = 0.000125
		System.out.println(uniformGen.getFrequencyFromSimulation(testProtein,numIterations));  
		// should be close
		
		RandomProteinGenerator realisticGen = new RandomProteinGenerator(false);
		
		System.out.println(realisticGen.getExpectedFrequency(testProtein));
		// should be 0.072658 *  0.024692 * 0.050007 == 8.97161E-05
		System.out.println(realisticGen.getFrequencyFromSimulation(testProtein,numIterations));  
		// should be close
	}
}