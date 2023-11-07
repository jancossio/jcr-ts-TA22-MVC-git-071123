package views;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlers.Controller;

public class InsertMenuProyecto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller controller;
	private JTextField idTextField;
	private JTextField nombreTextField;
	private JTextField horasCliTextField;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDireccion;
	private JButton btnConfirmar;
	private JLabel lblOrder;
	private JButton cancelButton;
	

	/**
	 * Create the frame.
	 */
	public InsertMenuProyecto() {
		setTitle("Insertar cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		idTextField = new JTextField();
		idTextField.setColumns(10);
		idTextField.setBounds(75, 57, 210, 20);
		contentPane.add(idTextField);
		
		lblNombre = new JLabel("ID");
		lblNombre.setBounds(10, 56, 63, 23);
		contentPane.add(lblNombre);
		
		nombreTextField = new JTextField();
		nombreTextField.setColumns(10);
		nombreTextField.setBounds(75, 98, 210, 20);
		contentPane.add(nombreTextField);
		
		lblApellido = new JLabel("Nombre:");
		lblApellido.setBounds(10, 97, 63, 23);
		contentPane.add(lblApellido);
		
		horasCliTextField = new JTextField();
		horasCliTextField.setColumns(10);
		horasCliTextField.setBounds(75, 143, 210, 20);
		contentPane.add(horasCliTextField);
		
		lblDireccion = new JLabel("Horas:");
		lblDireccion.setBounds(10, 142, 63, 23);
		contentPane.add(lblDireccion);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(202, 212, 111, 23);
		//btnConfirmar.addActionListener(ConfirmInsert);
		contentPane.add(btnConfirmar);
		
		lblOrder = new JLabel("Introduce los parametros del nuevo proyecto");
		lblOrder.setBounds(52, 11, 219, 23);
		contentPane.add(lblOrder);
		
		cancelButton = new JButton("Cancelar");
		cancelButton.setBounds(10, 212, 89, 23);
		//cancelButton.addActionListener(CloseWindow);
		contentPane.add(cancelButton);
		
	}
	

	public JTextField getIdTextField() {
		return idTextField;
	}

	public void setIdTextField(JTextField idTextField) {
		this.idTextField = idTextField;
	}

	public JTextField getNombreTextField() {
		return nombreTextField;
	}

	public void setNombreTextField(JTextField nombreTextField) {
		this.nombreTextField = nombreTextField;
	}

	public JTextField getHorasTextField() {
		return horasCliTextField;
	}

	public void setHorasTextField(JTextField horasCliTextField) {
		this.horasCliTextField = horasCliTextField;
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
