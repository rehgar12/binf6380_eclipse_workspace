package parsers;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FastaSequence
{
	
	private String header;
	private String sequence;
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
		String line = "";
		String sequence = "";
		String header = "";
		
		//initialize condition for line 
		int stillSeq = 0;
		
		//pattern to match
		String pattern = "^>.*$";
		//create Pattern object
		Pattern r = Pattern.compile(pattern);
		while( (line = reader.readLine()) != null )
		{				
			//create Matcher object
			Matcher m = r.matcher(line);
			//defining header
			if( m.find() )
			{
				if( stillSeq == 0 )
				{
					header = line.replace(">", "");
					sequence = "";
					stillSeq = 1;					
				}
				else if( stillSeq == 1 )
				{
					list.add(new FastaSequence(header, sequence));
					header = line.replace(">", "");
					sequence = "";
					stillSeq = 0;
				}
				else if( stillSeq == 2 )
				{
					list.add(new FastaSequence(header, sequence));					
					header = line.replace(">", "");
					sequence = "";
					stillSeq = 1;
				}
			}
			//defining sequence
			//concatenate all sequence lines under each header
			else
			{
				if( stillSeq == 0 )
				{
					sequence = sequence + line;
					stillSeq = 2;
				}
				else if( stillSeq == 1 || stillSeq == 2 )
				{
					sequence = sequence + line;
				}
			}
		}
//		adding sequence of last read
		list.add(new FastaSequence(header, sequence));
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
		
		for(FastaSequence fs : fastaList)
		{	
			System.out.println(fs.getHeader());
			System.out.println(fs.getSequence());
			System.out.println(fs.getGCRatio());
		}

	}
}