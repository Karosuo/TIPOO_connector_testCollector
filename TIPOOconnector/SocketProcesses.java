package TIPOOconnector; //common package

import java.net.*; // java.net.Socket;
import java.io.*; // java.io.BufferedReader, PrintWriter, InputStreamReader
				  // IOException, SecurityException, UnknownHostException, IllegalArgumentException

public class SocketProcesses
{
	public static Socket getSocket(String host_name, int port_number)
	{
		try
		{
			Socket client_socket = new Socket(host_name, port_number);

			//gets the OutputStream to write through the socket to the server and auto_flush=true
			PrintWriter socket_output = new PrintWriter(client_socket.getOutputStream(), true); 
						

			/*----------------*/
			//Uses de InputStream of the socket to read.
			InputStreamReader input_sreader = new InputStreamReader(client_socket.getInputStream());
			
			//gets the InputStream to read throught the socket the server response
			BufferedReader socket_input = new BufferedReader(input_sreader);

			
			/*----------------*/
			//Uses the std input of stream source to read, the send it to the buffered reader.
			InputStreamReader std_in_reader = new InputStreamReader(System.in);

			//Represents the local machine standard input, keyboard or other local byteStream
			BufferedReader std_in = new BufferedReader(std_in_reader);

			return client_socket;

		}
		catch(UnknownHostException unknown_exp)
		{
			ErrorLog.addLog(" UnknownHostException catched.-\nHost IP can not be determined\nSpecified info:\n");
			unknown_exp.printStackTrace();
		}
		catch(IOException io_exep)
		{
			ErrorLog.addLog(" IOException catched.-\nSpecified info:\n");
			io_exep.printStackTrace();
		}		
		catch(SecurityException security_exp)
		{
			ErrorLog.addLog(" SecurityException catched.-\nConnection Manager could have stopped the operation\nSpecified info:\n");
			security_exp.printStackTrace();
		}
		catch(IllegalArgumentException illegal_arg_exp)
		{
			ErrorLog.addLog(" IllegalArgumentException.-\nPort number could be out of range [0,65535]\nSpecified info:\n");
			illegal_arg_exp.printStackTrace();
		}
	
		return null;
	}// end getSocket


	
}