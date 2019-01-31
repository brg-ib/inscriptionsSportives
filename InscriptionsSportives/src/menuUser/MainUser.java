package menuUser;

import java.util.*;
import java.util.ArrayList;

import inscriptions.*;

import commandLineMenus.*;
import commandLineMenus.examples.ListOptions;
import commandLineMenus.rendering.examples.util.InOut;

public class MainUser {

	
	// Menu principal
	 private static Menu getMainMenu(){
		Menu menu = new Menu("Inscriptions Sportives");
//		menu.add(getmenuInscriptions());
		menu.add(getmenuCandidats());
//		menu.add(getmenuCompetitions());
//		menu.add(getmenuPersonne());
//		menu.add(getmenuExit());
		menu.addQuit("q");
		return menu;
	}




	
//	DINA
	 
	
	// Menu Candidats
	private static Menu getmenuCandidats() {
		Menu menu = new Menu("Candidats", "Candidat", "C");
		// TODO
		menu.add(getCandidatsOption());
		menu.add(getCandidatsOption1());
		menu.add(getCandidatsOption2());
		menu.add(getCandidatsOption3());
		menu.addBack("B");
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

	
//	 Menu Competitions
//	private static Menu getmenuCompetitions() {
//		Menu menu = new Menu("Competitions", "cp");
//		// TODO
//		
//		return menu;
//	}
	// TODO

	
	// Menu Personne
//		private static Menu getmenuPersonne() {
//			Menu menu = new Menu("Personnes", "p");
//			// TODO
//			
//			return menu;
//		}
		// TODO

	
	// Main
	public static void main(String[] args)
	{
		Menu menu = getMainMenu();
		menu.start();
		
	
	}
	
	
}