package views;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlers.Controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateMenuCientifico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller controller;
	private JTextField textFieldNomApel;
	private JTextField textFieldDNI;

	private JButton cancelButton;
	private JButton confirmButton;
	private JLabel lblTitulo;
	private JLabel lblApell;
	private JLabel lblDni;
	
	private String id;

	/**
	 * Create the frame.
	 */
	public UpdateMenuCientifico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cancelButton.setBounds(10, 200, 89, 23);
		contentPane.add(cancelButton);
		
		confirmButton = new JButton("Confirmar");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		confirmButton.setBounds(328, 200, 96, 23);
		contentPane.add(confirmButton);
		
		lblTitulo = new JLabel("Modifica los parametros que desees modificar del cientifico:");
		lblTitulo.setBounds(51, 11, 322, 23);
		contentPane.add(lblTitulo);
		
		textFieldNomApel = new JTextField();
		textFieldNomApel.setColumns(10);
		textFieldNomApel.setBounds(133, 123, 226, 23);
		contentPane.add(textFieldNomApel);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setColumns(10);
		textFieldDNI.setBounds(133, 59, 226, 23);
		contentPane.add(textFieldDNI);
		
		lblApell = new JLabel("NomApel:");
		lblApell.setBounds(73, 123, 50, 23);
		contentPane.add(lblApell);
		
		lblDni = new JLabel("DNI:");
		lblDni.setBounds(73, 59, 46, 23);
		contentPane.add(lblDni);
		
	}
	

	public JTextField getTextFieldNomApel() {
		return textFieldNomApel;
	}

	public void setTextFieldNomApel(JTextField textFieldNomApel) {
		this.textFieldNomApel = textFieldNomApel;
	}

	public JTextField getTextFieldDNI() {
		return textFieldDNI;
	}

	public void setTextFieldDNI(JTextField textFieldDNI) {
		this.textFieldDNI = textFieldDNI;
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
