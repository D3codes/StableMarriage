import java.util.*;
import java.io.*;

public class InOut
{
	public void printLine(String output)
	{
		System.out.println(output);
	}

	public void printError(Exception err)
	{
		System.err.println(err);
	}

	public ArrayList readFile(String fileName)
	{
		ArrayList al = new ArrayList();
		
		try
		{
			FileReader fstream = new FileReader(fileName);
			BufferedReader in = new BufferedReader(fstream);

			String line;
			while((line = in.readLine()) != null)
			{
				al.add(line);
			}	

			in.close();
		}catch(Exception e) {printError(e);}
		
		return al;
	}
}