package controlers;

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

public class crudApp {

	public static void main(String[] args) {
		
		ChoseTableMenu choseTableMenu = new ChoseTableMenu();
		
		MainMenuVideo mainMenuVideo = new MainMenuVideo();
		InsertMenuVideo insertMenuVideo = new InsertMenuVideo();
		SearchMenuVideo searchMenuVideo = new SearchMenuVideo();
		UpdateMenuVideo updateMenuVideo = new UpdateMenuVideo();
		DeleteMenuVideo deleteMenuVideo = new DeleteMenuVideo();
		
		MainMenuClient mainMenuClient = new MainMenuClient();
		InsertMenuClient insertMenuClient = new InsertMenuClient();
		SearchMenuClient searchMenuClient = new SearchMenuClient();
		UpdateMenuClient updateMenuClient = new UpdateMenuClient();
		DeleteMenuClient deleteMenuClient = new DeleteMenuClient();
		
		Queries query = new Queries();
		
		Controller controller = new Controller(mainMenuClient, insertMenuClient, searchMenuClient, updateMenuClient, deleteMenuClient,
											mainMenuVideo, insertMenuVideo, searchMenuVideo, updateMenuVideo, deleteMenuVideo, choseTableMenu, query);
		
		insertMenuVideo.setController(controller);
		mainMenuVideo.setController(controller);
		updateMenuVideo.setController(controller);
		deleteMenuVideo.setController(controller);
		searchMenuVideo.setController(controller);
		
		insertMenuClient.setController(controller);
		mainMenuClient.setController(controller);
		updateMenuClient.setController(controller);
		deleteMenuClient.setController(controller);
		searchMenuClient.setController(controller);
		
		choseTableMenu.setVisible(true);
		//mainMenuClient.setVisible(true);
		
	}
	
}
