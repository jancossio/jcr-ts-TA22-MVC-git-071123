package controlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import models.Asignado_A;
import models.Cientifico;
import models.Queries;
import models.Proyecto;
import views.ChoseTableMenu;
import views.DeleteMenuAsignado;
import views.DeleteMenuCientifico;
import views.DeleteMenuProyecto;
import views.InsertMenuAsignado;
import views.InsertMenuCientifico;
import views.InsertMenuProyecto;
import views.MainMenuAsignado;
import views.MainMenuCientifico;
import views.MainMenuProyecto;
import views.SearchMenuAsignado;
import views.SearchMenuCientifico;
import views.SearchMenuProyecto;
import views.UpdateMenuCientifico;
import views.UpdateMenuProyecto;

public class Controller {

	private Queries queries;
	
	private ChoseTableMenu choseTableMenu;
	
	private MainMenuCientifico mainMenuCientifico;
	private InsertMenuCientifico insertMenuCientifico;
	private SearchMenuCientifico searchMenuCientifico;
	private UpdateMenuCientifico updateMenuCientifico;
	private DeleteMenuCientifico deleteMenuCientifico;
	
	private MainMenuProyecto mainMenuProyecto;
	private InsertMenuProyecto insertMenuProyecto;
	private SearchMenuProyecto searchMenuProyecto;
	private UpdateMenuProyecto updateMenuProyecto;
	private DeleteMenuProyecto deleteMenuProyecto;
	
	private MainMenuAsignado mainMenuAsignado;
	private InsertMenuAsignado insertMenuAsignado;
	private SearchMenuAsignado searchMenuAsignado;
	private DeleteMenuAsignado deleteMenuAsignado;
	
