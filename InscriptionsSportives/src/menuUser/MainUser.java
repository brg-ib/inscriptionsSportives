package menuUser;

import java.util.*;

import inscriptions.*;
import commandLineMenus.Action;
import commandLineMenus.Menu;
import commandLineMenus.Option;
import commandLineMenus.rendering.examples.util.InOut;


import java.time.LocalDate;
import java.util.ArrayList;

import entity.Candidat;
import entity.Competition;
import entity.Equipe;
import entity.Personne;

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
	private static Menu getmenuInscriptions() {
		
		Menu menu = new Menu("MenuInscriptions","Inscriptions", "i");
		// TODO 
		menu.add(createEquipeOption());
        menu.add(deleteCompetitionOption());
        menu.add(deleteCandidatOption());        
		menu.add(addEquipeOption());
        menu.add(displayEquipeOption());
        menu.add(modifyEquipeOption());
        menu.addBack("B");
		menu.setAutoBack(true);
		return menu;

        
	}
	
static Option createEquipeOption() {
		
		return new Option("createPersonne", "C", createPersonne());

	}
	
	
	static Option createEquipeOption() {
		
		return new Option("addEquipe", "A", createEquipe());

	}
	
	
	static Option deleteCompetitionOption() {
		
		return new Option("deleteEquipe", "D", InscriptionsDetele(Competition));

	}
	
	static Option deleteCandidatOption() {
		
		return new Option("addEquipe", "d", InscriptionsDelete(Candidat));

	}
	static Option createEquipeOption() {
		
		return new Option("addEquipe", "c", InscriptionsgetInscriptions());

	}

	
	
	
	
	static ArrayList<String> tab = new ArrayList<String>();

	
static Action deleteCompetitionOption() {
	{
		return new Action()
		{
			public void optionSelected()
			{
				
				tab.add("Ligue1");
				tab.remove("Ligue1");
				System.out.println(al + " a bien ete supprimee.");
				
			}
		};
	}
		
	static Action deleteCandidatOption() {
		{
			return new Action()
			{
				public void optionSelected()
				{
					
//					tab.add("Gisele");
					tab.remove("Gisele");
					System.out.println(al + " a bien ete supprimee.");
					
				}
			};
		}
			

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