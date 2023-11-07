package views;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlers.Controller;

public class UpdateMenuProyecto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller controller;
	private JTextField textFieldID;
	private JTextField textFieldNombre;
	private JTextField textFieldHoras;

	private JButton cancelButton;
	private JButton confirmButton;
	private JLabel lblTitulo;
	private JLabel lblApell;
	private JLabel lblDirection;
	private JLabel lblId;
	
	private String id;

	/**
	 * Create the frame.
	 */
	public UpdateMenuProyecto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cancelButton = new JButton("Cancelar");
		cancelButton.setBounds(10, 203, 89, 23);
		contentPane.add(cancelButton);
		
		confirmButton = new JButton("Confirmar");
		confirmButton.setBounds(328, 203, 96, 23);
		contentPane.add(confirmButton);
		
		lblTitulo = new JLabel("Modifica los parametros que desees cambiar del proyecto:");
		lblTitulo.setBounds(80, 11, 315, 23);
		contentPane.add(lblTitulo);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(140, 92, 226, 23);
		contentPane.add(textFieldNombre);
		
		textFieldHoras = new JTextField();
		textFieldHoras.setColumns(10);
		textFieldHoras.setBounds(140, 139, 226, 23);
		contentPane.add(textFieldHoras);
		
		lblApell = new JLabel("Nombre:");
		lblApell.setBounds(80, 92, 50, 23);
		contentPane.add(lblApell);
		
		lblDirection = new JLabel("Horas:");
		lblDirection.setBounds(80, 139, 59, 23);
		contentPane.add(lblDirection);
		
		lblId = new JLabel("");
		lblId.setBounds(328, 11, 67, 23);
		contentPane.add(lblId);
		
		JLabel lblId_1 = new JLabel("ID:");
		lblId_1.setBounds(80, 45, 50, 23);
		contentPane.add(lblId_1);
		
		textFieldID = new JTextField();
		textFieldID.setColumns(10);
		textFieldID.setBounds(140, 45, 226, 23);
		contentPane.add(textFieldID);
		
	}
	
	
	public JTextField getTextFieldID() {
		return textFieldID;
	}

	public void setTextFieldID(JTextField textFieldNomb) {
		this.textFieldID = textFieldNomb;
	}

	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	public void setTextFieldNombre(JTextField textFieldApel) {
		this.textFieldNombre = textFieldApel;
	}

	public JTextField getTextFieldHoras() {
		return textFieldHoras;
	}

	public void setTextFieldHoras(JTextField textFieldDir) {
		this.textFieldHoras = textFieldDir;
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
