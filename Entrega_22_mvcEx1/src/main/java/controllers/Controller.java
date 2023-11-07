package controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import models.Cliente;
import models.Model;
import views.*;


public class Controller{

	private Model model;
	private MainMenu mainMenu;
	private InsertMenu insertMenu;
	private SearchMenu searchMenu;
	private UpdateMenu updateMenu;
	private DeleteMenu deleteMenu;

	public Controller(MainMenu mainMenu, InsertMenu insertMenu, SearchMenu searchMenu, UpdateMenu updateMenu, DeleteMenu deleteMenu, Model model) {
		
		this.mainMenu = mainMenu;
		this.insertMenu = insertMenu;
		this.searchMenu = searchMenu;
		this.updateMenu = updateMenu;
		this.deleteMenu = deleteMenu;
		this.model = model;
		
		this.insertMenu.getBtnConfirmar().addActionListener(ConfirmInsert);
		this.insertMenu.getCancelButton().addActionListener(CloseInsertWindow);
		
		this.updateMenu.getConfirmButton().addActionListener(ConfirmUpdate);
		this.updateMenu.getCancelButton().addActionListener(CloseUpdateWindow);
		
		this.deleteMenu.getConfirmButton().addActionListener(ConfirmDelete);
		this.deleteMenu.getCancelButton().addActionListener(CloseDeleteWindow);
		
		this.searchMenu.getConfirmButton().addActionListener(ConfirmSearch);
		this.searchMenu.getCancelButton().addActionListener(CloseSearchWindow);
		
		StartMainMenu();
		mainMenu.getSearchAllClients().addActionListener(actionShowAllStudents);
	}
	
	//MAIN_MENU-FUNCTIONS
	
