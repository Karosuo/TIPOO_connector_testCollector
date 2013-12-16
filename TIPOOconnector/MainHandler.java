package TIPOOconnector;

//import java.net.*;
//import java.io.*;

//System.out.println("Must type:\n>> java bin.TIPOOconnector <host name(String)> <por number(int)>");
	//Socket newSocket = SocketProcesses.getSocket(args[0], Integer.parseInt(args[1]));
	//CompleteSocket socket = new CompleteSocket(args[0], Integer.parseInt(args[1]));
	//socket.readFromStdIn();


public class MainHandler
{
	public static String hostname;
	public static int port_number;

	public static void main(String[] args)
	{	

		menuPrincipal();
	}//end main

	public static void menuPrincipal()
	{
		String[] opcionesGenerales = {"Hacer Examen", "Enviar Datos a TIPOO"};
		boolean salir = false;
		boolean reset_host_address = false;

		do
		{
			hostname = GUI.getString("Hostname: ");
			port_number = GUI.getInt("Port Number: ", 0, 65535, null);

			do
			{				
				switch(GUI.getChoice("Que deseas hacer.",opcionesGenerales))
				{
					case 0:
						testExamen();
						break;

					case 1:
						enviarInfoExamen();
						break;
				}

				ErrorLog.printLog();
				ErrorLog.clear();
				
				reset_host_address = GUI.getBoolean("Cambiar de Host?");

				if (reset_host_address != true)
				{
					salir = GUI.getBoolean("Salir");		
				}

			}while(reset_host_address == false && salir == false);		
				
			
		}while(salir == false);	
	}


	public static void enviarInfoExamen()
	{
		Examen examen_salida = (Examen) FileManager.des_Serializa_Elemento("examen.ser");
		String data_to_send = "";		
		CompleteSocket socket = new CompleteSocket(hostname, port_number);

		if (examen_salida != null)
		{
			data_to_send += "Cantidad de preguntas:" + examen_salida.getTotalPreguntas() + "\n\n"; 

			for (int cont=0; cont<examen_salida.getTotalPreguntas(); cont++)
			{			
				data_to_send += String.format(" Pregunta %d: ", cont+1);
				data_to_send += String.valueOf(examen_salida.getPregunta(examen_salida.getRespuesta(cont)));
			}

			if (data_to_send != null)
			{
				data_to_send = NetUtils.urlEncode(data_to_send);
				socket.readFromString(data_to_send);

				FileManager.borrar_Serializados("examen.ser");
			}
		}

	}


	public static void testExamen()
	{
		String[] opciones1 = {"Respuesta A", "Respuesta B", "Respuesta C"};
		String[] opciones2 = {"Respuesta A", "Respuesta B", "Respuesta C"};
		String[][] preguntas_respuestas = {opciones1, opciones2};

		int respuesta1 = GUI.getChoice("Pregunta1", opciones1);
		int respuesta2 = GUI.getChoice("Pregunta2", opciones2);
		int[] respuestas_obtenidas = {respuesta1, respuesta2};

		Examen nuevoExamen = new Examen(2);

		nuevoExamen.setPreguntasRespuestas(preguntas_respuestas);
		nuevoExamen.setRespuestasObtenidas(respuestas_obtenidas);

		FileManager.serializa_Elemento("examen.ser", nuevoExamen);
	}


}