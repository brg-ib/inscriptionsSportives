package menuUser;

import java.util.*;

import inscriptions.*;
import commandLineMenus.Action;
import commandLineMenus.Menu;
import commandLineMenus.Option;
import commandLineMenus.rendering.examples.util.InOut;

public class MainUser {


	// Menu principal
	 private static Menu getMainMenu(){
		Menu menu = new Menu("Inscriptions Sportives");
		menu.add(menuInscriptions());
		menu.add(menuCandidats());
		menu.add(menuCompetitions());
		menu.addQuit("q");
		return menu;
	}

	private Menu menuExit(){
		Menu quitter = new Menu("Quitter", "q");
		quitter.addQuit("q");
		return quitter;
	}
	
	
	// Menu Inscriptions
	private static Menu menuInscriptions() {
		Menu menu = new Menu("Inscriptions", "i");
		// TODO
		
		return menu;
	}
	// TODO

	
	// Menu Candidats
	private static Menu menuCandidats() {
		Menu menu = new Menu("Candidats", "c");
		// TODO
		
		return menu;
	}
	
	// TODO

	
	// Menu Competitions
	private static Menu menuCompetitions() {
		Menu menu = new Menu("Competitions", "p");
		// TODO
		
		return menu;
	}
	// TODO

	
	// Main
	public static void main(String[] args)
	{
		Menu rootMenu = getMainMenu();
		rootMenu.start();
	}
	
	
}