	public Controller(MainMenuCientifico mainMenuCientifico, InsertMenuCientifico insertMenuCientifico, SearchMenuCientifico searchMenuCientifico, UpdateMenuCientifico updateMenuCientifico, 
			DeleteMenuCientifico deleteMenuCientifico, MainMenuProyecto mainMenuProyecto, InsertMenuProyecto insertMenuProyecto, SearchMenuProyecto searchMenuProyecto, UpdateMenuProyecto updateMenuProyecto,
			DeleteMenuProyecto deleteMenuProyecto, MainMenuAsignado mainMenuAsignado, InsertMenuAsignado insertMenuAsignado, SearchMenuAsignado searchMenuAsignado,
			DeleteMenuAsignado deleteMenuAsignado, ChoseTableMenu choseTableMenu, Queries queries) {
		
		this.choseTableMenu = choseTableMenu;
		
		this.mainMenuCientifico = mainMenuCientifico;
		this.insertMenuCientifico = insertMenuCientifico;
		this.searchMenuCientifico = searchMenuCientifico;
		this.updateMenuCientifico = updateMenuCientifico;
		this.deleteMenuCientifico = deleteMenuCientifico;
		
		this.mainMenuProyecto = mainMenuProyecto;
		this.insertMenuProyecto = insertMenuProyecto;
		this.searchMenuProyecto = searchMenuProyecto;
		this.updateMenuProyecto = updateMenuProyecto;
		this.deleteMenuProyecto = deleteMenuProyecto;
		
		this.mainMenuAsignado = mainMenuAsignado;
		this.insertMenuAsignado = insertMenuAsignado;
		this.searchMenuAsignado = searchMenuAsignado;
		this.deleteMenuAsignado = deleteMenuAsignado;
		this.queries = queries;
		
		StartChoseTableMenu();
		
		this.insertMenuCientifico.getBtnConfirmar().addActionListener(ConfirmInsertCientifico);
		this.insertMenuCientifico.getCancelButton().addActionListener(CloseInsertCientificoWindow);
		
		this.updateMenuCientifico.getConfirmButton().addActionListener(ConfirmUpdateCientifico);
		this.updateMenuCientifico.getCancelButton().addActionListener(CloseUpdateCientificoWindow);
		
		this.deleteMenuCientifico.getConfirmButton().addActionListener(ConfirmCientificoDelete);
		this.deleteMenuCientifico.getCancelButton().addActionListener(CloseDeleteCientificoWindow);
		
		this.searchMenuCientifico.getConfirmButton().addActionListener(ConfirmSearchCientifico);
		this.searchMenuCientifico.getCancelButton().addActionListener(CloseSearchCientificoWindow);
		
		StartMainMenuCientifico();
		mainMenuCientifico.getSearchAllCientificos().addActionListener(actionShowAllCientifico);
		
		this.insertMenuProyecto.getBtnConfirmar().addActionListener(ConfirmInsertProyecto);
		this.insertMenuProyecto.getCancelButton().addActionListener(CloseInsertProyectoWindow);
		
		this.updateMenuProyecto.getConfirmButton().addActionListener(ConfirmUpdateProyecto);
		this.updateMenuProyecto.getCancelButton().addActionListener(CloseUpdateProyectoWindow);
		
		this.deleteMenuProyecto.getConfirmButton().addActionListener(ConfirmProyectoDelete);
		this.deleteMenuProyecto.getCancelButton().addActionListener(CloseDeleteProyectoWindow);
		
		this.searchMenuProyecto.getConfirmButton().addActionListener(ConfirmSearchProyecto);
		this.searchMenuProyecto.getCancelButton().addActionListener(CloseSearchProyectoWindow);
		
		StartMainMenuProyecto();
		mainMenuProyecto.getSearchAllProyectos().addActionListener(actionShowAllAsignados);
		
		this.insertMenuAsignado.getBtnConfirmar().addActionListener(ConfirmInsertAsignado);
		this.insertMenuAsignado.getCancelButton().addActionListener(CloseInsertAsignadoWindow);
		
		this.deleteMenuAsignado.getConfirmButton().addActionListener(ConfirmAsignadoDelete);
		this.deleteMenuAsignado.getCancelButton().addActionListener(CloseDeleteAsignadoWindow);
		
		this.searchMenuAsignado.getConfirmButton().addActionListener(ConfirmSearchAsignado);
		this.searchMenuAsignado.getCancelButton().addActionListener(CloseSearchAsignadoWindow);
		
		StartMainMenuAsignado();
	}
	
	
	//CHOSE_TABLE_MENU-FUNCTIONS
	
