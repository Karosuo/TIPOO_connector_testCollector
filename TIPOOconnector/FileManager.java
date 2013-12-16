package TIPOOconnector;

import java.io.*;

public class FileManager
{
	
	protected static void borrar_Serializados(String nombreArchivo)
  	{
  		if(!FileManager.borra_Archivo(nombreArchivo))
  		{
  			ErrorLog.addLog("Error al intentar borrar el archivo.");
  		}else
  		{
  			System.out.println(String.format("%s borrado",nombreArchivo));
  		}
  	}


	public static Object[] des_Serializa(String nombreArchivo)
	 {
	    FileInputStream inS_File;
	    ObjectInputStream inObjStream;
	    Object lectura;
	    Object[] salida;
	    
	    try{
	    	nombreArchivo = "bin\\tmp\\"+nombreArchivo;   	
	     	inS_File = new FileInputStream(nombreArchivo);
	     	inObjStream = new ObjectInputStream(inS_File);
	     	lectura = inObjStream.readObject();	     	
	     	salida = (Object[]) lectura;
	     	System.out.println("Deserializado");
	     	return salida;

	    }catch(IOException | ClassNotFoundException e2)
	    {
	    	System.out.println(String.format("Error al des_Serializar, %s", e2));
	    	ErrorLog.addLog("Problemas al abrir el archivo o al buscarlo.");
	    }

	    return null;
	 }

	public static boolean serializa(String nombreArchivo, Object[] arregloClases)
	{

		FileOutputStream outS_File;
		ObjectOutputStream outObjStream;

		try{
			nombreArchivo = "bin\\tmp\\"+nombreArchivo;
			outS_File = new FileOutputStream(nombreArchivo);
			outObjStream = new ObjectOutputStream(outS_File);   	
			outObjStream.writeObject(arregloClases);
			outObjStream.close();
			outS_File.close();
			System.out.println("Serializado");

			return true;
		}catch(IOException e2)
		{
			ErrorLog.addLog("Problemas al escribir el archivo.");
		}

		return false;
	}


	public static Object des_Serializa_Elemento(String nombreArchivo)
	 {
	    FileInputStream inS_File;
	    ObjectInputStream inObjStream;
	    Object salida;	    
	    
	    try{
	    	nombreArchivo = "TIPOOconnector\\"+nombreArchivo;   	
	     	inS_File = new FileInputStream(nombreArchivo);
	     	inObjStream = new ObjectInputStream(inS_File);
	     	salida = inObjStream.readObject();	     		     	
	     	System.out.println("Deserializado");
	     	return salida;

	    }catch(IOException | ClassNotFoundException e2)
	    {
	    	System.out.println(String.format("Error al des_Serializar, %s", e2));
	    	ErrorLog.addLog("Problemas al abrir el archivo o al buscarlo.");
	    }

	    return null;
	 }

	public static boolean serializa_Elemento(String nombreArchivo, Object arregloClases)
	{

		FileOutputStream outS_File;
		ObjectOutputStream outObjStream;

		try{
			nombreArchivo = "TIPOOconnector\\"+nombreArchivo;
			outS_File = new FileOutputStream(nombreArchivo);
			outObjStream = new ObjectOutputStream(outS_File);   	
			outObjStream.writeObject(arregloClases);
			outObjStream.close();
			outS_File.close();
			System.out.println("Serializado");

			return true;
		}catch(IOException e2)
		{
			ErrorLog.addLog("Problemas al escribir el archivo.");
		}
		    
		return false;
	}


	public static boolean borra_Archivo(String nombre)
	{
		File archivo = new File(nombre);
		boolean resultado;

		if (existe_Archivo(archivo) && !archivo_Solo_Lectura(archivo) && !archivo_Es_Directorio(archivo))
		{
			resultado = archivo.delete();	

			if (resultado)
			{
				return true;
			}
		}

		return false;
	}


	public static boolean existe_Archivo(File archivo)
	{
		if (archivo.exists())
		{
			return true;
		}
		return false;
	}

	public static boolean archivo_Es_Directorio(File archivo)
	{
		if (archivo.isDirectory())
		{
			return true;
		}

		return false;
	}

	public static boolean archivo_Solo_Lectura(File archivo)
	{
		if (archivo.canWrite())
		{
			return false;
		}

		return true;
	}
}