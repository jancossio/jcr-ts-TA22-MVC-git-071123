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

public class MainMenuCientifico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller controller;
	
	private JLabel titulo;
	private JButton insertCientifico;
	private JButton searchCientifico;
	private JButton updateCientifico;
	private JButton deleteCientifico;
	private JButton searchAllCientificos;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton backButton;
	

	/**
	 * Create the frame.
	 */
	public MainMenuCientifico() {
		setTitle("Gestor de clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 450);
		contentPane = new JPanel();
		
				
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titulo = new JLabel("Base de datos: cientificos");
		titulo.setBounds(147, 6, 166, 24);
		contentPane.add(titulo);
		
		insertCientifico = new JButton("Agregar cientifico");
		insertCientifico.setBounds(5, 149, 137, 43);
		contentPane.add(insertCientifico);
		
		searchCientifico = new JButton("Consultar cientifco");
		searchCientifico.setBounds(5, 95, 137, 43);
		contentPane.add(searchCientifico);
		
		updateCientifico = new JButton("Actualizar cientifico");
		updateCientifico.setBounds(5, 203, 137, 43);
		contentPane.add(updateCientifico);
		
		searchAllCientificos = new JButton("Consultar cientificos");
		searchAllCientificos.setBounds(5, 41, 137, 43);
		contentPane.add(searchAllCientificos);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(147, 41, 567, 359);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DNI", "NomApels"
			}
		));
			scrollPane.setViewportView(table);
		
		deleteCientifico = new JButton("Borrar cientifico");
		deleteCientifico.setBounds(5, 257, 137, 43);
		contentPane.add(deleteCientifico);
		
		backButton = new JButton("Volver");
		backButton.setBounds(10, 377, 89, 23);
		contentPane.add(backButton);
	}
	

	public JButton getInsertCientifico() {
		return insertCientifico;
	}

	public void setInsertCientifico(JButton insertCientifico) {
		this.insertCientifico = insertCientifico;
	}

	public JButton getSearchCientifico() {
		return searchCientifico;
	}

	public void setSearchCientifico(JButton searchCientifico) {
		this.searchCientifico = searchCientifico;
	}

	public JButton getUpdateCientifico() {
		return updateCientifico;
	}

	public void setUpdateCientifico(JButton updateCientifico) {
		this.updateCientifico = updateCientifico;
	}



	public JButton getDeleteCientifico() {
		return deleteCientifico;
	}

	public void setDeleteCientifico(JButton deleteCientifico) {
		this.deleteCientifico = deleteCientifico;
	}

	public JButton getSearchAllCientificos() {
		return searchAllCientificos;
	}

	public void setSearchAllCientificos(JButton searchAllCientificos) {
		this.searchAllCientificos = searchAllCientificos;
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
		controller.fillTableCientifico();
	}

}
