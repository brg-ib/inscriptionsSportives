package menuUser;

import java.util.*;

import inscriptions.*;

import commandLineMenus.*;
import commandLineMenus.examples.ListOptions;
import commandLineMenus.rendering.examples.util.InOut;

public class MainUser {

	
	// Menu principal
	 private static Menu getMainMenu(){
		Menu menu = new Menu("Inscriptions Sportives");
//		menu.add(getmenuInscriptions());
		menu.add(menuCandidats());
		menu.add(menuCompetitions());
//		menu.add(getmenuPersonne());
//		menu.add(getmenuExit());
		menu.addQuit("q");
		return menu;
	}

	 
	/*
	 * Menu Candidats
	 * Dina
	 */
	private static Menu menuCandidats() {
		Menu menu = new Menu("Candidats", "Candidat", "c");
		// TODO
		menu.add(getCandidatsOption());
		menu.add(getCandidatsOption1());
		menu.add(getCandidatsOption2());
		menu.add(getCandidatsOption3());
		menu.addBack("b");
		menu.setAutoBack(true);
		return menu;
	}
	
	static Option getCandidatsOption()
	{
		return new Option("Nom", "N", getCandidatsNom());

	}
	
	static Option getCandidatsOption1()
	{

		return new Option("Delete", "D", CandidatsDelete());

	}
	
	static Option getCandidatsOption2()
	{

		return new Option("Modifier le Nom", "MN", setCandidatsNom());
	}
	
	static Option getCandidatsOption3()
	{

		return new Option("Comp�titions", "C", getCandidatsCompetitions());

	}
	
	static ArrayList<String> al = new ArrayList<String>();

	
	static Action getCandidatsNom()
	{
		return new Action()
		{
			public void optionSelected()
			{
//				System.out.println("Marcel");
				al.add("Ginette");
				
			      System.out.println("Nom du candidat : " + al);
			    
			}
		};
	}

	
	static Action CandidatsDelete()
	{
		return new Action()
		{
			public void optionSelected()
			{
				
				al.add("Ginette");
				al.remove("Ginette");
				System.out.println(al + " has been deleted.");
				
			}
		};
	}
		
	static Action getCandidatsCompetitions()
	{
		return new Action()
		{
			public void optionSelected()
			{
				System.out.println("Basket");
				System.out.println("Golf");
				System.out.println("Course de cheveaux");
				System.out.println("Handball");
			}
		};
	}
	
	static Action setCandidatsNom()
	{
		return new Action()
		{
			public void optionSelected()
			{
				Scanner sc = new Scanner(System.in);
				int i = sc.nextInt();
				String n = sc.nextLine();
				al.set(i, n);
			}
		};
	}
	
	
	// TODO

	/*
	 * Menu compétitions
	 * Ihcen
	 */
	private static Menu menuCompetitions() {
		Menu menu = new Menu("Menu","Compétitions", "C");
		menu.add(afficherCompetitions());
		//menu.add();
		// TODO
		menu.addBack("b");
		return menu;
	}

	static Option afficherCompetitions() {
		return new Option("Liste des competitions", "l", () -> { 
			System.out.println(Inscriptions.getInscriptions().getCompetitions());
			});
	}
	
	// Menu Personne
		private static Menu getmenuPersonne() {
			Menu menu = new Menu("Personnes", "p");
			// TODO
			
			return menu;
		}
		// TODO

	
	// Main
	public static void main(String[] args)
	{
		Menu menu = getMainMenu();
		menu.start();
		
	
	}
	
	
}