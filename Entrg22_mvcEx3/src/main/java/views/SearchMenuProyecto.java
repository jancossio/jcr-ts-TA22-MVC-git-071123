package views;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlers.Controller;

public class SearchMenuProyecto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller controller;
	private JButton cancelButton;
	private JLabel lblNewLabel;
	private JButton confirmButton;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public SearchMenuProyecto() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cancelButton = new JButton("Cancelar");
		cancelButton.setBounds(10, 227, 89, 23);
		//cancelButton.addActionListener(CloseWindow);
		contentPane.add(cancelButton);
		
		lblNewLabel = new JLabel("Introduce el ID del proyecto que busques:");
		lblNewLabel.setBounds(156, 11, 240, 23);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(123, 55, 191, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		confirmButton = new JButton("Buscar");
		confirmButton.setBounds(315, 55, 81, 23);
		contentPane.add(confirmButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 114, 527, 60);
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
	}
	
	
	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public JButton getConfirmButton() {
		return confirmButton;
	}

	public void setConfirmButton(JButton confirmButton) {
		this.confirmButton = confirmButton;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
}
