package binf6380_20150902;

import java.util.*;

public class lab2_EC_inClassDemo
{
	public static final char[] NUCLEOTIDES = {'A', 'C', 'G', 'T'};
	public static final float[] FREQS = { 0.1f, 0.2f, 0.3f, 0.4f };
	private static final Random RANDOM = new Random();
	
	/*
	 * Given the frequencies in FREQS, produce one nucleotide character
	 */
	private static char chooseOne()
	{
		float f = RANDOM.nextFloat();
		float sum = 0.0f;
				
		for( int x=0; x<NUCLEOTIDES.length; x++ )
		{
			sum+=FREQS[x];
			if( f<=sum )
				return NUCLEOTIDES[x];
		}
		return NUCLEOTIDES[NUCLEOTIDES.length -1];
	}
	
	public static void main(String[] args)
	{
		for( int x=0; x<20; x++ )
		{
			String s= "";
			for( int y=0; y<3; y++ )
			{
				s = s+chooseOne();
			}
			System.out.println(s);
		}
	}
	
	
}
