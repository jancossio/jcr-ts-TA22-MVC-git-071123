package controllers;
import models.Model;
import views.*;

public class crudApp {

	public static void main(String[] args) {
		MainMenu mainMenu = new MainMenu();
		InsertMenu insertMenu = new InsertMenu();
		SearchMenu searchMenu = new SearchMenu();
		UpdateMenu updateMenu = new UpdateMenu();
		DeleteMenu deleteMenu = new DeleteMenu();
		Model model = new Model();
		
		Controller controller = new Controller(mainMenu, insertMenu, searchMenu, updateMenu, deleteMenu, model);
		
		insertMenu.setController(controller);
		mainMenu.setController(controller);
		updateMenu.setController(controller);
		deleteMenu.setController(controller);
		searchMenu.setController(controller);
		
		mainMenu.setVisible(true);
		

	}

}
