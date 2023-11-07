package views;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ChoseTableMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JLabel lblNewLabel;
	private JButton scientistsButton;
	private JButton proyectosButton;
	private JButton asignadoA_Button;

	/**
	 * Create the frame.
	 */
	public ChoseTableMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Selecciona la tabla con la que desees trabajar:");
		lblNewLabel.setBounds(92, 52, 317, 23);
		contentPane.add(lblNewLabel);
		
		scientistsButton = new JButton("Cientificos");
		scientistsButton.setBounds(60, 152, 89, 37);
		contentPane.add(scientistsButton);
		
		proyectosButton = new JButton("Proyectos");
		proyectosButton.setBounds(280, 152, 89, 40);
		contentPane.add(proyectosButton);
		
		asignadoA_Button = new JButton("asignado_a");
		asignadoA_Button.setBounds(170, 152, 89, 37);
		contentPane.add(asignadoA_Button);
	}

	public JButton getScientistsButton() {
		return scientistsButton;
	}

	public void setScientistsButton(JButton clientsButton) {
		this.scientistsButton = clientsButton;
	}

	public JButton getProyectosButton() {
		return proyectosButton;
	}

	public void setProyectosButton(JButton videosButton) {
		this.proyectosButton = videosButton;
	}

	public JButton getAsignadoA_Button() {
		return asignadoA_Button;
	}

	public void setAsignadoA_Button(JButton asignadoA_Button) {
		this.asignadoA_Button = asignadoA_Button;
	}
	
}
