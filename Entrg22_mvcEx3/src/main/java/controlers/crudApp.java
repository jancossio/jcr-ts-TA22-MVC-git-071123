package controlers;

import models.Queries;
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

public class crudApp {

	public static void main(String[] args) {
		
		ChoseTableMenu choseTableMenu = new ChoseTableMenu();
		
		MainMenuProyecto mainMenuProyecto = new MainMenuProyecto();
		InsertMenuProyecto insertMenuProyecto = new InsertMenuProyecto();
		SearchMenuProyecto searchMenuProyecto = new SearchMenuProyecto();
		UpdateMenuProyecto updateMenuProyecto = new UpdateMenuProyecto();
		DeleteMenuProyecto deleteMenuProyecto = new DeleteMenuProyecto();
		
		MainMenuCientifico mainMenuCientifico = new MainMenuCientifico();
		InsertMenuCientifico insertMenuCientifico = new InsertMenuCientifico();
		SearchMenuCientifico searchMenuCientifico = new SearchMenuCientifico();
		UpdateMenuCientifico updateMenuCientifico = new UpdateMenuCientifico();
		DeleteMenuCientifico deleteMenuCientifico = new DeleteMenuCientifico();
		
		MainMenuAsignado mainMenuAsignado = new MainMenuAsignado();
		InsertMenuAsignado insertMenuAsignado = new InsertMenuAsignado();
		SearchMenuAsignado searchMenuAsignado = new SearchMenuAsignado();
		DeleteMenuAsignado deleteMenuAsignado = new DeleteMenuAsignado();
		
		Queries query = new Queries();
		
		Controller controller = new Controller(mainMenuCientifico, insertMenuCientifico, searchMenuCientifico, updateMenuCientifico, 
				deleteMenuCientifico, mainMenuProyecto, insertMenuProyecto, searchMenuProyecto, updateMenuProyecto,deleteMenuProyecto, 
				mainMenuAsignado, insertMenuAsignado, searchMenuAsignado, deleteMenuAsignado, choseTableMenu, query);
				
		insertMenuProyecto.setController(controller);
		mainMenuProyecto.setController(controller);
		updateMenuProyecto.setController(controller);
		deleteMenuProyecto.setController(controller);
		searchMenuProyecto.setController(controller);
		
		insertMenuCientifico.setController(controller);
		mainMenuCientifico.setController(controller);
		updateMenuCientifico.setController(controller);
		deleteMenuCientifico.setController(controller);
		searchMenuCientifico.setController(controller);
		
		 mainMenuAsignado.setController(controller);;
		 insertMenuAsignado.setController(controller);;
		 searchMenuAsignado.setController(controller);;
		 deleteMenuAsignado.setController(controller);
		
		choseTableMenu.setVisible(true);
		//mainMenuClient.setVisible(true);
	}
	
}
