package TIPOOconnector;

import java.io.*; // Serializable


public class Examen implements Serializable
{
	protected String[][] preguntas_respuestas;
	protected int[] respuestas_obtenidas;
	protected int total_preguntas;

	public Examen()
	{
		preguntas_respuestas = null;
		respuestas_obtenidas = null;
		total_preguntas = 0;
	}

	public Examen(int cant_preguntas)
	{
		respuestas_obtenidas = new int[cant_preguntas];
		this.total_preguntas = cant_preguntas;
	}

	public void setRespuestasObtenidas(int respuestaN, int index)
	{
		if (index < this.respuestas_obtenidas.length)
		{
			this.respuestas_obtenidas[index] = respuestaN;
		}
	}

	
	public void setRespuestasObtenidas(int[] respuestas_obtenidas)
	{
		this.respuestas_obtenidas = respuestas_obtenidas;
	}


	public void setPreguntasRespuestas(String[][] preguntas_respuestas)
	{
		this.preguntas_respuestas = preguntas_respuestas;
	}

	public String getPregunta(int index)
	{
		for (String[] tempElem: this.preguntas_respuestas)
		{
			if (index < tempElem.length)
			{
				return tempElem[index];
			}
			else
			{
				ErrorLog.addLog("Indice fuera de rango para vector.");				
			}
		}

		return null;
	}

	public int getRespuesta(int index)
	{
		if (index < this.respuestas_obtenidas.length)
		{
			return this.respuestas_obtenidas[index];
		}

		return 0;
	}

	public int getTotalPreguntas()
	{
		return this.total_preguntas;
	}

}