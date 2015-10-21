package Shape;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FastaSequence
{

	private final String header;
	private final String sequence;
	private float gcRatio;
	
	//FastaSequence obj constructor
	public FastaSequence(String header, String sequence)
	{
		this.header = header;
		this.sequence = sequence;
	}
	
	
	//the static factory
	public static List<FastaSequence> readFastaFile(String filepath) throws Exception
	{
		List<FastaSequence> list = new ArrayList<FastaSequence>();
		BufferedReader reader = new BufferedReader(new FileReader(filepath));
		StringBuffer sequence = new StringBuffer();
		
		String line = reader.readLine();
		String header = line;
		
		if( ! header.startsWith(">"))
		{
			throw new Exception("Not a fasta");
		}
		
		while( line != null)
		{	
			line = reader.readLine();
			
			if( line != null)
			{
				if( line.startsWith(">"))
				{
					list.add(new FastaSequence(header, sequence.toString()));
					header = line;
					sequence = new StringBuffer();
				}
				else
				{
					sequence.append(line);
				}
			}
			
		}
		
		list.add(new FastaSequence(header, sequence.toString()));
		reader.close();
		return list;
	}

	
	
	
	
	
	
	
	
	
	public String getHeader()
	{
		return header;
	}
	
	public String getSequence()
	{
		return sequence;
	}
	
	public float getGCRatio()
	{
		char[] seqArray = this.sequence.toCharArray();
		float gcCount = 0.0f;
		for( char c : seqArray )
		{
			if( c == 'C' || c == 'c' || c == 'G' || c == 'g' )
			{
				gcCount++;
			}
		}
		gcRatio = gcCount/seqArray.length;
		return gcRatio;
	}
	
	
	
	
	public static void main(String[] args) throws Exception
	{
		List<FastaSequence> fastaList = FastaSequence.readFastaFile("/home/playerra/Documents/UNCC_fall2015/binf6380/20150923/test.fasta");
		
		System.out.println(fastaList.size());
		
		for(FastaSequence fs : fastaList)
		{
			System.out.println(fs);
			
			
			System.out.println(fs.getHeader());
			System.out.println(fs.getSequence());
			System.out.println(fs.getGCRatio());
		}

	}
}