package models;

public class Cientifico {

	private String dni;
	private String nomApels;
	
	
	public Cientifico() {
		dni = "";
		nomApels = "";
	}


	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNomApels() {
		return nomApels;
	}

	public void setNomApels(String nomApels) {
		this.nomApels = nomApels;
	}
}
