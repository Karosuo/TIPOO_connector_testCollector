package bin;

import java.util.ArrayList;

public class ErrorLog
{
	public static ArrayList<String> log = new ArrayList<String>();

	
	public static void addLog(String error1)
	{
		log.add(error1);
	}


	public static ArrayList<String> getLog()
	{
		return log;
	}

	public static void printLog()
	{
		if (log.isEmpty() == true)
		{
			System.out.println("\nNo hay errores registrados.\n\n");
		}
		else
		{
			System.out.println("\n\nERROR!\n\n");
			for (String logN: log)
			{
				System.out.println(String.format(">>%s\n", logN));				
			}
		}
	}


}