	public void StartChoseTableMenu() {
	
		choseTableMenu.getScientistsButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				showCientificoMainMenu();
			}
		});
		
		choseTableMenu.getProyectosButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				showProyectoMainMenu();
			}
		});
		
		choseTableMenu.getAsignadoA_Button().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				showAsignadoMainMenu();
			}
		});
	}
	
	//END_CHOSE_TABLE_MENU-FUNCTIONS
	
	
	//CLIENT_MAIN_MENU-FUNCTIONS
	
	public void StartMainMenuCientifico() {
		
		mainMenuCientifico.getBackButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				cientificoBackToChoseMenu();
			}
		});
		
		mainMenuCientifico.getInsertCientifico().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				insertMenuCientifico.setVisible(true);
			}
		});
		
		mainMenuCientifico.getSearchCientifico().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				searchMenuCientifico.setVisible(true);
			}
		});
		
		mainMenuCientifico.getUpdateCientifico().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = mainMenuCientifico.getTable().getSelectedRow();
				if (selectedRow < 0) {
					JOptionPane.showMessageDialog(null, "Para actualizar un cientifico primero se debe seleccionar un registro");
				} else {
					String[] values = new String[2];
					TableModel model = mainMenuCientifico.getTable().getModel();
					Object obj;
					
					for(int i=0; i<values.length; i++) {
						obj = model.getValueAt(selectedRow, i);
						if(obj != null) {
							values[i] = obj.toString();
						}
					}
					showUpdateCientificoMenu(values);
				}
			}
		});
		
		mainMenuCientifico.getDeleteCientifico().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = mainMenuCientifico.getTable().getSelectedRow();
				if (selectedRow < 0) {
					JOptionPane.showMessageDialog(null, "Para borrar un cientifico primero se debe seleccionar un registro");
				} else {
					String[] values = new String[2];
					TableModel model =  mainMenuCientifico.getTable().getModel();
					Object obj;
					
					for(int i=0; i<values.length; i++) {
						obj = model.getValueAt(selectedRow, i);
						if(obj != null) {
							values[i] = obj.toString();
						}
					}
					showDeleteCientificoMenu(values);
				}
			}
		});
	}
	
	ActionListener actionShowAllCientifico = new ActionListener() {
		public void actionPerformed(ActionEvent e) {			

			fillTableCientifico();
		}
	};
	
	
	public void fillTableCientifico() {

		DefaultTableModel tbl = new DefaultTableModel();
		ArrayList<Cientifico> cientificos;
		String[] colmn = new String[2];
		tbl.addColumn("DNI");
		tbl.addColumn("NomApels");;
		cientificos = queries.selectAllCientificoData();
		for(int i=0; i<cientificos.size(); i++) {
			colmn[0] = cientificos.get(i).getDni();
			colmn[1] = cientificos.get(i).getNomApels();
			tbl.addRow(colmn);
		}
		mainMenuCientifico.getTable().setModel(tbl);
	}
	
	//END_CLIENT_MAIN_MENU-FUNCTIONS
	
	
	//VIDEO_MAIN_MENU-FUNCTIONS
	
		public void StartMainMenuProyecto() {
			
			mainMenuProyecto.getBackButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ae) {
					proyectoBackToChoseMenu();
				}
			});
			
			mainMenuProyecto.getInsertProyecto().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ae) {
					insertMenuProyecto.setVisible(true);
				}
			});
			
			mainMenuProyecto.getSearchProyecto().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ae) {
					searchMenuProyecto.setVisible(true);
				}
			});
			
			mainMenuProyecto.getUpdateProyecto().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int selectedRow = mainMenuProyecto.getTable().getSelectedRow();
					if (selectedRow < 0) {
						JOptionPane.showMessageDialog(null, "Para actualizar un proyecto primero se debe seleccionar un registro");
					} else {
						String[] values = new String[3];
						TableModel model = mainMenuProyecto.getTable().getModel();
						Object obj;
						
						for(int i=0; i<values.length; i++) {
							obj = model.getValueAt(selectedRow, i);
							if(obj != null) {
								values[i] = obj.toString();
							}
						}
						showUpdateProyectoMenu(values);
					}
				}
			});
			
			mainMenuProyecto.getDeleteProyecto().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int selectedRow = mainMenuProyecto.getTable().getSelectedRow();
					if (selectedRow < 0) {
						JOptionPane.showMessageDialog(null, "Para borrar un proyecto primero se debe seleccionar un registro");
					} else {
						//String idToDelete = table.getModel().getValueAt(selectedRow[0], 0).toString();
						String[] values = new String[3];
						TableModel model =  mainMenuProyecto.getTable().getModel();
						Object obj;
						
						for(int i=0; i<values.length; i++) {
							obj = model.getValueAt(selectedRow, i);
							if(obj != null) {
								values[i] = obj.toString();
							}
						}
						showDeleteProyectoMenu(values);
					}
				}
			});
		}
		
		ActionListener actionShowAllProyectos = new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				fillTableProyecto();
			}
		};
		
		
		public void fillTableProyecto() {

			DefaultTableModel tbl = new DefaultTableModel();
			ArrayList<Proyecto> proyectos;
			String[] colmn = new String[3];
			tbl.addColumn("ID");
			tbl.addColumn("Nombre");
			tbl.addColumn("Horas");
			proyectos = queries.selectAllProyectoData();;
			for(int i=0; i<proyectos.size(); i++) {
				colmn[0] = proyectos.get(i).getId().toString();
				colmn[1] = proyectos.get(i).getNombre().toString();
				colmn[2] = Integer.toString(proyectos.get(i).getHoras());
				tbl.addRow(colmn);
			}
			mainMenuProyecto.getTable().setModel(tbl);
		}
		
		//END_VIDEO_MAIN_MENU-FUNCTIONS
	
		
		//VIDEO_MAIN_MENU-FUNCTIONS
		
		public void StartMainMenuAsignado() {
				
			mainMenuAsignado.getBackButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ae) {
					asignadoBackToChoseMenu();
				}
			});
				
			mainMenuAsignado.getInsertAsignado().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ae) {
					insertMenuAsignado.setVisible(true);
				}
			});
				
			mainMenuAsignado.getSearchAsignado().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ae) {
					searchMenuProyecto.setVisible(true);
				}
			});
				
			mainMenuAsignado.getDeleteAsignado().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int selectedRow = mainMenuAsignado.getTable().getSelectedRow();
						if (selectedRow < 0) {
							JOptionPane.showMessageDialog(null, "Para borrar una asignacion primero se debe seleccionar un registro");
						} else {
							//String idToDelete = table.getModel().getValueAt(selectedRow[0], 0).toString();
							String[] values = new String[2];
							TableModel model =  mainMenuAsignado.getTable().getModel();
							Object obj;
							
							for(int i=0; i<values.length; i++) {
								obj = model.getValueAt(selectedRow, i);
								if(obj != null) {
									values[i] = obj.toString();
								}
							}
							showDeleteAsignadoMenu(values);
						}
					}
				});
			}
			
			ActionListener actionShowAllAsignados = new ActionListener() {
				public void actionPerformed(ActionEvent e) {			
					fillTableAsignado();
				}
			};
			
			
			public void fillTableAsignado() {

				DefaultTableModel tbl = new DefaultTableModel();
				ArrayList<Asignado_A> asignados;
				String[] colmn = new String[2];
				tbl.addColumn("DNI");
				tbl.addColumn("ID");
				asignados = queries.selectAllAsignadoAData();;
				for(int i=0; i<asignados.size(); i++) {
					colmn[0] = asignados.get(i).getDni().toString();
					colmn[1] = asignados.get(i).getId().toString();
					tbl.addRow(colmn);
				}
				mainMenuProyecto.getTable().setModel(tbl);
			}
			
		//END_ASIGNADO_MAIN_MENU-FUNCTIONS
		
	
	//CLIENT_INSERT_MENU
	
	ActionListener CloseInsertCientificoWindow = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			insertMenuCientifico.setVisible(false);
		}
	};
	
	ActionListener ConfirmInsertCientifico = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			if(!insertMenuCientifico.getDniTextField().getText().equals("") && !insertMenuCientifico.getNomApelTextField().getText().equals("")){
				insertCientifico();
			}else {
				JOptionPane.showMessageDialog(null,"Todos los campos deben rellenarse antes de enviarse");
			}
		}
	};
	
	public void insertCientifico() {
		Cientifico cientifico = new Cientifico();
		
			cientifico.setDni(insertMenuCientifico.getDniTextField().getText());
			cientifico.setNomApels(insertMenuCientifico.getNomApelTextField().getText());
			boolean res = queries.insertCientificoData(cientifico);
			
			if(res) {
				JOptionPane.showMessageDialog(null,"El nuevo cientifico se ha agregado correctamente");
			}else {
				JOptionPane.showMessageDialog(null,"Se ha fallado al agregar el nuevo cientifico");
			}
			fillTableCientifico();
			insertMenuCientifico.setVisible(false);
	}
	
	//END_CLIENT_INSERT_FUNCTIONS
	
	
	//PROYECTO_INSERT_MENU
	
	ActionListener CloseInsertProyectoWindow = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			insertMenuProyecto.setVisible(false);
		}
	};
	
	ActionListener ConfirmInsertProyecto = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			if(!insertMenuProyecto.getIdTextField().getText().equals("") && !insertMenuProyecto.getNombreTextField().getText().equals("")
			&& !insertMenuProyecto.getHorasTextField().getText().equals("")) {
				insertProyecto();
			}else {
				JOptionPane.showMessageDialog(null,"Todos los campos deben rellenarse antes de enviarse");
			}
		}
	};
	
	public void insertProyecto() {
		Proyecto proyecto = new Proyecto();
		
		try {
			proyecto.setId(insertMenuProyecto.getIdTextField().getText());
			proyecto.setNombre(insertMenuProyecto.getNombreTextField().getText());
			proyecto.setHoras(Integer.parseInt(insertMenuProyecto.getHorasTextField().getText()));
			boolean res = queries.insertProyectoData(proyecto);
			if(res) {
				JOptionPane.showMessageDialog(null,"El nuevo video se ha agregado correctamente");
			}else {
				JOptionPane.showMessageDialog(null,"Se ha fallado al agregar el nuevo video");
			}
			fillTableProyecto();
			insertMenuProyecto.setVisible(false);
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null,"Los parametros introducidos no son correctos");
		}
	}
	
	//END_PROYECTO_INSERT_FUNCTIONS
	
	
	//ASIGNADO_INSERT_MENU
	
	ActionListener CloseInsertAsignadoWindow = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			insertMenuAsignado.setVisible(false);
		}
	};
	
	ActionListener ConfirmInsertAsignado = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			if(!insertMenuAsignado.getDniTextField().getText().equals("") && !insertMenuAsignado.getIdTextField().getText().equals("")) {
				insertAsignado();
			}else {
				JOptionPane.showMessageDialog(null,"Todos los campos deben rellenarse antes de enviarse");
			}
		}
	};
	
	public void insertAsignado() {
		Asignado_A asignado = new Asignado_A();
		
			asignado.setDni(insertMenuAsignado.getIdTextField().getText());
			asignado.setId(insertMenuAsignado.getIdTextField().getText());
			boolean res = queries.insertAsignadoAData(asignado);
			if(res) {
				JOptionPane.showMessageDialog(null,"La nueva asignacion se ha agregado correctamente");
			}else {
				JOptionPane.showMessageDialog(null,"Se ha fallado al agregar la nueva asignacion");
			}
			fillTableProyecto();
			insertMenuProyecto.setVisible(false);
	}
	
	//END_VIDEO_INSERT_FUNCTIONS
	
	
	
	//CLIENT_UPDATE_MENU-FUNCTIONS
	
	ActionListener ConfirmUpdateCientifico = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			boolean res = false;
			
			if(!updateMenuCientifico.getId().equals("")) {	
				Cientifico cien = new Cientifico();
				
					String dni  = updateMenuCientifico.getTextFieldDNI().getText();
					cien.setDni(dni);
					cien.setNomApels(updateMenuCientifico.getTextFieldNomApel().getText());
					res = queries.updateCientificoData(dni, cien);				
			}
			
			if(res) {
				JOptionPane.showMessageDialog(null,"El cliente se ha actualizado correctamente");
			}else {
				JOptionPane.showMessageDialog(null,"Se ha fallado al actualizar el cliente");
			}
			fillTableCientifico();
			updateMenuCientifico.setVisible(false);
		}
	};
	
	ActionListener CloseUpdateCientificoWindow = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			updateMenuCientifico.setVisible(false);
		}
	};
	
	public void setUpdateCientifico(String[] values) {
		updateMenuCientifico.setId(values[0]);
		//System.out.println(values[0]+" "+values[1]+" "+values[2]+" "+values[3]+" "+values[4]+" "+values[5]+" ");
		updateMenuCientifico.getTextFieldDNI().setText(values[0]);
		updateMenuCientifico.getTextFieldNomApel().setText(values[1]);
	}
	
	//END_UPDATE_CLIENT_MENU-FUNCTIONS
	
	
	//VIDEOS_UPDATE_MENU-FUNCTIONS
	
		ActionListener ConfirmUpdateProyecto = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean res = false;
				
				if(!updateMenuProyecto.getTextFieldID().equals("") && !updateMenuProyecto.getTextFieldNombre().equals("") && !updateMenuProyecto.getTextFieldHoras().equals("")) {	
					Proyecto proy = new Proyecto();
					
					try {		
						String id = updateMenuProyecto.getTextFieldID().getText();
						proy.setId(id);
						proy.setNombre(updateMenuProyecto.getTextFieldNombre().getText());
						proy.setHoras(Integer.parseInt(updateMenuProyecto.getTextFieldHoras().getText()));
						
						res = queries.updateProyectoData(id, proy);
					}catch(NumberFormatException ex) {
						JOptionPane.showMessageDialog(null,"Introduce los parametros correctamente!");
					}	
				}
				if(res) {
					JOptionPane.showMessageDialog(null,"El cliente se ha actualizado correctamente");
				}else {
					JOptionPane.showMessageDialog(null,"Se ha fallado al actualizar el cliente");
				}
				fillTableProyecto();
				updateMenuProyecto.setVisible(false);
			}
		};
		
		ActionListener CloseUpdateProyectoWindow = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				updateMenuProyecto.setVisible(false);
			}
		};
		
		
		public void setUpdateProyectos(String[] values) {
			//JOptionPane.showMessageDialog(null, values[0]+" "+values[1]+" "+values[2]+" "+values[3]);
			updateMenuProyecto.getTextFieldID().setText(values[0]);
			updateMenuProyecto.getTextFieldNombre().setText(values[1]);
			updateMenuProyecto.getTextFieldHoras().setText(values[2]);
		}
		
	//END_VIDEOS_UPDATE_MENU-FUNCTIONS
	
	
	//DELETE_CLIENT_MENU-FUNCTIONS
	
	ActionListener ConfirmCientificoDelete = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			boolean res = false;
			
			try {
				if(!deleteMenuCientifico.getId().equals("")) {
					res = queries.deleteCientificoData(deleteMenuCientifico.getId());
				}
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null,"El ID no estaba introducido correctamente");
			}
			
			if(res) {
				JOptionPane.showMessageDialog(null,"El cliente se ha eliminado correctamente");
			}else {
				JOptionPane.showMessageDialog(null,"Se ha fallado al borrar el cliente");
			}
			fillTableCientifico();
			deleteMenuCientifico.setVisible(false);
		}
	};
	
	ActionListener CloseDeleteCientificoWindow = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			deleteMenuCientifico.setVisible(false);
		}
	};
	
	
	public void setDeleteCientifico(String[] values) {
		deleteMenuCientifico.setId(values[0]);
		
		DefaultTableModel tbl = new DefaultTableModel();
		tbl.addColumn("ID");
		tbl.addColumn("Nombre");;
		tbl.addRow(values);
		deleteMenuCientifico.getTable().setModel(tbl);
	}
	
	//END_DELETE_CLIENT_MENU-FUNCTIONS
	
	
	//DELETE_VIDEOS_MENU-FUNCTIONS
	
		ActionListener ConfirmProyectoDelete = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean res = false;
				
					if(!deleteMenuProyecto.getId().equals("")) {
						res = queries.deleteProyectoData(deleteMenuProyecto.getId());
					}
				
				if(res) {
					JOptionPane.showMessageDialog(null,"El video se ha eliminado correctamente");
				}else {
					JOptionPane.showMessageDialog(null,"Se ha fallado al borrar el video");
				}
				fillTableProyecto();
				deleteMenuProyecto.setVisible(false);
			}
		};
		
		ActionListener CloseDeleteProyectoWindow = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				deleteMenuProyecto.setVisible(false);
			}
		};
		
		
		public void setDeleteProyecto(String[] values) {
			deleteMenuProyecto.setId(values[0]);
			
			DefaultTableModel tbl = new DefaultTableModel();
			tbl.addColumn("ID");
			tbl.addColumn("Nombre");
			tbl.addColumn("Horas");
			tbl.addRow(values);
			deleteMenuProyecto.getTable().setModel(tbl);
		}
		
	//END_DELETE_VIDEOS_MENU-FUNCTIONS
	
	
	//DELETE_ASIGNADOS_MENU-FUNCTIONS
		
		ActionListener ConfirmAsignadoDelete = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean res = false;
				
				int pos = mainMenuAsignado.getTable().getSelectedRow();
				String tmpDni = mainMenuAsignado.getTable().getValueAt(pos, 0).toString();
				String tmpId = mainMenuAsignado.getTable().getValueAt(pos, 1).toString();
				
				if(!tmpDni.equals("") && !tmpId.equals("")) {
					res = queries.deleteAsignadoAData(tmpDni, tmpId);
				}
				
				if(res) {
					JOptionPane.showMessageDialog(null,"El video se ha eliminado correctamente");
				}else {
					JOptionPane.showMessageDialog(null,"Se ha fallado al borrar el video");
				}
				fillTableAsignado();
				deleteMenuAsignado.setVisible(false);
			}
		};
		
		ActionListener CloseDeleteAsignadoWindow = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				deleteMenuAsignado.setVisible(false);
			}
		};
		
		
		public void setDeleteAsignado(String[] values) {
			
			DefaultTableModel tbl = new DefaultTableModel();
			tbl.addColumn("DNI");
			tbl.addColumn("ID");
			tbl.addRow(values);
			deleteMenuAsignado.getTable().setModel(tbl);
		}
		
	//END_DELETE_VIDEOS_MENU-FUNCTIONS
	
	
	//SEARCH_FUNCTIONS_CLIENT
	
	ActionListener CloseSearchCientificoWindow = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			searchMenuCientifico.setVisible(false);
		}
	};

	ActionListener ConfirmSearchCientifico = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
		if(!searchMenuCientifico.getTextField().getText().equals("")){
				try {
					String tmp = searchMenuCientifico.getTextField().getText();
					Cientifico cien = queries.selectCientificoData(tmp);
					if(cien != null) {
						fillTableSearchCientifico(cien);
					}else {
						JOptionPane.showMessageDialog(null, "No se ha encontrado el cientifico con el ID introducido");
					}
					
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Escribe bien el identificador del cientifico!");
				}
			}
		}
	};
	
	public void fillTableSearchCientifico(Cientifico cientifico) {
		DefaultTableModel tbl = new DefaultTableModel();
		String[] colmn = new String[2];
		tbl.addColumn("DNI");
		tbl.addColumn("NomApels");
		
		colmn[0] = cientifico.getDni();
		colmn[1] = cientifico.getNomApels();		
		tbl.addRow(colmn);
		searchMenuCientifico.getTable().setModel(tbl);
	}
	
	//END_SEARCH_FUNCTIONS_CLIENT
	
	
	//SEARCH_FUNCTIONS_VIDEO
	
		ActionListener CloseSearchProyectoWindow = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				searchMenuProyecto.setVisible(false);
			}
		};

		ActionListener ConfirmSearchProyecto = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
			if(!searchMenuProyecto.getTextField().getText().equals("")){

					String tmp = searchMenuProyecto.getTextField().getText();
						
					Proyecto proy = queries.selectProyectoData(tmp);
					if(proy != null) {
						fillTableSearchProyectos(proy);
					}else {
						JOptionPane.showMessageDialog(null, "No se ha encontrado el proyecto con el ID introducido");
					}
				}
			}
		};
		
		public void fillTableSearchProyectos(Proyecto proyecto) {
			DefaultTableModel tbl = new DefaultTableModel();
			String[] colmn = new String[4];
			tbl.addColumn("ID");
			tbl.addColumn("Nombre");
			tbl.addColumn("Horas");
			
			colmn[0] = proyecto.getId();
			colmn[1] = proyecto.getNombre();
			colmn[2] = Integer.toString(proyecto.getHoras());
			
			tbl.addRow(colmn);
			searchMenuProyecto.getTable().setModel(tbl);
		}
		
	//END_SEARCH_FUNCTIONS_VIDEO
	
	
		//SEARCH_FUNCTIONS_VIDEO
		
		ActionListener CloseSearchAsignadoWindow = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				searchMenuAsignado.setVisible(false);
			}
		};

		ActionListener ConfirmSearchAsignado = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
			if(!searchMenuAsignado.getTextFieldDni().getText().equals("") && !searchMenuAsignado.getTextFieldId().getText().equals("")){

					String tmpDni = searchMenuProyecto.getTextField().getText();
					String tmpId = searchMenuProyecto.getTextField().getText();
						
					Asignado_A asig = queries.selectAsignadoAData(tmpDni,tmpId);
					if(asig != null) {
						fillTableSearchProyectos(asig);
					}else {
						JOptionPane.showMessageDialog(null, "No se ha encontrado la asignacion con el ID introducido");
					}
				}
			}
		};
		
		public void fillTableSearchProyectos(Asignado_A asignado) {
			DefaultTableModel tbl = new DefaultTableModel();
			String[] colmn = new String[4];
			tbl.addColumn("DNI");
			tbl.addColumn("ID");
			
			colmn[0] = asignado.getDni();
			colmn[1] = asignado.getId();
			
			tbl.addRow(colmn);
			searchMenuProyecto.getTable().setModel(tbl);
		}
		
	//END_SEARCH_FUNCTIONS_VIDEO
		
		
	//CHOSE_TABLE_FUNCTIONS_
		
		public void showAsignadoMainMenu() {
			mainMenuAsignado.setVisible(true);
			choseTableMenu.setVisible(false);
		}
		
		public void asignadoBackToChoseMenu() {
			choseTableMenu.setVisible(true);
			mainMenuAsignado.setVisible(false);
		}
		
		public void showCientificoMainMenu() {
			mainMenuCientifico.setVisible(true);
			choseTableMenu.setVisible(false);
		}
		
		public void cientificoBackToChoseMenu() {
			choseTableMenu.setVisible(true);
			mainMenuCientifico.setVisible(false);
		}
		
		public void showProyectoMainMenu() {
			mainMenuProyecto.setVisible(true);
			choseTableMenu.setVisible(false);
		}
		
		public void proyectoBackToChoseMenu() {
			choseTableMenu.setVisible(true);
			mainMenuProyecto.setVisible(false);
		}
		
	//END_CHOSE_TABLE_FUNCTIONS_
	
	
	//CLIENT_TABLE_FUNCTIONS
	
	public void showUpdateCientificoMenu(String[] values) {
		updateMenuCientifico.setVisible(true);
		setUpdateCientifico(values);
	}
	
	public void showDeleteCientificoMenu(String[] values) {
		deleteMenuCientifico.setVisible(true);
		setDeleteCientifico(values);
	}
	
	//END_CLIENT_TABLE_FUNCTIONS
	
	
	//VIDEO_TABLE_FUNCTIONS
		
		public void showUpdateProyectoMenu(String[] values) {
			updateMenuProyecto.setVisible(true);
			setUpdateProyectos(values);
		}
		
		public void showDeleteProyectoMenu(String[] values) {
			deleteMenuProyecto.setVisible(true);
			setDeleteProyecto(values);
		}
		
	//END_CLIENT_VIDEO_FUNCTIONS
		
	//VIDEO_TABLE_FUNCTIONS
		
		public void showDeleteAsignadoMenu(String[] values) {
			deleteMenuProyecto.setVisible(true);
			setDeleteAsignado(values);
		}
		
	//END_CLIENT_VIDEO_FUNCTIONS
}
