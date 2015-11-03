package lab6_part1;
/*
import parsers.*;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
*/
public class UniqueSeqs
{
	/*
	public static void writeUnique( String inFile, File outFile ) throws Exception
	{
		//call FastaSequence class from parsers package
		List<FastaSequence> fastaList = FastaSequence.readFastaFile(inFile);
		
		//make a Map to put unique seqs and their counts in to
		HashMap<String, Integer> uniSeqs = new HashMap<String, Integer>();
		//add unique sequences and their counts to hashmap
		for(FastaSequence fs : fastaList)
		{			
			Integer count = uniSeqs.get(fs.getSequence());
			if( count == null )
			{
				count = 0;
			}
			count++;
			uniSeqs.put(fs.getSequence(), count);
		}
		
		//create a sorted map object by calling the sortByValues method
		Map<String, Integer> uniSeqsSorted = sortByValues(uniSeqs);
		//iterate through the sorted map and send results to outFile
		BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
		for( Map.Entry<String, Integer> x : uniSeqsSorted.entrySet())
		{
			String key = x.getKey();
			Integer value = x.getValue();

//			System.out.println(key + " " + value);
			writer.write(">" + value + "\n" + key + "\n");
			writer.flush();
		}
		writer.close();
	}
	
	//I got this sort by value method from Beginner's Book website, this implementation made the most sense to me compared to some of the crazy s**t on stackoverflow
	private static HashMap sortByValues(HashMap map)
	{
		List list = new LinkedList(map.entrySet());
		Collections.sort
		(
			list, new Comparator()
			{
				public int compare(Object o1, Object o2)
				{
					return ( (Comparable) ((Map.Entry)(o1)).getValue()).compareTo(((Map.Entry)(o2)).getValue());
				}
			}
		);
		//copying the sorted list in HashMap using LinkedHashMap to preserve insertion order
		LinkedHashMap sortedHashMap = new LinkedHashMap();
		for( Iterator x = list.iterator(); x.hasNext(); )
		{
			Map.Entry entry = (Map.Entry)x.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return sortedHashMap;
	}

	public static void main(String[] args) throws Exception
	{
		//kept the inFile a String because the imported class from 'parsers' takes a String as an argument
		String inFile = new String("/home/playerra/Documents/UNCC_fall2015/binf6380/20151021/testlab6.fasta");
		File outFile = new File("/home/playerra/Documents/UNCC_fall2015/binf6380/20151021/testlab6.outFile");
		writeUnique(inFile, outFile);
	}
	*/
}