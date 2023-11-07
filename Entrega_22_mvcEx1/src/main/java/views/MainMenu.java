package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controllers.Controller;
import models.Cliente;

public class MainMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller controller;
	
	/*private JPanel consultMenu;
	private JPanel insertMenu;
	private JPanel updateMenu;
	private JPanel deleteMenu;*/

	
	private JLabel titulo;
	private JButton insertClient;
	private JButton searchClient;
	private JButton updateClients;
	private JButton deleteClient;
	private JButton searchAllClients;
	private JScrollPane scrollPane;
	private JTable table;
	

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setTitle("Gestor de clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 450);
		contentPane = new JPanel();
		
				
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titulo = new JLabel("Base de datos: clientes");
		titulo.setBounds(147, 6, 142, 24);
		contentPane.add(titulo);
		
		insertClient = new JButton("Agregar cliente");
		insertClient.setBounds(5, 199, 137, 43);
		contentPane.add(insertClient);
		
		searchClient = new JButton("Consultar cliente");
		searchClient.setBounds(5, 120, 137, 43);
		contentPane.add(searchClient);
		
		updateClients = new JButton("Actualizar cliente");
		updateClients.setBounds(5, 278, 137, 43);
		contentPane.add(updateClients);
		
		searchAllClients = new JButton("Consultar clientes");
		searchAllClients.setBounds(5, 41, 137, 43);
		//searchAllClients.addActionListener(actionShowAllStudents);
		contentPane.add(searchAllClients);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(147, 41, 567, 359);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Nombre", "Apellidos", "Direccion", "DNI", "Fecha"
				}
			));
			scrollPane.setViewportView(table);
		
		deleteClient = new JButton("Borrar cliente");
		deleteClient.setBounds(5, 357, 137, 43);
		contentPane.add(deleteClient);
	}
	
	public JButton getInsertClient() {
		return insertClient;
	}
	
	public void setInsertClient(JButton insertClient) {
		this.insertClient = insertClient;
	}
	
	public JButton getSearchClient() {
		return searchClient;
	}
	
	public void setSearchClient(JButton searchClient) {
		this.searchClient = searchClient;
	}
	
	public JButton getUpdateClients() {
		return updateClients;
	}
	
	public void setUpdateClients(JButton updateClients) {
		this.updateClients = updateClients;
	}
	
	public JButton getDeleteClient() {
		return deleteClient;
	}
	
	public void setDeleteClient(JButton deleteClient) {
		this.deleteClient = deleteClient;
	}
	
	public JButton getSearchAllClients() {
		return searchAllClients;
	}
	
	public void setSearchAllClients(JButton searchAllClients) {
		this.searchAllClients = searchAllClients;
	}
	
	public JTable getTable() {
		return table;
	}
	
	public void setTable(JTable table) {
		this.table = table;
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
		controller.fillTable();
	}
}
