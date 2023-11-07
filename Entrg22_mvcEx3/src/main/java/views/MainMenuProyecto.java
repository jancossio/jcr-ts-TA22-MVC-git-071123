package views;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlers.Controller;

public class MainMenuProyecto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller controller;
	
	private JLabel titulo;
	private JButton insertProyecto;
	private JButton searchProyecto;
	private JButton updateProyecto;
	private JButton deleteProyecto;
	private JButton searchAllProyectos;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton backButton;
	

	/**
	 * Create the frame.
	 */
	public MainMenuProyecto() {
		setTitle("Gestor de videos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 450);
		contentPane = new JPanel();
		
				
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titulo = new JLabel("Base de datos: proyectos");
		titulo.setBounds(147, 6, 159, 24);
		contentPane.add(titulo);
		
		insertProyecto = new JButton("Agregar proyecto");
		insertProyecto.setBounds(5, 149, 137, 43);
		contentPane.add(insertProyecto);
		
		searchProyecto = new JButton("Consultar proyecto");
		searchProyecto.setBounds(5, 95, 137, 43);
		contentPane.add(searchProyecto);
		
		updateProyecto = new JButton("Actualizar proyecto");
		updateProyecto.setBounds(5, 203, 137, 43);
		contentPane.add(updateProyecto);
		
		searchAllProyectos = new JButton("Consultar proyectos");
		searchAllProyectos.setBounds(5, 41, 137, 43);
		//searchAllClients.addActionListener(actionShowAllStudents);
		contentPane.add(searchAllProyectos);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(147, 41, 567, 359);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre", "Horas"
			}
		));
			scrollPane.setViewportView(table);
		
		deleteProyecto = new JButton("Borrar proyecto");
		deleteProyecto.setBounds(5, 257, 137, 43);
		contentPane.add(deleteProyecto);
		
		backButton = new JButton("Volver");
		backButton.setBounds(10, 377, 89, 23);
		contentPane.add(backButton);
	}
	
	
	public JButton getSearchAllProyectos() {
		return searchAllProyectos;
	}

	public void setSearchAllProyectos(JButton searchAllProyectos) {
		this.searchAllProyectos = searchAllProyectos;
	}

	public JButton getInsertProyecto() {
		return insertProyecto;
	}

	public void setInsertProyecto(JButton insertProyecto) {
		this.insertProyecto = insertProyecto;
	}

	public JButton getSearchProyecto() {
		return searchProyecto;
	}

	public void setSearchProyecto(JButton searchProyecto) {
		this.searchProyecto = searchProyecto;
	}

	public JButton getUpdateProyecto() {
		return updateProyecto;
	}

	public void setUpdateProyecto(JButton updateProyecto) {
		this.updateProyecto = updateProyecto;
	}

	public JButton getDeleteProyecto() {
		return deleteProyecto;
	}

	public void setDeleteProyecto(JButton deleteProyecto) {
		this.deleteProyecto = deleteProyecto;
	}

	public JTable getTable() {
		return table;
	}
	
	public void setTable(JTable table) {
		this.table = table;
	}
	
	public JButton getBackButton() {
		return backButton;
	}
	
	public void setBackButton(JButton backButton) {
		this.backButton = backButton;
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
		controller.fillTableProyecto();
	}
}
