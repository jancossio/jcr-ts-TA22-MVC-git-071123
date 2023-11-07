package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Queries {

	static String nameDB = "mvc_Ej3";
	
	private static Connection conexion = mySQLConnection("root","P1gue0N$","");
	
	
	
	public static void closeConnection(Connection Conexion){
		try {
			Conexion.close();
			JOptionPane.showMessageDialog(null, "Se ha cerrado la conexion con el servidor");
		}catch(SQLException ex) {
			//Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static Connection mySQLConnection(String user, String password, String name) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+name, user, password);
			System.out.println("Server connected");
			JOptionPane.showMessageDialog(null, "Se ha creado la conexion con el servidor");
			return conexion;
		}catch(SQLException | ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "No se ha podido establecer la conexion con el servidor");
		}
		return null;
	}
	
	public static boolean insertCientificoData(Cientifico cien) {
			
			try {	
				String Querydb = "USE "+nameDB+";";
				Statement stdb = conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				PreparedStatement ps = null;
				String ins1 = "INSERT INTO cientifico(dni, nomApels) VALUES(?, ?)";
				ps = conexion.prepareStatement(ins1);
				//ps.setInt(1, cli.getId());
				ps.setString(1, cien.getDni());
				ps.setString(2, cien.getNomApels());
				ps.execute();
				
				System.out.println("Tabla rellenada con exito");
				return true;
			}catch(SQLException ex) {
				//Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
				System.out.println("Error al rellenar la tabla: "+ex);
				return false;
			}
	}
	
	public static ArrayList<Cientifico> selectAllCientificoData() {
		
		Cientifico cien;
		ArrayList<Cientifico> cientificos = new ArrayList<Cientifico>();
		
		try {
			String Querydb = "USE "+nameDB+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String selectAll = "SELECT * FROM cliente;";
			
			PreparedStatement ps = conexion.prepareStatement(selectAll);
			ResultSet rs = ps.executeQuery();
				
			while(rs.next()) {
				cien = new Cientifico();
				cien.setDni(selectAll);
				cien.setNomApels(selectAll);
				cientificos.add(cien);
				}
			System.out.println("Tabla consultada con exito");
		}catch(SQLException ex) {
			//Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Error al consultar la tabla: "+ex);
		}
		
		return cientificos;
	}
	
	public static Cientifico selectCientificoData(String dni) {
		Cientifico cien = new Cientifico();
		
		try {
			String Querydb = "USE "+nameDB+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String slc1 = "SELECT * FROM cientifico WHERE id = ?";
			
			PreparedStatement ps = conexion.prepareStatement(slc1);
			ps.setString(1, dni);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				cien.setDni(slc1);
				cien.setNomApels(slc1);
				System.out.println("Tabla consultada con exito");
				return cien;
			}else {
				System.out.println("No se ha encontrado el registro en la tabla");
				return null;
			}
			
		}catch(SQLException ex) {
			//Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Error al consultar la tabla: "+ex);
			return null;
		}
	}
	
	public static boolean updateCientificoData(String dni, Cientifico cien) {
		try {
			String Querydb = "USE "+nameDB+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String upd1 = "UPDATE cientifico SET dni=?, nomApels=? WHERE id = ?;";
			
			PreparedStatement prepStat = conexion.prepareStatement(upd1);
			prepStat.setString(1, cien.getDni());
			prepStat.setString(2,  cien.getNomApels());
			prepStat.setString(3,  dni);

			prepStat.execute();
			
			System.out.println("El usuario ha sido actualizado!");
			return true;
		}catch(SQLException ex) {
			//Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Error al actualizar la tabla "+ex);
			return false;
		}
	}
	
	public static boolean deleteCientificoData(String dni) {
		try {
			String Querydb = "USE "+nameDB+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String dlt1 = "DELETE FROM cientifico WHERE id = ?;";
			
			PreparedStatement prepStat = conexion.prepareStatement(dlt1);
			prepStat.setString(1, dni);
			prepStat.execute();
			
			System.out.println("Registro borrado con exito");
			return true;
		}catch(SQLException ex) {
			//Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Error al borrar la tabla");
			return false;
		}
	}
	
	
	public static boolean insertProyectoData(Proyecto proy) {
		
		try {	
			String Querydb = "USE "+nameDB+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			PreparedStatement ps = null;
			String ins1 = "INSERT INTO proyecto(id, nombre, horas) VALUES(?, ?, ?)";
			ps = conexion.prepareStatement(ins1);
			//ps.setInt(1, cli.getId());
			ps.setString(1, proy.getId());
			ps.setString(2, proy.getNombre());
			ps.setInt(3, proy.getHoras());
			ps.execute();
			
			System.out.println("Tabla rellenada con exito");
			return true;
		}catch(SQLException ex) {
			//Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Error al rellenar la tabla: "+ex);
			return false;
		}
	}

	
	public static ArrayList<Proyecto> selectAllProyectoData() {
	
		Proyecto proy;
		ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
	
		try {
			String Querydb = "USE "+nameDB+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
		
			String selectAll = "SELECT * FROM proyecto;";
		
			PreparedStatement ps = conexion.prepareStatement(selectAll);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				proy = new Proyecto();
				proy.setId(rs.getString("id"));
				proy.setNombre(rs.getString("nombre"));
				proy.setHoras(rs.getInt("horas"));
				proyectos.add(proy);
				}
			System.out.println("Tabla consultada con exito");
		}catch(SQLException ex) {
			//Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Error al consultar la tabla: "+ex);
		}
		return proyectos;
	}

	public static Proyecto selectProyectoData(String id) {
		Proyecto proy = new Proyecto();
	
		try {
			String Querydb = "USE "+nameDB+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
		
			String slc2 = "SELECT * FROM proyecto WHERE id = ?";
		
			PreparedStatement ps = conexion.prepareStatement(slc2);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
		
			if(rs.next()) {
				proy.setId(rs.getString("id"));
				proy.setNombre(rs.getString("nombre"));
				proy.setHoras(rs.getInt("horas"));
				System.out.println("Tabla consultada con exito");
				return proy;
			}else {
				System.out.println("No se ha encontrado el registro en la tabla");
				return null;
			}
		
		}catch(SQLException ex) {
			//Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Error al consultar la tabla: "+ex);
			return null;
		}
	}

	public static boolean updateProyectoData(String id, Proyecto proyecto) {
		try {
			String Querydb = "USE "+nameDB+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
		
			String upd2 = "UPDATE proyecto SET nombre=?, horas=? WHERE id = ?;";
		
			PreparedStatement prepStat = conexion.prepareStatement(upd2);
			prepStat.setString(1, proyecto.getNombre());
			prepStat.setInt(2,  proyecto.getHoras());
			prepStat.setString(3, id);
			prepStat.execute();
		
			System.out.println("El video ha sido actualizado!");
			return true;
		}catch(SQLException ex) {
		//Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Error al actualizar la tabla "+ex);
			return false;
		}
	}

	public static boolean deleteProyectoData(String id) {
		try {
			String Querydb = "USE "+nameDB+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
		
			String dlt2 = "DELETE FROM proyecto WHERE id = ?;";
		
			PreparedStatement prepStat = conexion.prepareStatement(dlt2);
			prepStat.setString(1, id);
			prepStat.execute();
		
			System.out.println("Registro borrado con exito");
			return true;
		}catch(SQLException ex) {
			//Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Error al borrar la tabla");
			return false;
		}
	}
	
	
	public static boolean insertAsignadoAData(Asignado_A asig) {
		
		try {	
			String Querydb = "USE "+nameDB+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			PreparedStatement ps = null;
			String ins1 = "INSERT INTO asignado_a(dni, id) VALUES(?, ?)";
			ps = conexion.prepareStatement(ins1);
			ps.setString(1, asig.getDni());			
			ps.setString(2, asig.getId());
			ps.execute();
			
			System.out.println("Tabla rellenada con exito");
			return true;
		}catch(SQLException ex) {
			//Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Error al rellenar la tabla: "+ex);
			return false;
		}
	}

	
	public static ArrayList<Asignado_A> selectAllAsignadoAData() {
	
		Asignado_A asig;
		ArrayList<Asignado_A> asignados = new ArrayList<Asignado_A>();
	
		try {
			String Querydb = "USE "+nameDB+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
		
			String selectAll = "SELECT * FROM asignado_a;";
		
			PreparedStatement ps = conexion.prepareStatement(selectAll);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				asig = new Asignado_A();
				asig.setDni(rs.getString("dni"));
				asig.setId(rs.getString("id"));
				asignados.add(asig);
				}
			System.out.println("Tabla consultada con exito");
		}catch(SQLException ex) {
			//Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Error al consultar la tabla: "+ex);
		}
		return asignados;
	}

	
	public static Asignado_A selectAsignadoAData(String dni, String id) {
		Asignado_A asig = new Asignado_A();
	
		try {
			String Querydb = "USE "+nameDB+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
		
			String slc2 = "SELECT * FROM asignado_a WHERE dni = ? and id = ?";
		
			PreparedStatement ps = conexion.prepareStatement(slc2);
			ps.setString(1, dni);
			ps.setString(2, id);
			ResultSet rs = ps.executeQuery();
		
			if(rs.next()) {
				asig.setDni(dni);
				asig.setId(rs.getString("id"));
				System.out.println("Tabla consultada con exito");
				return asig;
			}else {
				System.out.println("No se ha encontrado el registro en la tabla");
				return null;
			}
		
		}catch(SQLException ex) {
			//Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Error al consultar la tabla: "+ex);
			return null;
		}
	}
	
	public  boolean deleteAsignadoAData(String dni, String id) {
		try {
			String Querydb = "USE "+nameDB+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
		
			String dlt2 = "DELETE FROM asignado_a WHERE dni = ? and id = ?;";
		
			PreparedStatement prepStat = conexion.prepareStatement(dlt2);
			prepStat.setString(1, dni);
			prepStat.setString(2, id);
			prepStat.execute();
		
			System.out.println("Registro borrado con exito");
			return true;
		}catch(SQLException ex) {
			//Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Error al borrar la tabla");
			return false;
		}
	}
}
