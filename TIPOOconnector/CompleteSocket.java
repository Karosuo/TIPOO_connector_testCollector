package TIPOOconnector;

import java.net.*; // java.net.Socket;
import java.io.*; // java.io.BufferedReader, PrintWriter, InputStreamReader
				  // IOException, SecurityException, UnknownHostException, IllegalArgumentException


public class CompleteSocket
{
	protected Socket client_socket;
	protected PrintWriter socket_output;
	protected InputStreamReader input_sreader;
	protected BufferedReader socket_input;
	protected InputStreamReader std_in_reader;
	protected BufferedReader std_in;


	public CompleteSocket(String host_name, int port_number)
	{
		try
		{
			client_socket = new Socket(host_name, port_number);

			//gets the OutputStream to write through the socket to the server and auto_flush=true
			socket_output = new PrintWriter(client_socket.getOutputStream(), true); 
						

			/*----------------*/
			//Uses de InputStream of the socket to read.
			input_sreader = new InputStreamReader(client_socket.getInputStream());
			
			//gets the InputStream to read throught the socket the server response
			socket_input = new BufferedReader(input_sreader);

			
			/*----------------*/
			//Uses the std input of stream source to read, the send it to the buffered reader.
			std_in_reader = new InputStreamReader(System.in);

			//Represents the local machine standard input, keyboard.
			std_in = new BufferedReader(std_in_reader);

			/*
				Creo que falta agregar un InputStream para recibir datos desde otro modulo.
				Ademas de la Std Input
			*/

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
	
	}// end constructor 1

	public void readFromString(String data_to_send)
	{
		//String user_input;
		String server_response;

		try
		{
								
			data_to_send = String.format("GET /java_io_interface?value=%s HTTP/1.0\r\n\r\n", data_to_send);
			this.socket_output.print(data_to_send);
			this.socket_output.flush();
			System.out.println("\n"+data_to_send);
				while((server_response = this.socket_input.readLine()) != null)
				{
					System.out.println("\nServer response: " + server_response);		
				}			
		}
		catch(IOException io_exep)
		{
			ErrorLog.addLog(" IOException catched.-\nSpecified info:\n");
			io_exep.printStackTrace();
		}
	}


	public void readFromStdIn()
	{
		String user_input;
		String server_response;

		try
		{
			while((user_input = this.std_in.readLine()) != null)
			{				
				//user_input = String.format("GET /java_io_interface?%s HTTP/1.0\r\n\r\n", NetUtils.urlEncode(user_input));
				user_input = String.format("GET /java_io_interface?%s HTTP/1.0\r\n\r\n", user_input);
				this.socket_output.print(user_input);
				this.socket_output.flush();
				System.out.println("\n"+user_input);
					while((server_response = this.socket_input.readLine()) != null)
					{
						System.out.println("\nServer response: " + server_response);		
					}
			}
		}
		catch(IOException io_exep)
		{
			ErrorLog.addLog(" IOException catched.-\nSpecified info:\n");
			io_exep.printStackTrace();
		}
	}

	public void setClientSocket(Socket new_client_socket)
	{
		this.client_socket = new_client_socket;
	}


	public void setSocketOutput(PrintWriter new_socket_output)
	{
		this.socket_output = new_socket_output;
	}


	public void setInputSreader(InputStreamReader new_input_sreader)
	{
		this.input_sreader = new_input_sreader;
	}


	public void setSocketInput(BufferedReader new_socket_input)
	{
		this.socket_input = new_socket_input;
	}


	public void setStdInReader(InputStreamReader new_std_in_reader)
	{
		this.std_in_reader = new_std_in_reader;
	}


	public void setStdIn(BufferedReader new_std_in)
	{
		this.std_in = new_std_in;
	}




	public Socket getClientSocket()
	{
		return this.client_socket;
	}


	public PrintWriter getSocketOutput()
	{
		return this.socket_output;
	}


	public InputStreamReader getInputSReader()
	{
		return this.input_sreader;
	}


	public BufferedReader getSocketInput()
	{
		return this.socket_input;
	}


	public InputStreamReader getStdInReader()
	{
		return this.std_in_reader;
	}


	public BufferedReader getStdIn()
	{
		return this.std_in;
	}


}				