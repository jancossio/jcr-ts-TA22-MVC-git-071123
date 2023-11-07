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

public class MainMenuAsignado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller controller;
	
	private JLabel titulo;
	private JButton insertProyecto;
	private JButton searchProyecto;
	private JButton deleteProyecto;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton backButton;
	

	/**
	 * Create the frame.
	 */
	public MainMenuAsignado() {
		setTitle("Gestor de asignaciones Cientifico-Proyecto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 450);
		contentPane = new JPanel();
		
				
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titulo = new JLabel("Base de datos: asignacion");
		titulo.setBounds(147, 6, 159, 24);
		contentPane.add(titulo);
		
		insertProyecto = new JButton("Agregar asignacion");
		insertProyecto.setBounds(5, 162, 137, 43);
		contentPane.add(insertProyecto);
		
		searchProyecto = new JButton("Consultar asignacion");
		searchProyecto.setBounds(5, 72, 137, 43);
		contentPane.add(searchProyecto);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(147, 41, 567, 359);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DNI", "ID"
			}
		));
			scrollPane.setViewportView(table);
		
		deleteProyecto = new JButton("Borrar asignacion");
		deleteProyecto.setBounds(5, 257, 137, 43);
		contentPane.add(deleteProyecto);
		
		backButton = new JButton("Volver");
		backButton.setBounds(10, 377, 89, 23);
		contentPane.add(backButton);
	}

	public JButton getInsertAsignado() {
		return insertProyecto;
	}

	public void setInsertAsignado(JButton insertProyecto) {
		this.insertProyecto = insertProyecto;
	}

	public JButton getSearchAsignado() {
		return searchProyecto;
	}

	public void setSearchProyecto(JButton searchProyecto) {
		this.searchProyecto = searchProyecto;
	}

	public JButton getDeleteAsignado() {
		return deleteProyecto;
	}

	public void setDeleteAsignado(JButton deleteProyecto) {
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
		controller.fillTableAsignado();
	}
}
