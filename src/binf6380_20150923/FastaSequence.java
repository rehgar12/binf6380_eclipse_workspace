package binf6380_20150923;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class FastaSequence
{
	private static String sequence = "";
	private static String header = "";
	
	//got this from http://alvinalexander.com/blog/post/java/how-open-read-file-java-string-array-list
	public static List<String> readFastaFile(String filepath)
	{
		List<String> records = new ArrayList<String>();
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(filepath));
			String line;
			
			String FastaSequence = "";
			
			
			//pattern to match
			String pattern = "^>.*$";
			//create Pattern object
			Pattern r = Pattern.compile(pattern);

			while ((line = reader.readLine()) != null)
			{				
				//create Matcher object
				Matcher m = r.matcher(line);
				if( m.find() )
				{
//					System.out.println("this is a header: " + line);
					System.out.println(FastaSequence);
					header = line + " ";
					FastaSequence = header;
				}
				else
				{
//					System.out.println("this is a seq: " + line);
					sequence = line;
					FastaSequence = FastaSequence + sequence;
//					System.out.println(FastaSequence);
				}	
//				System.out.println(FastaSequence);
			}
			reader.close();
//			System.out.println(FastaSequence);
			

			
			
			return records;
		}
	 	catch (Exception e)
	 	{
			System.err.format("Exception occurred trying to read '%s'.", filepath);
			e.printStackTrace();
			return null;
	  	}
	
	}
	
	
	
	
	
	
	public String getHeader()
	{
		String header = "";
		
		
		return header;
	}
	
	public String getSequence()
	{
		String sequence = "";
		
		
		return sequence;
	}
	
	public double getGCRatio()
	{
		double GCRatio = 0;
		
		
		return GCRatio;
	}
	
	
	
	
	
	
	public static void main(String[] args) throws Exception
	{

		List<String> fastaList = FastaSequence.readFastaFile("/home/playerra/Documents/UNCC_fall2015/binf6380/20150923/test.fasta");

		
//		System.out.println(fastaList);
		
		
		for(String fs : fastaList)
		{
			System.out.println(fs);
			
			
			System.out.println(fs.getHeader());
			System.out.println(fs.getSequence());
			System.out.println(fs.getGCRatio());
		}



	}
}