package menuUser;

import java.util.ArrayList;

import inscriptions.*;

import commandLineMenus.*;
import commandLineMenus.rendering.examples.util.InOut;

import static commandLineMenus.rendering.examples.util.InOut.*;

import java.time.LocalDate;

public class MainUser {
	
	
	/*
	 * Start Application
	 */
	public void start(){
		menuPrincipal().start();
	}

	/*
	 * Menu Principal
	 */
	 private Menu menuPrincipal(){
		Menu menu = new Menu("Bienvenue | Inscriptions Sportives");
		menu.add(menuCompetitions());
		menu.add(menuPersonne());
//		menu.add(getmenuEquipe());
//		menu.add(getmenuExit());
		menu.addQuit("q");
		return menu;
	}
	 
	@SuppressWarnings("unused")
	private Option Quit(){
		Menu menu = new Menu("Quitter", "q");
		menu.addBack("r");
		return menu;
	}
	
	/*
	 *  Menu Competitions
	 */
	private Menu menuCompetitions() {
		Menu menu = new Menu("Gestion des compétitions", "c");
		// Afficher
		menu.add(listCompetition());
		// Ajouter / Creer
		menu.add(addCompetition());
		// Modifier
		menu.add(selectCompetition());
		// Option
		menu.addBack("b");
		menu.setAutoBack(true);
		return menu;
	}
	
	// OK 
	private Option listCompetition()
	{
		return new Option("Liste des compétitions", "l", () -> {System.out.println(Inscriptions.getInscriptions().getCompetitions());});
	}

	// OK 
	private List<Competition> selectCompetition(){
		return new List<Competition>("Sélectionner une compétition", "s", 
				() -> new ArrayList<>(Inscriptions.getInscriptions().getCompetitions()),
				(element) -> editCompetition(element)
				);
	}
	
	/*
	 * Menu 
	 */
	private Menu editCompetition(Competition competition)
    {
        Menu menu = new Menu("Editer " + competition.getNom() + ((competition.inscriptionsOuvertes()) ? "" : " Inscriptions closes."), competition.getNom(), "");
        menu.add(listCompetition(competition));
        menu.add(listCandidat(competition));
        
        if(competition.inscriptionsOuvertes()) {
        if (!competition.estEnEquipe())
        	menu.add(addPersonneCompetition(competition));
        else
        	menu.add(addEquipeCompetition(competition)); 
        } 
        	
        menu.add(removeCandidat(competition));
        menu.add(editerCompetition(competition));
        menu.add(removeCompetition(competition));
        menu.addBack("b");
   		menu.setAutoBack(true);
        return menu;
    }

    // OK
	@SuppressWarnings("unused")
	private Option addCompetition(){
		return new Option("Ajouter une compétition", "a", () -> {
	            String dateCloture = InOut.getString("Entrer la date de clôture des inscriptions de la compétition (AAAA-MM-JJ) : ");
				try {
					Inscriptions.getInscriptions().createCompetition(InOut.getString("nom : "),  LocalDate.of(2019, 12, 12), InOut.getInt("0 - Compétition de personnes \n1 - Compétition d'équipes : ")==1);
				} catch (Exception e) {
					e.printStackTrace();
				}
	           });
	}

	// OK 
	private Option listCompetition(Competition competition)
	{
		return new Option("Liste des competitions", "l", () -> { 
			System.out.println(competition.getNom());
			System.out.println(competition.getDateCloture());
			System.out.println(competition.estEnEquipe());

		});
	}
	
	// OK 
	private Option listCandidat(Competition competition)
	{
		return new Option("Liste des candidats", "l", () -> { 
			System.out.println(competition.getCandidats());
		});
	}
	
	// OK 
	private List<Candidat> addPersonneCompetition(Competition competition)
	{

		return new List<>("Ajouter une personne dans la compétition", "p", 
				() -> new ArrayList<>(Inscriptions.getInscriptions().getPersonnes()),
				(index, element) -> {competition.add((Personne) element);}
				);
	}

	// OK 
	private List<Candidat> addEquipeCompetition(Competition competition)
	{
		return new List<>("Ajouter une équipe dans la compétition", "e", 
				() -> new ArrayList<>(Inscriptions.getInscriptions().getEquipes()),
				(index, element) -> {competition.add((Equipe) element);}
				);
	}
	
	// ok
	private List<Candidat> removeCandidat(Competition competition)
	{
		return new List<>("Supprimer un candidat", "s", () ->
			new ArrayList<>(competition.getCandidats()), 
			(index, element) -> {competition.remove(element);
		});	
	}
	
	// Ok
	private Option editerCompetition(Competition competition)
	{
		return new Option("Modifier une compétition", "m", 
				() -> 
				{
					competition.setNom(getString("Nouveau nom : \n"));
					competition.setDateCloture(competition.getDateCloture());
				}
		);
	}

	// Ok
	private Option removeCompetition(Competition competition)
	{
		return new Option("Supprimer une compétition", "s", 
				() -> 
				{
					competition.delete();
				}
		);
	}
	
		
		
		/*
		 * Menu Personne
		 */
		private Menu menuPersonne() {
			Menu menu = new Menu("Gestion des personnes", "p");
			// Afficher
			menu.add(listPersonne());
			// Ajouter / Creer
			menu.add(addPersonne());
			// Modifier
			menu.add(selectPersonne());
			// Option
			menu.addBack("b");
			menu.setAutoBack(true);
			return menu;
		}
		
		// OK
		private Option listPersonne(){
			return new Option("Liste des personnes", "l", () -> {System.out.println(Inscriptions.getInscriptions().getPersonnes());});

		}

		private Option addPersonne(){
			return new Option("Ajouter une nouvelle personne", "a", () -> {Inscriptions.getInscriptions().createPersonne(getString("Nom : \n"), 
																						  getString("Prénom : \n"), 
																						  getString("Mail : \n"));});
		}
		
		private Option selectPersonne(){
			return new List<Personne>("Sélectionner une personne", "s", 
				() -> new ArrayList<>(Inscriptions.getInscriptions().getPersonnes()),
				(element) -> editerPersonne(element)
				);
		}

		/*
		 * Menu Gestion Personne
		 */
		private Menu editerPersonne(Personne personne){
		    Menu menu = new Menu("Editer " + personne.getNom());
		    menu.add(editPersonne(personne));
	        menu.add(deletePersonne(personne));
		    menu.addBack("q");
	   		menu.setAutoBack(true);
		    return menu;
		}

		private Option editPersonne(Personne personne){
			return new Option("Modifier une personne", "a", () -> {
			
			personne.setNom(getString("Nouveau nom : \n"));
			personne.setPrenom(getString("Nouveau prenom : \n"));
			personne.setMail(getString("Nouveau mail : \n"));

			});
	}
	
	private Option deletePersonne(Personne personne)
	{
		return new Option("Supprimer une personne", "b", () -> {personne.delete();});
	}

	
		
	/*
	 * Main
	 */
	public static void main(String[] args)
	{
		MainUser menu = new MainUser();
				 menu.start();
	}
}