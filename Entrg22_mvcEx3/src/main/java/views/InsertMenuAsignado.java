package views;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlers.Controller;

public class InsertMenuAsignado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller controller;
	private JTextField idTextField;
	private JTextField dniTextField;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JButton btnConfirmar;
	private JLabel lblOrder;
	private JButton cancelButton;
	

	/**
	 * Create the frame.
	 */
	public InsertMenuAsignado() {
		setTitle("Insertar cientifico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 253);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		idTextField = new JTextField();
		idTextField.setColumns(10);
		idTextField.setBounds(75, 126, 210, 20);
		contentPane.add(idTextField);
		
		lblApellido = new JLabel("ID:");
		lblApellido.setBounds(28, 125, 37, 23);
		contentPane.add(lblApellido);
		
		lblDni = new JLabel("DNI:");
		lblDni.setBounds(28, 65, 37, 23);
		contentPane.add(lblDni);
		
		dniTextField = new JTextField();
		dniTextField.setColumns(10);
		dniTextField.setBounds(75, 66, 210, 20);
		contentPane.add(dniTextField);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(202, 180, 111, 23);
		//btnConfirmar.addActionListener(ConfirmInsert);
		contentPane.add(btnConfirmar);
		
		lblOrder = new JLabel("Introduce los parametros de la nueva asignacion:");
		lblOrder.setBounds(40, 11, 283, 23);
		contentPane.add(lblOrder);
		
		cancelButton = new JButton("Cancelar");
		cancelButton.setBounds(10, 180, 89, 23);
		//cancelButton.addActionListener(CloseWindow);
		contentPane.add(cancelButton);
		
	}

	
	public JTextField getIdTextField() {
		return idTextField;
	}

	public void setIdTextField(JTextField nomApelTextField) {
		this.idTextField = nomApelTextField;
	}

	public JTextField getDniTextField() {
		return dniTextField;
	}

	public void setDniTextField(JTextField dniTextField) {
		this.dniTextField = dniTextField;
	}

	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public void setBtnConfirmar(JButton btnConfirmar) {
		this.btnConfirmar = btnConfirmar;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
	}
}