	public void StartMainMenu() {
		
		mainMenu.getInsertClient().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				showInsertMenu();
			}
		});
		
		mainMenu.getSearchClient().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				showSearchMenu();
			}
		});
		
		mainMenu.getUpdateClients().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = mainMenu.getTable().getSelectedRow();
				if (selectedRow < 0) {
					JOptionPane.showMessageDialog(null, "Para actualizar un cliente primero se debe seleccionar un registro");
				} else {
					String[] values = new String[6];
					TableModel model = mainMenu.getTable().getModel();
					Object obj;
					
					for(int i=0; i<values.length; i++) {
						obj = model.getValueAt(selectedRow, i);
						if(obj != null) {
							values[i] = obj.toString();
						}
					}
					showUpdateMenu(values);
				}
			}
		});
		
		mainMenu.getDeleteClient().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = mainMenu.getTable().getSelectedRow();
				if (selectedRow < 0) {
					JOptionPane.showMessageDialog(null, "Para borrar un cliente primero se debe seleccionar un registro");
				} else {
					//String idToDelete = table.getModel().getValueAt(selectedRow[0], 0).toString();
					String[] values = new String[6];
					TableModel model =  mainMenu.getTable().getModel();
					Object obj;
					
					for(int i=0; i<values.length; i++) {
						obj = model.getValueAt(selectedRow, i);
						if(obj != null) {
							values[i] = obj.toString();
						}
					}
					showDeleteMenu(values);
				}
			}
		});
	}
	
	ActionListener actionShowAllStudents = new ActionListener() {
		public void actionPerformed(ActionEvent e) {			

			fillTable();
		}
	};
	
	
	public void fillTable() {

		DefaultTableModel tbl = new DefaultTableModel();
		ArrayList<Cliente> clientes;
		String[] colmn = new String[6];
		tbl.addColumn("ID");
		tbl.addColumn("Nombre");
		tbl.addColumn("Apellido");
		tbl.addColumn("Direccion");
		tbl.addColumn("DNI");
		tbl.addColumn("Fecha");
		clientes = getDataTable();
		for(int i=0; i<clientes.size(); i++) {
			colmn[0] = Integer.toString(clientes.get(i).getId());
			colmn[1] = clientes.get(i).getNombre().toString();
			colmn[2] = clientes.get(i).getApellido().toString();
			colmn[3] = clientes.get(i).getDireccion().toString();
			colmn[4] = Integer.toString(clientes.get(i).getDni());
			colmn[5] = clientes.get(i).getFecha().toString();
			tbl.addRow(colmn);
		}
		mainMenu.getTable().setModel(tbl);
	}
	
	//END_MAIN_MENU-FUNCTIONS
	
	
	//INSERT_MENU
	
	ActionListener CloseInsertWindow = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			hideInsertMenu();
		}
	};
	
	ActionListener ConfirmInsert = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			if(!insertMenu.getNombTextField_1().getText().equals("") && !insertMenu.getApelTextField_2().getText().equals("")
			&& !insertMenu.getDirTextField_3().getText().equals("") && !insertMenu.getDniTextField_4().getText().equals("") 
			&& !insertMenu.getFechTextField_5().getText().equals("")) {
				insertClient();
			}else {
				JOptionPane.showMessageDialog(null,"Todos los campos deben rellenarse antes de enviarse");
			}
		}
	};
	
	public void insertClient() {
		Cliente cliente = new Cliente();
		
		try {
			cliente.setNombre(insertMenu.getNombTextField_1().getText());
			cliente.setApellido(insertMenu.getApelTextField_2().getText());
			cliente.setDireccion(insertMenu.getDirTextField_3().getText());
			cliente.setDni(Integer.parseInt(insertMenu.getDniTextField_4().getText()));
			cliente.setFecha(insertMenu.getFechTextField_5().getText());
			boolean res = insertClient(cliente);
			if(res) {
				JOptionPane.showMessageDialog(null,"El nuevo cliente se ha agregado correctamente");
			}else {
				JOptionPane.showMessageDialog(null,"Se ha fallado al agregar el nuevo cliente");
			}
			updateTable();
			hideInsertMenu();
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null,"Los parametros introducidos no son correctos");
		}
	}
	
	//END_CANCEL_BUTTON_FUNCTIONS
	
	
	//UPDATE_MENU-FUNCTIONS
	
	ActionListener ConfirmUpdate = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			boolean res = false;
			
			if(!updateMenu.getId().equals("")) {	
				Cliente cli = new Cliente();
				
				try {
					int id  = Integer.parseInt(updateMenu.getId());		
					cli.setId(id);
					cli.setNombre(updateMenu.getTextFieldNomb().getText());
					cli.setApellido(updateMenu.getTextFieldApel().getText());
					cli.setDireccion(updateMenu.getTextFieldDir().getText());
					cli.setDni(Integer.parseInt(updateMenu.getTextFieldDNI().getText()));
					cli.setFecha(updateMenu.getTextFieldFech().getText());
					
					res = updateClient(id, cli);
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,"Introduce los parametros correctamente!");
				}	
			}
			if(res) {
				JOptionPane.showMessageDialog(null,"El cliente se ha actualizado correctamente");
			}else {
				JOptionPane.showMessageDialog(null,"Se ha fallado al actualizar el cliente");
			}
			updateTable();
			hideUpdateMenu();
		}
	};
	
	ActionListener CloseUpdateWindow = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			hideUpdateMenu();
		}
	};
	
	public void setUpdateClient(String[] values) {
		updateMenu.setId(values[0]);
		
		//System.out.println(values[0]+" "+values[1]+" "+values[2]+" "+values[3]+" "+values[4]+" "+values[5]+" ");
		updateMenu.getTextFieldNomb().setText(values[1]);
		updateMenu.getTextFieldApel().setText(values[2]);
		updateMenu.getTextFieldDir().setText(values[3]);
		updateMenu.getTextFieldDNI().setText(values[4].toString());
		updateMenu.getTextFieldFech().setText(values[5]);
	}
	
	//END_UPDATE_MENU-FUNCTIONS
	
	
	//DELETE_MENU-FUNCTIONS
	
	ActionListener ConfirmDelete = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			boolean res = false;
			
			try {
				if(!deleteMenu.getId().equals("")) {
					res = deleteClient(Integer.parseInt(deleteMenu.getId()));
				}
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null,"El ID no estaba introducido correctamente");
			}
			
			if(res) {
				JOptionPane.showMessageDialog(null,"El cliente se ha eliminado correctamente");
			}else {
				JOptionPane.showMessageDialog(null,"Se ha fallado al borrar el cliente");
			}
			updateTable();
			hideDeleteMenu();
		}
	};
	
	ActionListener CloseDeleteWindow = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			hideDeleteMenu();
		}
	};
	
	
	public void setDeleteClient(String[] values) {
		deleteMenu.setId(values[0]);
		deleteMenu.getLblID().getText();
		
		DefaultTableModel tbl = new DefaultTableModel();
		tbl.addColumn("ID");
		tbl.addColumn("Nombre");
		tbl.addColumn("Apellido");
		tbl.addColumn("Direccion");
		tbl.addColumn("DNI");
		tbl.addColumn("Fecha");
		tbl.addRow(values);
		deleteMenu.getTable().setModel(tbl);
	}
	
	//END_DELETE_MENU-FUNCTIONS
	
	
	//SEARCH_FUNCTIONS
	
	ActionListener CloseSearchWindow = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			hideSearchMenu();
		}
	};

	ActionListener ConfirmSearch = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
		if(!searchMenu.getTextField().getText().equals("")){
				try {
					int tmp = Integer.parseInt(searchMenu.getTextField().getText());
					Cliente cli = searchClient(tmp);
					if(cli != null) {
						fillTable(cli);
					}else {
						JOptionPane.showMessageDialog(null, "No se ha encontrado el cliente con el ID introducido");
					}
					
				}catch(NumberFormatException nfe){
					JOptionPane.showMessageDialog(null, "Escribe bien el identificador del cliente!");
				}
			}
		}
	};
	
	public void fillTable(Cliente cliente) {
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
		searchMenu.getTable().setModel(tbl);
	}
	
	
	//END_SEARCH_FUNCTIONS
	
	
	//CONTROLLER FUNCTIONS
	
	public ArrayList<Cliente> getDataTable(){
		
		ArrayList<Cliente> clientes = model.selectAllClientsData();
		return clientes;
	}
	
	public void updateTable() {
		fillTable();
	}
	
	public boolean insertClient(Cliente cliente){
		
		return model.insertData(cliente);
	}
	
	public Cliente searchClient(Integer identifier){
		
		Cliente cliente = model.selectClientData(identifier);
		return cliente;
	}
	
	public boolean updateClient(Integer identifier, Cliente cli){
		
		return model.updateData(identifier, cli);
	}
	
	public boolean deleteClient(Integer identifier){
		
		return model.deleteData(identifier);
	}
	
	
	public void showInsertMenu() {
		insertMenu.setVisible(true);
	}
	
	public void hideInsertMenu() {
		insertMenu.setVisible(false);
	}
	
	public void showUpdateMenu(String[] values) {
		updateMenu.setVisible(true);
		setUpdateClient(values);
	}
	
	public void showSearchMenu() {
		searchMenu.setVisible(true);
	}
	
	public void hideSearchMenu() {
		searchMenu.setVisible(false);
	}
	
	public void hideUpdateMenu() {
		updateMenu.setVisible(false);
	}
	
	public void showDeleteMenu(String[] values) {
		deleteMenu.setVisible(true);
		setDeleteClient(values);
	}
	
	public void hideDeleteMenu() {
		deleteMenu.setVisible(false);
	}
}
