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

public class SearchMenuAsignado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller controller;
	private JButton cancelButton;
	private JLabel lblNewLabel;
	private JButton confirmButton;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField textFieldDni;
	private JTextField textFieldId;
	
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Create the frame.
	 */
	public SearchMenuAsignado() {
		
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
		
		lblNewLabel = new JLabel("Introduce el ID de la asignacion que busques:");
		lblNewLabel.setBounds(156, 11, 263, 23);
		contentPane.add(lblNewLabel);
		
		textFieldDni = new JTextField();
		textFieldDni.setBounds(77, 55, 134, 23);
		contentPane.add(textFieldDni);
		textFieldDni.setColumns(10);
		
		confirmButton = new JButton("Buscar");
		confirmButton.setBounds(429, 55, 81, 23);
		//confirmButton.addActionListener(ConfirmSearch);
		contentPane.add(confirmButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 114, 527, 60);
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
		
		textFieldId = new JTextField();
		textFieldId.setColumns(10);
		textFieldId.setBounds(285, 55, 134, 23);
		contentPane.add(textFieldId);
		
		lblNewLabel_1 = new JLabel("DNI:");
		lblNewLabel_1.setBounds(31, 55, 46, 23);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setBounds(237, 55, 46, 23);
		contentPane.add(lblNewLabel_2);
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

	public JTextField getTextFieldDni() {
		return textFieldDni;
	}

	public void setTextFieldDni(JTextField textFieldDni) {
		this.textFieldDni = textFieldDni;
	}

	public JTextField getTextFieldId() {
		return textFieldId;
	}

	public void setTextFieldId(JTextField textFieldId) {
		this.textFieldId = textFieldId;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
}
