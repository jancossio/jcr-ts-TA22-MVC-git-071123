package controlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import models.Cliente;
import models.Videos;
import models.Queries;
import views.ChoseTableMenu;
import views.DeleteMenuClient;
import views.DeleteMenuVideo;
import views.InsertMenuClient;
import views.InsertMenuVideo;
import views.MainMenuClient;
import views.MainMenuVideo;
import views.SearchMenuClient;
import views.SearchMenuVideo;
import views.UpdateMenuClient;
import views.UpdateMenuVideo;

public class Controller {

	private Queries queries;
	
	private ChoseTableMenu choseTableMenu;
	
	private MainMenuClient mainMenuClient;
	private InsertMenuClient insertMenuClient;
	private SearchMenuClient searchMenuClient;
	private UpdateMenuClient updateMenuClient;
	private DeleteMenuClient deleteMenuClient;
	
	private MainMenuVideo mainMenuVideo;
	private InsertMenuVideo insertMenuVideo;
	private SearchMenuVideo searchMenuVideo;
	private UpdateMenuVideo updateMenuVideo;
	private DeleteMenuVideo deleteMenuVideo;
	
	public Controller(MainMenuClient mainMenuClient, InsertMenuClient insertMenuClient, SearchMenuClient searchMenuClient, UpdateMenuClient updateMenuClient, 
			DeleteMenuClient deleteMenuClient, MainMenuVideo mainMenuVideo, InsertMenuVideo insertMenuVideo, SearchMenuVideo searchMenuVideo, UpdateMenuVideo updateMenuVideo,
			DeleteMenuVideo deleteMenuVideo, ChoseTableMenu choseTableMenu, Queries queries) {
		
		this.choseTableMenu = choseTableMenu;
		
		this.mainMenuClient = mainMenuClient;
		this.insertMenuClient = insertMenuClient;
		this.searchMenuClient = searchMenuClient;
		this.updateMenuClient = updateMenuClient;
		this.deleteMenuClient = deleteMenuClient;
		
		this.mainMenuVideo = mainMenuVideo;
		this.insertMenuVideo = insertMenuVideo;
		this.searchMenuVideo = searchMenuVideo;
		this.updateMenuVideo = updateMenuVideo;
		this.deleteMenuVideo = deleteMenuVideo;
		this.queries = queries;
		
		StartChoseTableMenu();
		
		this.insertMenuClient.getBtnConfirmar().addActionListener(ConfirmInsertClient);
		this.insertMenuClient.getCancelButton().addActionListener(CloseInsertClientWindow);
		
		this.updateMenuClient.getConfirmButton().addActionListener(ConfirmUpdateClient);
		this.updateMenuClient.getCancelButton().addActionListener(CloseUpdateClientWindow);
		
		this.deleteMenuClient.getConfirmButton().addActionListener(ConfirmClientDelete);
		this.deleteMenuClient.getCancelButton().addActionListener(CloseDeleteClientWindow);
		
		this.searchMenuClient.getConfirmButton().addActionListener(ConfirmSearchClient);
		this.searchMenuClient.getCancelButton().addActionListener(CloseSearchClientWindow);
		
		StartMainMenuClient();
		mainMenuClient.getSearchAllClients().addActionListener(actionShowAllClients);
		
		this.insertMenuVideo.getBtnConfirmar().addActionListener(ConfirmInsertVideo);
		this.insertMenuVideo.getCancelButton().addActionListener(CloseInsertVideoWindow);
		
		this.updateMenuVideo.getConfirmButton().addActionListener(ConfirmUpdateVideo);
		this.updateMenuVideo.getCancelButton().addActionListener(CloseUpdateVideoWindow);
		
		this.deleteMenuVideo.getConfirmButton().addActionListener(ConfirmVideoDelete);
		this.deleteMenuVideo.getCancelButton().addActionListener(CloseDeleteVideoWindow);
		
		this.searchMenuVideo.getConfirmButton().addActionListener(ConfirmSearchVideo);
		this.searchMenuVideo.getCancelButton().addActionListener(CloseSearchVideoWindow);
		
		StartMainMenuVideo();
		mainMenuVideo.getSearchAllVideos().addActionListener(actionShowAllVideos);
	}
	
	
	//CHOSE_TABLE_MENU-FUNCTIONS
	
