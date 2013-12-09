package muebleria;

public class Mueble {

	int Id_Mueble;
	int Num_Serie;
	int Num_Etiqueta_SIAFF;
//	int almacen: ArrayList<object>(int-str) set y get no se como hacerlo :(
	String Descripcion;
	int Modelo;
	int Num_ATM;
	int Tipo_Carpa_ATM;
	String Proveedor;
	int Precio_Unitario;
	String Empresa_Responsable;

//	private void gen_Id_Mueble();


//	public void settersGetters(){

	void setId_Mueble(int id_Mueble){
		this.Id_Mueble = id_Mueble;
	}		

	int getId_Mueble(){
		return this.Id_Mueble;
	}

	//
	void setNum_Serie(int num_Serie){
		this.Num_Serie = num_Serie;
	}		

	int getNum_Serie(){
		return this.Num_Serie;
	}

	//
	void setNum_Etiqueta_SIAFF(int num_Etiqueta_SIAFF){
		this.Num_Etiqueta_SIAFF = num_Etiqueta_SIAFF;
	}		

	int getNum_Etiqueta_SIAFF(){
		return this.Num_Etiqueta_SIAFF;
	}

	//
	void setDescripcion(String descripcion){
		this.Descripcion = descripcion;
	}		

	String getDescripcion(){
		return this.Descripcion;
	}

	//
	void setModelo(int modelo){
		this.Modelo = modelo;
	}		

	int getModelo(){
		return this.Modelo;
	}

	//
	void setNum_ATM(int num_ATM){
		this.Num_ATM = num_ATM;
	}		

	int getNum_ATM(){
		return this.Num_ATM;
	}

	//
	void setTipo_Carpa_ATM(int tipo_Carpa_ATM){
		this.Tipo_Carpa_ATM = tipo_Carpa_ATM;
	}		

	int getTipo_Carpa_ATM(){
		return this.Tipo_Carpa_ATM;
	}

	//
	void setProveedor(String proveedor){
		this.Proveedor = proveedor;
	}		

	String getProveedor(){
		return this.Proveedor;
	}

	//
	void setPrecio_Unitario(int precio_Unitario){
		this.Precio_Unitario = precio_Unitario;
	}		

	int getPrecio_Unitario(){
		return this.Precio_Unitario;
	}

	//
	void setEmpresa_Responsable(String empresa_Responsable){
		this.Empresa_Responsable = empresa_Responsable;
	}		

	String getEmpresa_Responsable(){
		return this.Empresa_Responsable;
	}
//	}
}
