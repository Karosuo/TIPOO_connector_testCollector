package muebleria;

public class Usuario_Facultado {

	int Num_nomina;
	String Nombre;
	String Empresa;
	int Cr_empleado;

	void setNum_nomina(int num_nomina){
		this.Num_nomina = num_nomina;
	}		

	int getNum_nomina(){
		return this.Num_nomina;
	}

	void setNombre(String nombre){
		this.Nombre = nombre;
	}		

	String getNombre(){
		return this.Nombre;
	}

	void setempresa(String empresa){
		this.Empresa = empresa;
	}		

	String getEmpresa(){
		return this.Empresa;
	}

	void setcr_empleado(int cr_empleado){
		this.Cr_empleado = cr_empleado;
	}		

	int getCr_empleado(){
		return this.Cr_empleado;
	}


	//public setteres & getters

}
