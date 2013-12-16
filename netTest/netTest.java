package bin;

import java.net.URL;
import java.net.MalformedURLException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLConnection;

public class netTest
{
	public static void main(String[] args)
	{
		if(args.length == 0)
		{
			System.out.println("Debes introducir una url");
		}
		else		
		{
			URL nuevaURL = createURLObject(args[0]);

			if (nuevaURL != null)
			{
				myGetInfoFromURLConnection(nuevaURL);
				//showFileContentFromURL(nuevaURL);
			}
			else
			{
				ErrorLog.printLog();
			}
		}
	}//end main

	public static boolean myGetInfoFromURLConnection(URL nuevaURL)
	{
		URLConnection url_connection = null;	

		try
		{
			url_connection = connectToURL(nuevaURL);
		}catch(IOException ioEx)
		{
			ErrorLog.addLog("-IOException catched.-\nwhile trying to open connection to a URL");
		}
		

		try
		{
			myGetFilePropertiesFromConnection(url_connection);
			return true;
		}
		catch(IOException ioEx)
		{
			ErrorLog.addLog("-IOException catched.-\nwhile trying to open connection to a URL");
		}

		return false;
	}

	public static void myGetFilePropertiesFromConnection(URLConnection url_connection)throws IOException
	{
		/*
		InputStreamReader inSR;
		BufferedReader buffer;
		inSR = new InputStreamReader(url_connection.getInputStream());
		buffer = new BufferedReader(inSR);

		System.out.println(buffer.readLine());*/

		System.out.println(String.format("Content Encoding: %s",url_connection.getContentEncoding()));
		System.out.println(String.format("Content length: %s", url_connection.getContentLength()));
		System.out.println(String.format("Content Type: %s", url_connection.getContentType()));
		System.out.println(String.format("Content Date: %s",url_connection.getDate()));
		System.out.println(String.format("Content Expiration: %s",url_connection.getExpiration()));
		System.out.println(String.format("Content Last Modified: %s",url_connection.getLastModified()));
	}

	public static URLConnection connectToURL(URL nuevaURL)throws IOException
	{
		return nuevaURL.openConnection();
	}

	public static URL createURLObject(String urlTested)
	{
		try
		{
			URL nuevaURL = new URL(urlTested);
			return nuevaURL;
		}catch(MalformedURLException malURLex)
		{
			ErrorLog.addLog("-MalformedURLException catched.-\nCheck your URL format.\nProtocol + Host [+ Port number] + Direct URL for the file");
		}
		return null;
	}

	public static boolean showFileContentFromURL(URL nuevaURL)
	{
		String allFile = readFileFromURL(nuevaURL);

		if (allFile != null)
		{
			System.out.println(allFile);
			return true;
		}
		else
		{
			ErrorLog.printLog();
			return false;
		}
	}

	

	public static String readFileFromURL(URL nuevaURL)
	{
		InputStreamReader inSR;
		BufferedReader buffer;
		String fileLines = "";
		String allFile = null;

		try
		{
			inSR = new InputStreamReader(nuevaURL.openStream());
			buffer = new BufferedReader(inSR);
		}catch(IOException ioEx)
		{	
			ErrorLog.addLog("-IOException catched.-\nWhile creating and assigning readers");
			return null;
		}
		

		do
		{
			try
			{
				fileLines = buffer.readLine();//Tries to read a string from file
				if (fileLines != null)
				{
					allFile += fileLines;	
				}
				else
				{
					if (allFile == null) //never been assigned, means file readed is empty
					{
						ErrorLog.addLog("Nothing found in the file.");
					}
				}
				
			}
			catch(IOException ioEx)
			{
				ErrorLog.addLog("-IOException catched.-\nWhile reading buffer");
			}

		}while(fileLines != null); //while something found in file, cicle still
		

		return allFile;
	}

}