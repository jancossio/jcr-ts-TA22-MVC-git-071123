package views;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlers.Controller;

public class InsertMenuClient extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller controller;
	private JTextField nombTextField_1;
	private JTextField apelTextField_2;
	private JTextField dirTextField_3;
	private JTextField dniTextField_4;
	private JTextField fechTextField_5;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDireccion;
	private JLabel lblDni;
	private JLabel lblFecha;
	private JButton btnConfirmar;
	private JLabel lblOrder;
	private JButton cancelButton;
	

	/**
	 * Create the frame.
	 */
	public InsertMenuClient() {
		setTitle("Insertar cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nombTextField_1 = new JTextField();
		nombTextField_1.setColumns(10);
		nombTextField_1.setBounds(75, 57, 210, 20);
		contentPane.add(nombTextField_1);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 56, 63, 23);
		contentPane.add(lblNombre);
		
		apelTextField_2 = new JTextField();
		apelTextField_2.setColumns(10);
		apelTextField_2.setBounds(75, 89, 210, 20);
		contentPane.add(apelTextField_2);
		
		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(10, 88, 63, 23);
		contentPane.add(lblApellido);
		
		dirTextField_3 = new JTextField();
		dirTextField_3.setColumns(10);
		dirTextField_3.setBounds(75, 121, 210, 20);
		contentPane.add(dirTextField_3);
		
		lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(10, 120, 63, 23);
		contentPane.add(lblDireccion);
		
		lblDni = new JLabel("DNI:");
		lblDni.setBounds(10, 152, 46, 23);
		contentPane.add(lblDni);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(10, 184, 46, 23);
		contentPane.add(lblFecha);
		
		dniTextField_4 = new JTextField();
		dniTextField_4.setColumns(10);
		dniTextField_4.setBounds(75, 153, 210, 20);
		contentPane.add(dniTextField_4);
		
		fechTextField_5 = new JTextField();
		fechTextField_5.setColumns(10);
		fechTextField_5.setBounds(75, 185, 210, 20);
		contentPane.add(fechTextField_5);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(202, 246, 111, 23);
		//btnConfirmar.addActionListener(ConfirmInsert);
		contentPane.add(btnConfirmar);
		
		lblOrder = new JLabel("Introduce los parametros del nuevo cliente:");
		lblOrder.setBounds(52, 11, 219, 23);
		contentPane.add(lblOrder);
		
		cancelButton = new JButton("Cancelar");
		cancelButton.setBounds(10, 246, 89, 23);
		//cancelButton.addActionListener(CloseWindow);
		contentPane.add(cancelButton);
		
	}
	
	
	public JTextField getNombTextField_1() {
		return nombTextField_1;
	}

	public void setNombTextField_1(JTextField nombTextField_1) {
		this.nombTextField_1 = nombTextField_1;
	}

	public JTextField getApelTextField_2() {
		return apelTextField_2;
	}

	public void setApelTextField_2(JTextField apelTextField_2) {
		this.apelTextField_2 = apelTextField_2;
	}

	public JTextField getDirTextField_3() {
		return dirTextField_3;
	}

	public void setDirTextField_3(JTextField dirTextField_3) {
		this.dirTextField_3 = dirTextField_3;
	}

	public JTextField getDniTextField_4() {
		return dniTextField_4;
	}

	public void setDniTextField_4(JTextField dniTextField_4) {
		this.dniTextField_4 = dniTextField_4;
	}

	public JTextField getFechTextField_5() {
		return fechTextField_5;
	}

	public void setFechTextField_5(JTextField fechTextField_5) {
		this.fechTextField_5 = fechTextField_5;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}



	public void setBtnConfirmar(JButton btnConfirmar) {
		this.btnConfirmar = btnConfirmar;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}
}
