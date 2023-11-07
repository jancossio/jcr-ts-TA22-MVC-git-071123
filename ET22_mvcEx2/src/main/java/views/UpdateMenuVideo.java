package views;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlers.Controller;

public class UpdateMenuVideo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller controller;
	private JTextField textFieldTitulo;
	private JTextField textFieldDirector;
	private JTextField textFieldIDCliente;

	private JButton cancelButton;
	private JButton confirmButton;
	private JLabel lblTitulo;
	private JLabel lblNombre;
	private JLabel lblApell;
	private JLabel lblDirection;
	private JLabel lblId;
	
	private String id;

	/**
	 * Create the frame.
	 */
	public UpdateMenuVideo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cancelButton = new JButton("Cancelar");
		cancelButton.setBounds(10, 239, 89, 23);
		contentPane.add(cancelButton);
		
		confirmButton = new JButton("Confirmar");
		confirmButton.setBounds(328, 239, 96, 23);
		contentPane.add(confirmButton);
		
		lblTitulo = new JLabel("Modifica los parametros que desees modificar del video:");
		lblTitulo.setBounds(80, 11, 308, 23);
		contentPane.add(lblTitulo);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(133, 57, 226, 23);
		textFieldTitulo.setColumns(10);
		contentPane.add(textFieldTitulo);
		
		textFieldDirector = new JTextField();
		textFieldDirector.setColumns(10);
		textFieldDirector.setBounds(133, 114, 226, 23);
		contentPane.add(textFieldDirector);
		
		textFieldIDCliente = new JTextField();
		textFieldIDCliente.setColumns(10);
		textFieldIDCliente.setBounds(133, 171, 226, 23);
		contentPane.add(textFieldIDCliente);
		
		lblNombre = new JLabel("Título:");
		lblNombre.setBounds(73, 57, 59, 23);
		contentPane.add(lblNombre);
		
		lblApell = new JLabel("Director:");
		lblApell.setBounds(73, 114, 50, 23);
		contentPane.add(lblApell);
		
		lblDirection = new JLabel("ID_Cliente:");
		lblDirection.setBounds(73, 171, 59, 23);
		contentPane.add(lblDirection);
		
		lblId = new JLabel("");
		lblId.setBounds(328, 11, 67, 23);
		contentPane.add(lblId);
		
	}
	
	
	public JTextField getTextFieldTitulo() {
		return textFieldTitulo;
	}

	public void setTextFieldTitulo(JTextField textFieldNomb) {
		this.textFieldTitulo = textFieldNomb;
	}

	public JTextField getTextFieldDirector() {
		return textFieldDirector;
	}

	public void setTextFieldDirector(JTextField textFieldApel) {
		this.textFieldDirector = textFieldApel;
	}

	public JTextField getTextFieldIDCliente() {
		return textFieldIDCliente;
	}

	public void setTextFieldIDCliente(JTextField textFieldDir) {
		this.textFieldIDCliente = textFieldDir;
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
