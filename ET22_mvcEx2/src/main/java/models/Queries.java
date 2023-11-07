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

	static String nameDB = "mvc_Ej2";
		
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
	
	public static boolean insertClientData(Cliente cli) {
			
			try {	
				String Querydb = "USE "+nameDB+";";
				Statement stdb = conexion.createStatement();
				stdb.executeUpdate(Querydb);
				
				PreparedStatement ps = null;
				String ins1 = "INSERT INTO cliente(nombre, apellido, direccion, dni, fecha) VALUES(?, ?, ?, ?, ?)";
				ps = conexion.prepareStatement(ins1);
				//ps.setInt(1, cli.getId());
				ps.setString(1, cli.getNombre());
				ps.setString(2, cli.getApellido());
				ps.setString(3, cli.getDireccion());
				ps.setInt(4, cli.getDni());
				ps.setString(5, cli.getFecha());
				ps.execute();
				
				System.out.println("Tabla rellenada con exito");
				return true;
			}catch(SQLException ex) {
				//Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
				System.out.println("Error al rellenar la tabla: "+ex);
				return false;
			}
	}
	
	public static ArrayList<Cliente> selectAllClientsData() {
		
		Cliente cli;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		try {
			String Querydb = "USE "+nameDB+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String selectAll = "SELECT * FROM cliente;";
			
			PreparedStatement ps = conexion.prepareStatement(selectAll);
			ResultSet rs = ps.executeQuery();
				
			while(rs.next()) {
				cli = new Cliente();
				cli.setId(rs.getInt("id"));
				cli.setNombre(rs.getString("nombre"));
				cli.setApellido( rs.getString("apellido"));
				cli.setDireccion( rs.getString("direccion"));
				cli.setDni(rs.getInt("dni"));
				cli.setFecha(rs.getString("fecha"));
				clientes.add(cli);
				}
			System.out.println("Tabla consultada con exito");
		}catch(SQLException ex) {
			//Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Error al consultar la tabla: "+ex);
		}
		
		return clientes;
	}
	
	public static Cliente selectClientData(int id) {
		Cliente cli = new Cliente();
		
		try {
			String Querydb = "USE "+nameDB+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String slc1 = "SELECT * FROM cliente WHERE id = ?";
			
			PreparedStatement ps = conexion.prepareStatement(slc1);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				cli.setId(rs.getInt("id"));
				cli.setNombre(rs.getString("nombre"));
				cli.setApellido(rs.getString("apellido"));
				cli.setDireccion(rs.getString("direccion"));
				cli.setDni(rs.getInt("dni"));
				cli.setFecha(rs.getString("fecha"));
				System.out.println("Tabla consultada con exito");
				return cli;
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
	
	public static boolean updateClientData(int identifier, Cliente cliente) {
		try {
			String Querydb = "USE "+nameDB+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String upd1 = "UPDATE cliente SET nombre=?, apellido=?, direccion=?, dni=?, fecha=? WHERE id = ?;";
			
			PreparedStatement prepStat = conexion.prepareStatement(upd1);
			prepStat.setString(1, cliente.getNombre());
			prepStat.setString(2,  cliente.getApellido());
			prepStat.setString(3,  cliente.getDireccion());
			prepStat.setInt(4,  cliente.getDni());
			prepStat.setString(5,  cliente.getFecha());
			prepStat.setInt(6,  cliente.getId());

			prepStat.execute();
			
			System.out.println("El usuario ha sido actualizado!");
			return true;
		}catch(SQLException ex) {
			//Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Error al actualizar la tabla "+ex);
			return false;
		}
	}
	
	public static boolean deleteClientData(int identifier) {
		try {
			String Querydb = "USE "+nameDB+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String dlt1 = "DELETE FROM cliente WHERE id = ?;";
			
			PreparedStatement prepStat = conexion.prepareStatement(dlt1);
			prepStat.setInt(1, identifier);
			prepStat.execute();
			
			System.out.println("Registro borrado con exito");
			return true;
		}catch(SQLException ex) {
			//Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Error al borrar la tabla");
			return false;
		}
	}
	
	
	public static boolean insertVideoData(Videos vid) {
		
		try {	
			String Querydb = "USE "+nameDB+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			PreparedStatement ps = null;
			String ins1 = "INSERT INTO videos(title, director, cli_id) VALUES(?, ?, ?)";
			ps = conexion.prepareStatement(ins1);
			//ps.setInt(1, cli.getId());
			ps.setString(1, vid.getTitle());
			ps.setString(2, vid.getDirector());
			ps.setInt(3, vid.getIdCliente());
			ps.execute();
			
			System.out.println("Tabla rellenada con exito");
			return true;
		}catch(SQLException ex) {
			//Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Error al rellenar la tabla: "+ex);
			return false;
		}
	}

	
	public static ArrayList<Videos> selectAllVideoData() {
	
		Videos vid;
		ArrayList<Videos> vids = new ArrayList<Videos>();
	
		try {
			String Querydb = "USE "+nameDB+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
		
			String selectAll = "SELECT * FROM videos;";
		
			PreparedStatement ps = conexion.prepareStatement(selectAll);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				vid = new Videos();
				vid.setId(rs.getInt("id"));
				vid.setTitle(rs.getString("title"));
				vid.setDirector(rs.getString("director"));
				vid.setIdCliente(rs.getInt("cli_id"));
				vids.add(vid);
				}
			System.out.println("Tabla consultada con exito");
		}catch(SQLException ex) {
			//Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Error al consultar la tabla: "+ex);
		}
		return vids;
	}

	public static Videos selectVideoData(int id) {
		Videos vid = new Videos();
	
		try {
			String Querydb = "USE "+nameDB+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
		
			String slc2 = "SELECT * FROM videos WHERE id = ?";
		
			PreparedStatement ps = conexion.prepareStatement(slc2);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
		
			if(rs.next()) {
				vid.setId(rs.getInt("id"));
				vid.setTitle(rs.getString("title"));
				vid.setDirector(rs.getString("director"));
				vid.setIdCliente(rs.getInt("cli_id"));
				System.out.println("Tabla consultada con exito");
				return vid;
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

	public static boolean updateVideoData(int identifier, Videos video) {
		try {
			String Querydb = "USE "+nameDB+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
		
			String upd2 = "UPDATE videos SET title=?, director=?, cli_id=? WHERE id = ?;";
		
			PreparedStatement prepStat = conexion.prepareStatement(upd2);
			prepStat.setString(1, video.getTitle());
			prepStat.setString(2,  video.getDirector());
			prepStat.setInt(3,  video.getIdCliente());
			prepStat.setInt(4,  video.getId());

			prepStat.execute();
		
			System.out.println("El video ha sido actualizado!");
			return true;
		}catch(SQLException ex) {
		//Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("Error al actualizar la tabla "+ex);
			return false;
		}
	}

	public static boolean deleteVideoData(int identifier) {
		try {
			String Querydb = "USE "+nameDB+";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
		
			String dlt2 = "DELETE FROM videos WHERE id = ?;";
		
			PreparedStatement prepStat = conexion.prepareStatement(dlt2);
			prepStat.setInt(1, identifier);
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
