package bin;

public class Orden_Compra {

	//id_OC: ArrayList<Object> (int-String) tuplas (id incompa)
	//num_Muebles: int[2] (Mueble.id – cantidad)tuplas
	//Usuario_Facultado usr_Facultado;
	String usr_Facultado;
	//fecha: calendar
	//Sucursal sucursal;
	String sucursal;
	//boolean completa;
	boolean completa;
	String nombre_Lote_Proyecto;
	int num_Linea;


	public void setUsr_Facultado(String nuevoUusario)
	{
		usr_Facultado = nuevoUusario;
	}

	public void setSucursal(String sucursal)
	{
		this.sucursal = sucursal;
	}

	public void setCompleta(boolean estado)
	{
		completa = estado;
	}

	public void setNombre_Lote_Proyecto(String nombreLot)
	{
		nombre_Lote_Proyecto = nombreLot;
	}

	public void setNum_Linea(int numLinea)
	{
		num_Linea = numLinea;
	}



	public String getUsuario_Facultado()
	{
		return usr_Facultado;
	}

	public String getSucursal()
	{
		return this.sucursal;
	}

	public boolean completa()
	{
		return this.completa;
	}

	public String getNombreLote()
	{
		return nombre_Lote_Proyecto;
	}

	public int getNum_Linea()
	{
		return this.num_Linea;
	}

}
//faltan clases???