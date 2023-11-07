package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ChoseTableMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JLabel lblNewLabel;
	private JButton clientsButton;
	private JButton videosButton;

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
		
		clientsButton = new JButton("Clientes");
		clientsButton.setBounds(60, 152, 89, 37);
		contentPane.add(clientsButton);
		
		videosButton = new JButton("Videos");
		videosButton.setBounds(280, 152, 89, 40);
		contentPane.add(videosButton);
	}

	public JButton getClientsButton() {
		return clientsButton;
	}

	public void setClientsButton(JButton clientsButton) {
		this.clientsButton = clientsButton;
	}

	public JButton getVideosButton() {
		return videosButton;
	}

	public void setVideosButton(JButton videosButton) {
		this.videosButton = videosButton;
	}
}