	public void StartChoseTableMenu() {
	
		choseTableMenu.getClientsButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				showClientMainMenu();
			}
		});
		
		choseTableMenu.getVideosButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				showVideosMainMenu();
			}
		});
	}
	
	//END_CHOSE_TABLE_MENU-FUNCTIONS
	
	
	//CLIENT_MAIN_MENU-FUNCTIONS
	
	public void StartMainMenuClient() {
		
		mainMenuClient.getBackButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				clientBackToChoseMenu();
			}
		});
		
		mainMenuClient.getInsertClient().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				insertMenuClient.setVisible(true);
			}
		});
		
		mainMenuClient.getSearchClient().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				searchMenuClient.setVisible(true);
			}
		});
		
		mainMenuClient.getUpdateClients().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = mainMenuClient.getTable().getSelectedRow();
				if (selectedRow < 0) {
					JOptionPane.showMessageDialog(null, "Para actualizar un cliente primero se debe seleccionar un registro");
				} else {
					String[] values = new String[6];
					TableModel model = mainMenuClient.getTable().getModel();
					Object obj;
					
					for(int i=0; i<values.length; i++) {
						obj = model.getValueAt(selectedRow, i);
						if(obj != null) {
							values[i] = obj.toString();
						}
					}
					showUpdateClientMenu(values);
				}
			}
		});
		
		mainMenuClient.getDeleteClient().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = mainMenuClient.getTable().getSelectedRow();
				if (selectedRow < 0) {
					JOptionPane.showMessageDialog(null, "Para borrar un cliente primero se debe seleccionar un registro");
				} else {
					//String idToDelete = table.getModel().getValueAt(selectedRow[0], 0).toString();
					String[] values = new String[6];
					TableModel model =  mainMenuClient.getTable().getModel();
					Object obj;
					
					for(int i=0; i<values.length; i++) {
						obj = model.getValueAt(selectedRow, i);
						if(obj != null) {
							values[i] = obj.toString();
						}
					}
					showDeleteClientMenu(values);
				}
			}
		});
	}
	
	ActionListener actionShowAllClients = new ActionListener() {
		public void actionPerformed(ActionEvent e) {			

			fillTableClient();
		}
	};
	
	
	public void fillTableClient() {

		DefaultTableModel tbl = new DefaultTableModel();
		ArrayList<Cliente> clientes;
		String[] colmn = new String[6];
		tbl.addColumn("ID");
		tbl.addColumn("Nombre");
		tbl.addColumn("Apellido");
		tbl.addColumn("Direccion");
		tbl.addColumn("DNI");
		tbl.addColumn("Fecha");
		clientes = queries.selectAllClientsData();
		for(int i=0; i<clientes.size(); i++) {
			colmn[0] = Integer.toString(clientes.get(i).getId());
			colmn[1] = clientes.get(i).getNombre().toString();
			colmn[2] = clientes.get(i).getApellido().toString();
			colmn[3] = clientes.get(i).getDireccion().toString();
			colmn[4] = Integer.toString(clientes.get(i).getDni());
			colmn[5] = clientes.get(i).getFecha().toString();
			tbl.addRow(colmn);
		}
		mainMenuClient.getTable().setModel(tbl);
	}
	
	//END_CLIENT_MAIN_MENU-FUNCTIONS
	
	
	//VIDEO_MAIN_MENU-FUNCTIONS
	
		public void StartMainMenuVideo() {
			
			mainMenuVideo.getBackButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ae) {
					videoBackToChoseMenu();
				}
			});
			
			mainMenuVideo.getInsertVideo().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ae) {
					insertMenuVideo.setVisible(true);
				}
			});
			
			mainMenuVideo.getSearchVideo().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ae) {
					searchMenuVideo.setVisible(true);
				}
			});
			
			mainMenuVideo.getUpdateVideos().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int selectedRow = mainMenuVideo.getTable().getSelectedRow();
					if (selectedRow < 0) {
						JOptionPane.showMessageDialog(null, "Para actualizar un video primero se debe seleccionar un registro");
					} else {
						String[] values = new String[4];
						TableModel model = mainMenuVideo.getTable().getModel();
						Object obj;
						
						for(int i=0; i<values.length; i++) {
							obj = model.getValueAt(selectedRow, i);
							if(obj != null) {
								values[i] = obj.toString();
							}
						}
						showUpdateVideoMenu(values);
					}
				}
			});
			
			mainMenuVideo.getDeleteVideo().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int selectedRow = mainMenuVideo.getTable().getSelectedRow();
					if (selectedRow < 0) {
						JOptionPane.showMessageDialog(null, "Para borrar un video primero se debe seleccionar un registro");
					} else {
						//String idToDelete = table.getModel().getValueAt(selectedRow[0], 0).toString();
						String[] values = new String[4];
						TableModel model =  mainMenuVideo.getTable().getModel();
						Object obj;
						
						for(int i=0; i<values.length; i++) {
							obj = model.getValueAt(selectedRow, i);
							if(obj != null) {
								values[i] = obj.toString();
							}
						}
						showDeleteVideoMenu(values);
					}
				}
			});
		}
		
		ActionListener actionShowAllVideos = new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				fillTableVideo();
			}
		};
		
		
		public void fillTableVideo() {

			DefaultTableModel tbl = new DefaultTableModel();
			ArrayList<Videos> videos;
			String[] colmn = new String[6];
			tbl.addColumn("ID");
			tbl.addColumn("Titulo");
			tbl.addColumn("Director");
			tbl.addColumn("ID_Cliente");
			videos = queries.selectAllVideoData();;
			for(int i=0; i<videos.size(); i++) {
				colmn[0] = Integer.toString(videos.get(i).getId());
				colmn[1] = videos.get(i).getTitle().toString();
				colmn[2] = videos.get(i).getDirector().toString();
				colmn[3] = Integer.toString(videos.get(i).getIdCliente());
				tbl.addRow(colmn);
			}
			mainMenuVideo.getTable().setModel(tbl);
		}
		
	//END_VIDEO_MAIN_MENU-FUNCTIONS
	
	
	//CLIENT_INSERT_MENU
	
	ActionListener CloseInsertClientWindow = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			insertMenuClient.setVisible(false);
		}
	};
	
	ActionListener ConfirmInsertClient = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			if(!insertMenuClient.getNombTextField_1().getText().equals("") && !insertMenuClient.getApelTextField_2().getText().equals("")
			&& !insertMenuClient.getDirTextField_3().getText().equals("") && !insertMenuClient.getDniTextField_4().getText().equals("") 
			&& !insertMenuClient.getFechTextField_5().getText().equals("")) {
				insertClient();
			}else {
				JOptionPane.showMessageDialog(null,"Todos los campos deben rellenarse antes de enviarse");
			}
		}
	};
	
	public void insertClient() {
		Cliente cliente = new Cliente();
		
		try {
			cliente.setNombre(insertMenuClient.getNombTextField_1().getText());
			cliente.setApellido(insertMenuClient.getApelTextField_2().getText());
			cliente.setDireccion(insertMenuClient.getDirTextField_3().getText());
			cliente.setDni(Integer.parseInt(insertMenuClient.getDniTextField_4().getText()));
			cliente.setFecha(insertMenuClient.getFechTextField_5().getText());
			boolean res = queries.insertClientData(cliente);
			if(res) {
				JOptionPane.showMessageDialog(null,"El nuevo cliente se ha agregado correctamente");
			}else {
				JOptionPane.showMessageDialog(null,"Se ha fallado al agregar el nuevo cliente");
			}
			fillTableClient();
			ereaseAllInputClientFields();
			insertMenuClient.setVisible(false);
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null,"Los parametros introducidos no son correctos");
		}
	}
	
	public void ereaseAllInputClientFields() {
		insertMenuClient.getNombTextField_1().setText("");
		insertMenuClient.getApelTextField_2().setText("");
		insertMenuClient.getDirTextField_3().setText("");
		insertMenuClient.getDniTextField_4().setText("");
		insertMenuClient.getFechTextField_5().setText("");
	}
	
	//END_CLIENT_INSERT_FUNCTIONS
	
	
	//VIDEO_INSERT_MENU
	
	ActionListener CloseInsertVideoWindow = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			insertMenuVideo.setVisible(false);
		}
	};
	
	ActionListener ConfirmInsertVideo = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			if(!insertMenuVideo.getTituloTextField_1().getText().equals("") && !insertMenuVideo.getDirectorTextField_2().getText().equals("")
			&& !insertMenuVideo.getIDClientDirTextField_3().getText().equals("")) {
				insertVideo();
			}else {
				JOptionPane.showMessageDialog(null,"Todos los campos deben rellenarse antes de enviarse");
			}
		}
	};
	
	public void insertVideo() {
		Videos video = new Videos();
		
		try {
			video.setTitle(insertMenuVideo.getTituloTextField_1().getText());
			video.setDirector(insertMenuVideo.getDirectorTextField_2().getText());
			video.setIdCliente(Integer.parseInt(insertMenuVideo.getIDClientDirTextField_3().getText()));
			boolean res = queries.insertVideoData(video);
			if(res) {
				JOptionPane.showMessageDialog(null,"El nuevo video se ha agregado correctamente");
			}else {
				JOptionPane.showMessageDialog(null,"Se ha fallado al agregar el nuevo video");
			}
			fillTableVideo();
			ereaseAllInputVideoFields();
			insertMenuVideo.setVisible(false);
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null,"Los parametros introducidos no son correctos");
		}
	}
	
	public void ereaseAllInputVideoFields() {
		insertMenuVideo.getTituloTextField_1().setText("");
		insertMenuVideo.getDirectorTextField_2().setText("");
		insertMenuVideo.getIDClientDirTextField_3().setText("");
	}
	
	
	//END_VIDEO_INSERT_FUNCTIONS
	
	
	//CLIENT_UPDATE_MENU-FUNCTIONS
	
	ActionListener ConfirmUpdateClient = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			boolean res = false;
			
			if(!updateMenuClient.getId().equals("")) {	
				Cliente cli = new Cliente();
				
				try {
					int id  = Integer.parseInt(updateMenuClient.getId());		
					cli.setId(id);
					cli.setNombre(updateMenuClient.getTextFieldNomb().getText());
					cli.setApellido(updateMenuClient.getTextFieldApel().getText());
					cli.setDireccion(updateMenuClient.getTextFieldDir().getText());
					cli.setDni(Integer.parseInt(updateMenuClient.getTextFieldDNI().getText()));
					cli.setFecha(updateMenuClient.getTextFieldFech().getText());
					
					res = queries.updateClientData(id, cli);;
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,"Introduce los parametros correctamente!");
				}	
			}
			if(res) {
				JOptionPane.showMessageDialog(null,"El cliente se ha actualizado correctamente");
			}else {
				JOptionPane.showMessageDialog(null,"Se ha fallado al actualizar el cliente");
			}
			fillTableClient();
			updateMenuClient.setVisible(false);
		}
	};
	
	ActionListener CloseUpdateClientWindow = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			updateMenuClient.setVisible(false);
		}
	};
	
	public void setUpdateClient(String[] values) {
		updateMenuClient.setId(values[0]);
		
		//System.out.println(values[0]+" "+values[1]+" "+values[2]+" "+values[3]+" "+values[4]+" "+values[5]+" ");
		updateMenuClient.getTextFieldNomb().setText(values[1]);
		updateMenuClient.getTextFieldApel().setText(values[2]);
		updateMenuClient.getTextFieldDir().setText(values[3]);
		updateMenuClient.getTextFieldDNI().setText(values[4].toString());
		updateMenuClient.getTextFieldFech().setText(values[5]);
	}
	
	//END_UPDATE_CLIENT_MENU-FUNCTIONS
	
	
	//VIDEOS_UPDATE_MENU-FUNCTIONS
	
		ActionListener ConfirmUpdateVideo = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean res = false;
				
				if(!updateMenuVideo.getTextFieldTitulo().equals("") && !updateMenuVideo.getTextFieldDirector().equals("") && !updateMenuVideo.getTextFieldIDCliente().equals("")) {	
					Videos vid = new Videos();
					
					try {
						int id  = Integer.parseInt(updateMenuVideo.getId());		
						vid.setId(id);
						vid.setTitle(updateMenuVideo.getTextFieldTitulo().getText());
						vid.setDirector(updateMenuVideo.getTextFieldDirector().getText());
						vid.setIdCliente(Integer.parseInt(updateMenuVideo.getTextFieldIDCliente().getText()));
						
						res = queries.updateVideoData(id, vid);
					}catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(null,"Introduce los parametros correctamente!");
					}	
				}
				if(res) {
					JOptionPane.showMessageDialog(null,"El cliente se ha actualizado correctamente");
				}else {
					JOptionPane.showMessageDialog(null,"Se ha fallado al actualizar el cliente");
				}
				fillTableVideo();
				updateMenuVideo.setVisible(false);
			}
		};
		
		ActionListener CloseUpdateVideoWindow = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateMenuVideo.setVisible(false);
			}
		};
		
		
		public void setUpdateVideos(String[] values) {
			updateMenuVideo.setId(values[0]);
			//JOptionPane.showMessageDialog(null, values[0]+" "+values[1]+" "+values[2]+" "+values[3]);
			updateMenuVideo.getTextFieldTitulo().setText(values[1]);
			updateMenuVideo.getTextFieldDirector().setText(values[2]);
			updateMenuVideo.getTextFieldIDCliente().setText(values[3]);
		}
		
	//END_VIDEOS_UPDATE_MENU-FUNCTIONS
	
	
	//DELETE_CLIENT_MENU-FUNCTIONS
	
	ActionListener ConfirmClientDelete = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			boolean res = false;
			
			try {
				if(!deleteMenuClient.getId().equals("")) {
					res = queries.deleteClientData(Integer.parseInt(deleteMenuClient.getId()));
				}
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null,"El ID no estaba introducido correctamente");
			}
			
			if(res) {
				JOptionPane.showMessageDialog(null,"El cliente se ha eliminado correctamente");
			}else {
				JOptionPane.showMessageDialog(null,"Se ha fallado al borrar el cliente");
			}
			fillTableClient();
			deleteMenuClient.setVisible(false);
		}
	};
	
	ActionListener CloseDeleteClientWindow = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			deleteMenuClient.setVisible(false);
		}
	};
	
	
	public void setDeleteClient(String[] values) {
		deleteMenuClient.setId(values[0]);
		deleteMenuClient.getLblID().getText();
		
		DefaultTableModel tbl = new DefaultTableModel();
		tbl.addColumn("ID");
		tbl.addColumn("Nombre");
		tbl.addColumn("Apellido");
		tbl.addColumn("Direccion");
		tbl.addColumn("DNI");
		tbl.addColumn("Fecha");
		tbl.addRow(values);
		deleteMenuClient.getTable().setModel(tbl);
	}
	
	//END_DELETE_CLIENT_MENU-FUNCTIONS
	
	
	//DELETE_VIDEOS_MENU-FUNCTIONS
	
		ActionListener ConfirmVideoDelete = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean res = false;
				
				try {
					if(!deleteMenuVideo.getId().equals("")) {
						res = queries.deleteVideoData((Integer.parseInt(deleteMenuVideo.getId())));
					}
				}catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null,"El ID no estaba introducido correctamente");
				}
				
				if(res) {
					JOptionPane.showMessageDialog(null,"El video se ha eliminado correctamente");
				}else {
					JOptionPane.showMessageDialog(null,"Se ha fallado al borrar el video");
				}
				fillTableVideo();
				deleteMenuVideo.setVisible(false);
			}
		};
		
		ActionListener CloseDeleteVideoWindow = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				deleteMenuVideo.setVisible(false);
			}
		};
		
		
		public void setDeleteVideo(String[] values) {
			deleteMenuVideo.setId(values[0]);
			deleteMenuVideo.getLblID().getText();
			
			DefaultTableModel tbl = new DefaultTableModel();
			tbl.addColumn("ID");
			tbl.addColumn("Titulo");
			tbl.addColumn("Director");
			tbl.addColumn("ID_Cliente");
			tbl.addRow(values);
			deleteMenuVideo.getTable().setModel(tbl);
		}
		
		//END_DELETE_VIDEOS_MENU-FUNCTIONS
	
	
	//SEARCH_FUNCTIONS_CLIENT
	
	ActionListener CloseSearchClientWindow = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			searchMenuClient.setVisible(false);
		}
	};

	ActionListener ConfirmSearchClient = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
		if(!searchMenuClient.getTextField().getText().equals("")){
				try {
					int tmp = Integer.parseInt(searchMenuClient.getTextField().getText());
					Cliente cli = queries.selectClientData(tmp);
					if(cli != null) {
						fillTableSearchClient(cli);
					}else {
						JOptionPane.showMessageDialog(null, "No se ha encontrado el cliente con el ID introducido");
					}
					
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Escribe bien el identificador del cliente!");
				}
			}
		}
	};
	
	public void fillTableSearchClient(Cliente cliente) {
		DefaultTableModel tbl = new DefaultTableModel();
		String[] colmn = new String[6];
		tbl.addColumn("ID");
		tbl.addColumn("Nombre");
		tbl.addColumn("Apellido");
		tbl.addColumn("Direccion");
		tbl.addColumn("DNI");
		tbl.addColumn("Fecha");
		
		colmn[0] = Integer.toString(cliente.getId());
		colmn[1] = cliente.getNombre();
		colmn[2] = cliente.getApellido();
		colmn[3] = cliente.getDireccion();
		colmn[4] = Integer.toString(cliente.getDni());
		colmn[5] = cliente.getFecha();
		
		tbl.addRow(colmn);
		searchMenuClient.getTable().setModel(tbl);
	}
	
	//END_SEARCH_FUNCTIONS_CLIENT
	
	
	//SEARCH_FUNCTIONS_VIDEO
	
		ActionListener CloseSearchVideoWindow = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				searchMenuVideo.setVisible(false);
			}
		};

		ActionListener ConfirmSearchVideo = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
			if(!searchMenuVideo.getTextField().getText().equals("")){
					try {
						int tmp = Integer.parseInt(searchMenuVideo.getTextField().getText());
						
						Videos vid = queries.selectVideoData(tmp);
						if(vid != null) {
							fillTableSearchVideos(vid);
						}else {
							JOptionPane.showMessageDialog(null, "No se ha encontrado el video con el ID introducido");
						}
						
					}catch(NumberFormatException nfe){
						JOptionPane.showMessageDialog(null, "Escribe bien el identificador del cliente!");
					}
				}
			}
		};
		
		public void fillTableSearchVideos(Videos video) {
			DefaultTableModel tbl = new DefaultTableModel();
			String[] colmn = new String[4];
			tbl.addColumn("ID");
			tbl.addColumn("Titulo");
			tbl.addColumn("Director");
			tbl.addColumn("ID_Cliente");
			
			colmn[0] = Integer.toString(video.getId());
			colmn[1] = video.getTitle();
			colmn[2] = video.getDirector();
			colmn[3] = Integer.toString(video.getIdCliente());
			
			tbl.addRow(colmn);
			searchMenuVideo.getTable().setModel(tbl);
		}
		
	//END_SEARCH_FUNCTIONS_VIDEO
	
	
	//CHOSE_TABLE_FUNCTIONS_
		
		public void showClientMainMenu() {
			mainMenuClient.setVisible(true);
			choseTableMenu.setVisible(false);
		}
		
		public void clientBackToChoseMenu() {
			choseTableMenu.setVisible(true);
			mainMenuClient.setVisible(false);
		}
		
		public void showVideosMainMenu() {
			mainMenuVideo.setVisible(true);
			choseTableMenu.setVisible(false);
		}
		
		public void videoBackToChoseMenu() {
			choseTableMenu.setVisible(true);
			mainMenuVideo.setVisible(false);
		}
		
	//END_CHOSE_TABLE_FUNCTIONS_
	
	
	//CLIENT_TABLE_FUNCTIONS
	
	public void showUpdateClientMenu(String[] values) {
		updateMenuClient.setVisible(true);
		setUpdateClient(values);
	}
	
	public void showDeleteClientMenu(String[] values) {
		deleteMenuClient.setVisible(true);
		setDeleteClient(values);
	}
	
	//END_CLIENT_TABLE_FUNCTIONS
	
	
	//VIDEO_TABLE_FUNCTIONS
		
		public void showUpdateVideoMenu(String[] values) {
			updateMenuVideo.setVisible(true);
			setUpdateVideos(values);
		}
		
		public void showDeleteVideoMenu(String[] values) {
			deleteMenuVideo.setVisible(true);
			setDeleteVideo(values);
		}
		
	//END_CLIENT_VIDEO_FUNCTIONS
}