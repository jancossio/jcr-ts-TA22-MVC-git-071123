package models;

public class Asignado_A {

	private String dni;
	private String id;

	public Asignado_A() {
		this.dni = "";
		this.id = "";
	}
	
	public Asignado_A(String dni, String id) {
		this.dni = dni;
		this.id = id;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
}
