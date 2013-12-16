package bin;

/*import java.net.URL;
import java.net.MalformedURLException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLConnection;
import java.io.PrintStream;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;*/
import java.io.*; //java.InputStra, java.OutputStream
import java.net.*;

public class netTest
{
	public static void main(String[] args)
	{
		if(args.length == 0)
		{
			ErrorLog.addLog("Debes introducir una url");
		}
		else		
		{
			URL nuevaURL = createURLObject(args[0]);

			if (nuevaURL != null)
			{
				URLConnection connection1 = connectToURL(nuevaURL);
				String file;

				//file = readFileFromURLConnection(connection1);				
				printStringIntoURLConnection(connection1, "This damit string");

				file = readFileFromURL(nuevaURL);				
				//file = readFileFromURLConnection(connection1);				

				if (file != null)
				{
					System.out.println(file);
				}
				else
				{
					ErrorLog.printLog();
				}
				//printStringIntoURLConnection(connection1, "?newArg=\"some+thing\"");			
				//showFileContentFromURL(nuevaURL);
			}
		}//end args null if

		ErrorLog.printLog();

	}//end main

	public static void printStringIntoURLConnection(URLConnection url_connection, String new_string)
	{
		PrintStream one_print_stream;
		String complete_string = "";
		url_connection.setDoOutput(true);

		try
		{
			one_print_stream = new PrintStream(url_connection.getOutputStream());
		
			new_string = URLEncoder.encode(new_string, "UTF-8");
			//complete_string = String.format("?nombre=\"%s\"", new_string);
			complete_string = "?nombre=Jorge+Ibarra&email=jorgeeie%40uabc.mx";
			
			//System.out.println(complete_string);

			one_print_stream.println(complete_string);
			one_print_stream.close();		

			url_connection.connect();
		}
		catch(IOException ioEx)
		{
			ErrorLog.addLog("-IOException catched.-\nwhile trying to create a PrintStream instance.\nOr trying to encode given string.");
		}		
		/*catch(UnsupportedEncodingException unsEncEx)
		{
			ErrorLog.addLog("-UnsupportedEncodingException catched.-\nwhile trying to encode (URLEncoder.encode()) the specified string.");
		}*/

	}

	public static String stringConcatFromFile(BufferedReader buffer)
	{

		String stringLine = "";
		String allFile = "";

		if(buffer != null)
		{
			do
			{
				try
				{
					stringLine = buffer.readLine();//Tries to read a string from file
					if (stringLine != null)
					{
						allFile += stringLine;	
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

			}while(stringLine != null); //while something found in file, cicle still
		}
		

		return allFile;
	}//end stringConcatFromFile



	

	public static URLConnection connectToURL(URL nuevaURL)
	{
		try
		{
			return nuevaURL.openConnection();
		}catch(IOException ioEx)
		{
			ErrorLog.addLog("-IOException catched.-\nwhile trying to open connection to a URL");
			return null;
		}
	}

/*

	public static void myGetFilePropertiesFromConnection(URLConnection url_connection)throws IOException
	{

		System.out.println(String.format("Content Encoding: %s",url_connection.getContentEncoding()));
		System.out.println(String.format("Content length: %s", url_connection.getContentLength()));
		System.out.println(String.format("Content Type: %s", url_connection.getContentType()));
		System.out.println(String.format("Content Date: %s",url_connection.getDate()));
		System.out.println(String.format("Content Expiration: %s",url_connection.getExpiration()));
		System.out.println(String.format("Content Last Modified: %s",url_connection.getLastModified()));
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

*/
	

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



	public static String readFileFromURLConnection(URLConnection url_connection)
	{
		InputStreamReader inSR = null;
		BufferedReader buffer = null;
		String all_file_string;		

		try
		{
			inSR = new InputStreamReader(url_connection.getInputStream());
		}
		catch(IOException ioEx)
		{
			ioEx.printStackTrace();
			ErrorLog.addLog("\n-IOException catched.-\nwhile trying to get the Input Stream from URLConnection");
		}

		if (inSR != null)
		{
			buffer = new BufferedReader(inSR);	
		}
		
		all_file_string = stringConcatFromFile(buffer);

		if (all_file_string != null)
		{
			return all_file_string;
		}
		else
		{
			return null;	
		}

		
	}//end readFileFromURLConnection
	

	public static String readFileFromURL(URL nuevaURL)
	{
		InputStreamReader inSR = null;
		BufferedReader buffer = null;
		String all_file_string;

		try
		{
			 inSR = new InputStreamReader(nuevaURL.openStream());

		}
		catch(IOException ioEx)
		{
			ErrorLog.addLog("-IOException catched.-\nwhile trying to get the Input Stream from URL");
		}

		if (inSR != null)
		{
			buffer = new BufferedReader(inSR);	
		}
		
		all_file_string = stringConcatFromFile(buffer);

		if (all_file_string != null)
		{
			return all_file_string;
		}
		else
		{
			return null;	
		}
	}

}