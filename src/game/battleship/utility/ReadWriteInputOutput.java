package game.battleship.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jay Gohel
 *	this class is performing reading and writing operation to the file
 */
public class ReadWriteInputOutput {
	
	/**
	 * @param fileName
	 * @return input[]
	 * @throws Exception
	 */
	public static String[] readInput(String fileName) throws Exception
	{
		String [] inputs = new String[6];
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		try {
		    
		    int i = 0;
		    String line ;
			while ( (line = br.readLine()) != null) {
				if(i>5) break;
		        inputs[i++] = line.toUpperCase();		        
		    }		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("Not a valid input");
		}
		finally {
		    br.close();
		}
		return inputs;
	}
	/**
	 * @param fileName
	 * @param output
	 * @throws Exception
	 */
	public static void writeOutput(String fileName,String output) throws Exception
	{
		
		BufferedWriter br = new BufferedWriter(new FileWriter(fileName));
		try {
		   		 br.write(output);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("Not a valid input");
		}
		finally {
		    br.close();
		}
	}
	/**
	 * @param fileName
	 * @return list of inputs
	 * @throws Exception
	 */
	public static List<String[]> readInputForTest(String fileName) throws Exception {
		List<String[]> inList = new ArrayList<String[]>();
		String [] inputs = new String[6];
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		try {
		    
		    int i = 0;
		    int lineNo = 0;
		    String line ;
			while ( (line = br.readLine()) != null) {
				System.out.println(line);
				if(line.startsWith("--"))
				{
					if(lineNo > 1)
					{
						inList.add(inputs);
						inputs = new String[6];
						i=0;
					}
					continue;
				}				
		        inputs[i++] = line.toUpperCase();
		        lineNo++;
		    }		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("Not a valid input");
		}
		finally {
		    br.close();
		}
		return inList;
	}
}
