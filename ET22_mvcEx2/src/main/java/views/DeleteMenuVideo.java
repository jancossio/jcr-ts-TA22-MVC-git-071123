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

public class DeleteMenuVideo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller controller;
	private JLabel lblID;
	private JButton cancelButton;
	private JLabel lblQuestion;
	private JButton confirmButton;
	private JTable table;
	private JScrollPane scrollPane;
	
	private String id="";

	
	/**
	 * Create the frame.
	 */
	public DeleteMenuVideo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cancelButton = new JButton("Cancelar");
		cancelButton.setBounds(10, 227, 89, 23);
		//cancelButton.addActionListener(CloseWindow);
		contentPane.add(cancelButton);
		
		lblQuestion = new JLabel("Desea borrar el registro? ");
		lblQuestion.setBounds(150, 34, 150, 23);
		contentPane.add(lblQuestion);
		
		confirmButton = new JButton("Confirmar");
		confirmButton.setBounds(319, 227, 105, 23);
		//confirmButton.addActionListener(ConfirmDelete);
		contentPane.add(confirmButton);
		
		lblID = new JLabel("");
		lblID.setBounds(298, 34, 64, 23);
		contentPane.add(lblID);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 414, 60);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Titulo", "Director", "ID_Cliente"
			}
		));
		scrollPane.setViewportView(table);
	}
	
	
	public JLabel getLblID() {
		return lblID;
	}

	public void setLblID(JLabel lblID) {
		this.lblID = lblID;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
}
