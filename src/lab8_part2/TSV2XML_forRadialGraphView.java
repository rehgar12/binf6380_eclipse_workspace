package lab8_part2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TSV2XML_forRadialGraphView
{
	private int id;
	private String name;
	private String level;
	
	//constructor
	public TSV2XML_forRadialGraphView( int id, String name, String level )
	{
		this.id = id;
		this.name = name;
		this.level = level;
	}
	
	
	//static factory for getting unique names paired to an object containing the id, name, and level of the organism(name)
	public static HashMap<String, TSV2XML_forRadialGraphView> UniqueNames( String inFile ) throws Exception
	{
		BufferedReader reader = new BufferedReader(new FileReader(inFile));
		String line = "";
		int id = 0;
		String name = "";
		String level = "";
		HashMap<String, TSV2XML_forRadialGraphView> map_NameIdLevel = new HashMap<>();
		
		//take first line headers for level assignment to names
		line = reader.readLine();
		String[] lvlArray = new String[5];
		lvlArray = line.split("\t");
		
		int idCount = 1;
		while( (line = reader.readLine()) != null )
		{
			String[] lineArray = new String[5];
			lineArray = line.split("\t");
			
			int lvlCount = 0;
			for( String x : lineArray )
			{
				name = x;
				if( x.equals("") )
				{
	//				System.out.println("name is blank, not adding to hashmap");
				}
				else if( map_NameIdLevel.get(name) == null )
				{
					idCount++;
					id = idCount;
					level = lvlArray[lvlCount];
					map_NameIdLevel.put(name, new TSV2XML_forRadialGraphView(id, name, level));
				}
				lvlCount++;
			}
		}
		reader.close();
		return map_NameIdLevel;
	}
	
	
	public static Set<String> MakeEdges( String inFile, HashMap<String, TSV2XML_forRadialGraphView> uniNames ) throws Exception
	{
		Set<String> edges = new HashSet<>();
		BufferedReader reader = new BufferedReader(new FileReader(inFile));
		String line = "";
		
		//skip first line (header)
		line = reader.readLine();
		
		while( (line = reader.readLine()) != null )
		{
			String[] lineArray = new String[5];
			lineArray = line.split("\t");
			
			//phylum
			//there must be a phylum for each line... then some brute force logic to get account for potential empty cells
			edges.add("<edge source=\"1\" target=\""+ uniNames.get(lineArray[0]).getid() + "\"></edge>\n");
			
			if( !lineArray[1].equals("") && !lineArray[2].equals("") && !lineArray[3].equals("") && !lineArray[4].equals("") )
			{
				edges.add("<edge source=\"" + uniNames.get(lineArray[0]).getid() + "\" target=\"" + uniNames.get(lineArray[1]).getid() + "\"></edge>\n");
				edges.add("<edge source=\"" + uniNames.get(lineArray[1]).getid() + "\" target=\"" + uniNames.get(lineArray[2]).getid() + "\"></edge>\n");
				edges.add("<edge source=\"" + uniNames.get(lineArray[2]).getid() + "\" target=\"" + uniNames.get(lineArray[3]).getid() + "\"></edge>\n");
				edges.add("<edge source=\"" + uniNames.get(lineArray[3]).getid() + "\" target=\"" + uniNames.get(lineArray[4]).getid() + "\"></edge>\n");
			}
			else if( !lineArray[1].equals("") && !lineArray[2].equals("") && !lineArray[3].equals("") && lineArray[4].equals("") )
			{
				edges.add("<edge source=\"" + uniNames.get(lineArray[0]).getid() + "\" target=\"" + uniNames.get(lineArray[1]).getid() + "\"></edge>\n");
				edges.add("<edge source=\"" + uniNames.get(lineArray[1]).getid() + "\" target=\"" + uniNames.get(lineArray[2]).getid() + "\"></edge>\n");
				edges.add("<edge source=\"" + uniNames.get(lineArray[2]).getid() + "\" target=\"" + uniNames.get(lineArray[3]).getid() + "\"></edge>\n");
			}
			else if( !lineArray[1].equals("") && !lineArray[2].equals("") && lineArray[3].equals("") && lineArray[4].equals("") )
			{
				edges.add("<edge source=\"" + uniNames.get(lineArray[0]).getid() + "\" target=\"" + uniNames.get(lineArray[1]).getid() + "\"></edge>\n");
				edges.add("<edge source=\"" + uniNames.get(lineArray[1]).getid() + "\" target=\"" + uniNames.get(lineArray[2]).getid() + "\"></edge>\n");
			}
			else if( !lineArray[1].equals("") && lineArray[2].equals("") && lineArray[3].equals("") && lineArray[4].equals("") )
			{
				edges.add("<edge source=\"" + uniNames.get(lineArray[0]).getid() + "\" target=\"" + uniNames.get(lineArray[1]).getid() + "\"></edge>\n");
			}
			else if( lineArray[1].equals("") && lineArray[2].equals("") && lineArray[3].equals("") && lineArray[4].equals("") )
			{
			}
			
			
			else if( lineArray[1].equals("") && !lineArray[2].equals("") && !lineArray[3].equals("") && !lineArray[4].equals("") )
			{
				edges.add("<edge source=\"" + uniNames.get(lineArray[0]).getid() + "\" target=\"" + uniNames.get(lineArray[2]).getid() + "\"></edge>\n");
				edges.add("<edge source=\"" + uniNames.get(lineArray[2]).getid() + "\" target=\"" + uniNames.get(lineArray[3]).getid() + "\"></edge>\n");
				edges.add("<edge source=\"" + uniNames.get(lineArray[3]).getid() + "\" target=\"" + uniNames.get(lineArray[4]).getid() + "\"></edge>\n");
			}
			else if( lineArray[1].equals("") && !lineArray[2].equals("") && !lineArray[3].equals("") && lineArray[4].equals("") )
			{
				edges.add("<edge source=\"" + uniNames.get(lineArray[0]).getid() + "\" target=\"" + uniNames.get(lineArray[2]).getid() + "\"></edge>\n");
				edges.add("<edge source=\"" + uniNames.get(lineArray[2]).getid() + "\" target=\"" + uniNames.get(lineArray[3]).getid() + "\"></edge>\n");
			}
			else if( lineArray[1].equals("") && !lineArray[2].equals("") && lineArray[3].equals("") && lineArray[4].equals("") )
			{
				edges.add("<edge source=\"" + uniNames.get(lineArray[0]).getid() + "\" target=\"" + uniNames.get(lineArray[2]).getid() + "\"></edge>\n");
			}

			
			
			
			else if( lineArray[1].equals("") && lineArray[2].equals("") && !lineArray[3].equals("") && !lineArray[4].equals("") )
			{
				edges.add("<edge source=\"" + uniNames.get(lineArray[0]).getid() + "\" target=\"" + uniNames.get(lineArray[3]).getid() + "\"></edge>\n");
				edges.add("<edge source=\"" + uniNames.get(lineArray[3]).getid() + "\" target=\"" + uniNames.get(lineArray[4]).getid() + "\"></edge>\n");
			}
			else if( lineArray[1].equals("") && lineArray[2].equals("") && !lineArray[3].equals("") && lineArray[4].equals("") )
			{
				edges.add("<edge source=\"" + uniNames.get(lineArray[0]).getid() + "\" target=\"" + uniNames.get(lineArray[3]).getid() + "\"></edge>\n");
			}
			
			
			if( lineArray[1].equals("") && lineArray[2].equals("") && lineArray[3].equals("") && !lineArray[4].equals("") )
			{
				edges.add("<edge source=\"" + uniNames.get(lineArray[0]).getid() + "\" target=\"" + uniNames.get(lineArray[4]).getid() + "\"></edge>\n");
			}
			
		}
		reader.close();
		return edges;
	}
	
	
//GETTERS	
	public int getid()
	{
		return id;
	}
	public String getname()
	{
		return name;
	}
	public String getlevel()
	{
		return level;
	}
	
	
	public static void main(String[] arg0) throws Exception
	{
		String inFile = new String("/home/playerra/Documents/UNCC_fall2015/binf6380/lab8/phyloData.tsv");
		File outFile = new File("/home/playerra/Documents/UNCC_fall2015/binf6380/lab8/phyloData.xml");
		
		HashMap<String, TSV2XML_forRadialGraphView> uniNames = UniqueNames(inFile);
		Set<String> edgeSet = MakeEdges(inFile, uniNames);
		
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
		//add header
		writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<!--  input from an RDP file -->\n<graphml xmlns=\"http://graphml.graphdrawing.org/xmlns\">\n<graph edgedefault=\"undirected\">\n<!-- data schema -->\n<key id=\"name\" for=\"node\" attr.name=\"name\" attr.type=\"string\"/>\n<key id=\"level\" for=\"node\" attr.name=\"level\" attr.type=\"string\"/>\n<!-- nodes -->\n");
		//add root node
		writer.write("<node id=\"1\">\n<data key=\"name\">root</data>\n<data key=\"level\">root</data>\n</node>\n");
		
		//adding nodes
		for( TSV2XML_forRadialGraphView value : uniNames.values() )
		{
			writer.write("<node id=\"" + value.getid() + "\">\n<data key=\"name\">" + value.getname() + "</data>\n<data key=\"level\">" + value.getlevel() + "</data>\n</node>\n");
			writer.flush();
		}
		//adding edges
		for( String edge : edgeSet )
		{
			writer.write(edge);
		}
		//adding footer
		writer.write("</graph>\n</graphml>");
		
		writer.close();		
	}
}
