package views;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlers.Controller;

public class MainMenuVideo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controller controller;
	
	private JLabel titulo;
	private JButton insertVideo;
	private JButton searchVideo;
	private JButton updateVideo;
	private JButton deleteVideo;
	private JButton searchAllVideos;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton backButton;
	

	/**
	 * Create the frame.
	 */
	public MainMenuVideo() {
		setTitle("Gestor de videos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 450);
		contentPane = new JPanel();
		
				
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		titulo = new JLabel("Base de datos: videos");
		titulo.setBounds(147, 6, 142, 24);
		contentPane.add(titulo);
		
		insertVideo = new JButton("Agregar video");
		insertVideo.setBounds(5, 149, 137, 43);
		contentPane.add(insertVideo);
		
		searchVideo = new JButton("Consultar video");
		searchVideo.setBounds(5, 95, 137, 43);
		contentPane.add(searchVideo);
		
		updateVideo = new JButton("Actualizar video");
		updateVideo.setBounds(5, 203, 137, 43);
		contentPane.add(updateVideo);
		
		searchAllVideos = new JButton("Consultar videos");
		searchAllVideos.setBounds(5, 41, 137, 43);
		//searchAllClients.addActionListener(actionShowAllStudents);
		contentPane.add(searchAllVideos);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(147, 41, 567, 359);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Titulo", "Director", "ID_Cliente"
			}
		));
			scrollPane.setViewportView(table);
		
		deleteVideo = new JButton("Borrar video");
		deleteVideo.setBounds(5, 257, 137, 43);
		contentPane.add(deleteVideo);
		
		backButton = new JButton("Volver");
		backButton.setBounds(10, 377, 89, 23);
		contentPane.add(backButton);
	}
	
	public JButton getInsertVideo() {
		return insertVideo;
	}
	
	public void setInsertVideo(JButton insertClient) {
		this.insertVideo = insertClient;
	}
	
	public JButton getSearchVideo() {
		return searchVideo;
	}
	
	public void setSearchVideo(JButton searchClient) {
		this.searchVideo = searchClient;
	}
	
	public JButton getUpdateVideos() {
		return updateVideo;
	}
	
	public void setUpdateVideos(JButton updateClients) {
		this.updateVideo = updateClients;
	}
	
	public JButton getDeleteVideo() {
		return deleteVideo;
	}
	
	public void setDeleteVideo(JButton deleteClient) {
		this.deleteVideo = deleteClient;
	}
	
	public JButton getSearchAllVideos() {
		return searchAllVideos;
	}
	
	public void setSearchAllVideos(JButton searchAllClients) {
		this.searchAllVideos = searchAllClients;
	}
	
	public JTable getTable() {
		return table;
	}
	
	public void setTable(JTable table) {
		this.table = table;
	}
	
	public JButton getBackButton() {
		return backButton;
	}
	
	public void setBackButton(JButton backButton) {
		this.backButton = backButton;
	}
	
	public void setController(Controller controller) {
		this.controller = controller;
		controller.fillTableVideo();
	}
}
