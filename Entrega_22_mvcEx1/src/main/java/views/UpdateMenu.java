package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controllers.Controller;
import models.Cliente;

public class UpdateMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller controller;
	private JTextField textFieldNomb;
	private JTextField textFieldApel;
	private JTextField textFieldDir;
	private JTextField textFieldDNI;
	private JTextField textFieldFech;

	private JButton cancelButton;
	private JButton confirmButton;
	private JLabel lblTitulo;
	private JLabel lblNombre;
	private JLabel lblApell;
	private JLabel lblDirection;
	private JLabel lblDni;
	private JLabel lblFecha;
	private JLabel lblId;
	
	private String id;

	/**
	 * Create the frame.
	 */
	public UpdateMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cancelButton = new JButton("Cancelar");
		cancelButton.setBounds(10, 293, 89, 23);
		contentPane.add(cancelButton);
		
		confirmButton = new JButton("Confirmar");
		confirmButton.setBounds(328, 293, 96, 23);
		contentPane.add(confirmButton);
		
		lblTitulo = new JLabel("Modifica los parametros que desees modificar del cliente:");
		lblTitulo.setBounds(51, 11, 308, 23);
		contentPane.add(lblTitulo);
		
		textFieldNomb = new JTextField();
		textFieldNomb.setBounds(133, 57, 226, 23);
		textFieldNomb.setColumns(10);
		contentPane.add(textFieldNomb);
		
		textFieldApel = new JTextField();
		textFieldApel.setColumns(10);
		textFieldApel.setBounds(133, 100, 226, 23);
		contentPane.add(textFieldApel);
		
		textFieldDir = new JTextField();
		textFieldDir.setColumns(10);
		textFieldDir.setBounds(133, 146, 226, 23);
		contentPane.add(textFieldDir);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setColumns(10);
		textFieldDNI.setBounds(133, 195, 226, 23);
		contentPane.add(textFieldDNI);
		
		textFieldFech = new JTextField();
		textFieldFech.setColumns(10);
		textFieldFech.setBounds(133, 245, 226, 23);
		contentPane.add(textFieldFech);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(73, 57, 59, 23);
		contentPane.add(lblNombre);
		
		lblApell = new JLabel("Apellido:");
		lblApell.setBounds(73, 100, 50, 23);
		contentPane.add(lblApell);
		
		lblDirection = new JLabel("Direccion:");
		lblDirection.setBounds(73, 146, 59, 23);
		contentPane.add(lblDirection);
		
		lblDni = new JLabel("DNI:");
		lblDni.setBounds(73, 195, 46, 23);
		contentPane.add(lblDni);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(73, 245, 46, 23);
		contentPane.add(lblFecha);
		
		lblId = new JLabel("");
		lblId.setBounds(328, 11, 67, 23);
		contentPane.add(lblId);
		
		setController(controller);
	}
	
	
	public JTextField getTextFieldNomb() {
		return textFieldNomb;
	}

	public void setTextFieldNomb(JTextField textFieldNomb) {
		this.textFieldNomb = textFieldNomb;
	}

	public JTextField getTextFieldApel() {
		return textFieldApel;
	}

	public void setTextFieldApel(JTextField textFieldApel) {
		this.textFieldApel = textFieldApel;
	}

	public JTextField getTextFieldDir() {
		return textFieldDir;
	}

	public void setTextFieldDir(JTextField textFieldDir) {
		this.textFieldDir = textFieldDir;
	}

	public JTextField getTextFieldDNI() {
		return textFieldDNI;
	}

	public void setTextFieldDNI(JTextField textFieldDNI) {
		this.textFieldDNI = textFieldDNI;
	}

	public JTextField getTextFieldFech() {
		return textFieldFech;
	}

	public void setTextFieldFech(JTextField textFieldFech) {
		this.textFieldFech = textFieldFech;
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
