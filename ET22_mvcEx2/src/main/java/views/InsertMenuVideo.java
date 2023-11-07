package views;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlers.Controller;

public class InsertMenuVideo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller controller;
	private JTextField tituloTextField_1;
	private JTextField DirectorTextField_2;
	private JTextField idCliTextField_3;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDireccion;
	private JButton btnConfirmar;
	private JLabel lblOrder;
	private JButton cancelButton;
	

	/**
	 * Create the frame.
	 */
	public InsertMenuVideo() {
		setTitle("Insertar cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 339, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tituloTextField_1 = new JTextField();
		tituloTextField_1.setColumns(10);
		tituloTextField_1.setBounds(75, 57, 210, 20);
		contentPane.add(tituloTextField_1);
		
		lblNombre = new JLabel("Título:");
		lblNombre.setBounds(10, 56, 63, 23);
		contentPane.add(lblNombre);
		
		DirectorTextField_2 = new JTextField();
		DirectorTextField_2.setColumns(10);
		DirectorTextField_2.setBounds(75, 98, 210, 20);
		contentPane.add(DirectorTextField_2);
		
		lblApellido = new JLabel("Director:");
		lblApellido.setBounds(10, 97, 63, 23);
		contentPane.add(lblApellido);
		
		idCliTextField_3 = new JTextField();
		idCliTextField_3.setColumns(10);
		idCliTextField_3.setBounds(75, 143, 210, 20);
		contentPane.add(idCliTextField_3);
		
		lblDireccion = new JLabel("ID_Cliente:");
		lblDireccion.setBounds(10, 142, 63, 23);
		contentPane.add(lblDireccion);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(202, 212, 111, 23);
		//btnConfirmar.addActionListener(ConfirmInsert);
		contentPane.add(btnConfirmar);
		
		lblOrder = new JLabel("Introduce los parametros del nuevo vídeo");
		lblOrder.setBounds(52, 11, 219, 23);
		contentPane.add(lblOrder);
		
		cancelButton = new JButton("Cancelar");
		cancelButton.setBounds(10, 212, 89, 23);
		//cancelButton.addActionListener(CloseWindow);
		contentPane.add(cancelButton);
		
	}
	
	
	public JTextField getTituloTextField_1() {
		return tituloTextField_1;
	}

	public void setTituloTextField_1(JTextField tituloTextField_1) {
		this.tituloTextField_1 = tituloTextField_1;
	}

	public JTextField getDirectorTextField_2() {
		return DirectorTextField_2;
	}

	public void setDirectorTextField_2(JTextField DirectorTextField_2) {
		this.DirectorTextField_2 = DirectorTextField_2;
	}

	public JTextField getIDClientDirTextField_3() {
		return idCliTextField_3;
	}

	public void setIDClientTextField_3(JTextField idCliTextField_3) {
		this.idCliTextField_3 = idCliTextField_3;
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
