package menuUser;

import java.io.IOException;
import java.time.LocalDate;

import inscriptions.*;
import java.util.ArrayList;

import commandLineMenus.*;
import commandLineMenus.rendering.examples.util.InOut;
import static commandLineMenus.rendering.examples.util.InOut.*;

public class DialogueMain {
	
	
	private Inscriptions inscriptions;
	
	public DialogueMain(Inscriptions inscriptions)
	{
		this.inscriptions = inscriptions;
	}
	
	public void start()
	{
		menuPrincipal().start();
	}
	
	private Menu menuPrincipal()
	{
		Menu menu = new Menu("Gestion des inscriptions sportives");
		menu.add(menuCompetitions());
		menu.add(menuEquipes());
		menu.add(menuPersonnes());
		menu.add(menuQuitter());
		return menu;
	}

	private Menu menuQuitter()
	{
		Menu menu = new Menu("Quitter", "q");
		menu.add(quitterEtEnregistrer());
		menu.add(quitterSansEnregistrer());
		menu.addBack("r");
		return menu;
	}
	
	
	
	// Menus
	private Menu menuCompetitions()
	{
		Menu menu = new Menu("Gérer les compétitions", "c");
		menu.add(afficherCompetitions());
		menu.add(ajouterCompetition());
		menu.add(selectionnerCompetition());
		menu.addBack("q");
		return menu;
	}
	
	private Menu menuEquipes()
	{
		Menu menu = new Menu("Gérer les équipes", "e");
		menu.add(afficherEquipes());
		menu.add(ajouterEquipe());
		menu.add(selectionnerEquipe());
		menu.addBack("q");
		return menu;
	}
	
	private Menu menuPersonnes()
	{
		Menu menu = new Menu("Gérer les personnes", "p");
		menu.add(afficherPersonnes());
		menu.add(ajouterPersonne());
		menu.add(selectionnerPersonne());
		menu.addBack("q");
		return menu;
	}

	
	// Affichages
	private Option afficherCompetitions()
	{
		return new Option("Afficher les compétitions", "l", () -> {System.out.println(inscriptions.getCompetitions());});
	}
	
	private Option afficherEquipes()
	{
		return new Option("Afficher les équipes", "l", () -> {System.out.println(inscriptions.getEquipes());});
	}
	
	private Option afficherPersonnes()
	{
		return new Option("Afficher les personnes", "l", () -> {System.out.println(inscriptions.getPersonnes());});
	}
	
	
	// Ajouts
	private Option ajouterCompetition()
	{
		return new Option("Ajouter une compétition", "a", () -> {inscriptions.createCompetition(getString("Entrez le nom de : "), 
				LocalDate.of(getInt("Année : "), getInt("Mois : "), getInt("Jour : ")), 
				  InOut.getInt("Choisir :\n0 - Compétition de personnes \n1 - Compétition d'équipes : ")==1);});
	}
	
	private Option ajouterEquipe()
	{
		return new Option("Ajouter une équipe", "a", () -> {inscriptions.createEquipe(getString("Entrez le nom de votre équipe : "));});
	}
	
	private Option ajouterPersonne()
	{
		return new Option("Ajouter une personne", "a", () -> {inscriptions.createPersonne(getString("Entrez le nom de votre personne : "), 
																						  getString("Entrez le prenom de votre personne : "), 
																						  getString("Entrez le mail de votre personne : "));});
	}

	
	
	// Selections
	private List<Competition> selectionnerCompetition()
	{
		return new List<Competition>("Sélectionner une compétition", "e", 
				() -> new ArrayList<>(inscriptions.getCompetitions()),
				(element) -> editerCompetition(element)
				);
	}
	
	private List<Equipe> selectionnerEquipe()
	{
		return new List<Equipe>("Sélectionner une équipe", "e", 
				() -> new ArrayList<>(inscriptions.getEquipes()),
				(element) -> editerEquipe(element)
				);
	}
	
	private List<Personne> selectionnerPersonne()
	{
		return new List<Personne>("Sélectionner une personne", "e", 
				() -> new ArrayList<>(inscriptions.getPersonnes()),
				(element) -> editerPersonne(element)
				);
	}
	
	
	
	// Selectionner : Competition
	private Menu editerCompetition(Competition competition)
    {
        Menu menu = new Menu("Editer " + competition.getNom() + ((competition.inscriptionsOuvertes()) ? "" : " Inscriptions closes !"), competition.getNom(), "");
        menu.add(afficherCompetition(competition));
        menu.add(afficherCandidats(competition));
        
        if(competition.inscriptionsOuvertes()) {
        if (!competition.estEnEquipe())
        	menu.add(ajouterPersonneCompetition(competition));
        else
        	menu.add(ajouterEquipeCompetition(competition)); 
        } 
        	
        menu.add(supprimerCandidat(competition));
        menu.add(modifierCompetition(competition));
        menu.add(supprimerCompetition(competition));
        menu.addBack("q");
        return menu;
    }
	
	private Option afficherCompetition(final Competition competition)
	{
		return new Option("Afficher la compétition", "lc", 
				() -> 
				{
					System.out.println(competition.getNom());
					System.out.println(competition.getDateCloture());
					System.out.println(competition.estEnEquipe());
				}
		);
	}
	
	private Option afficherCandidats(final Competition competition)
	{
		return new Option("Afficher les candidats", "a", 
				() -> 
				{
					System.out.println(competition.getCandidats());
				}
		);
	}
	
	private List<Candidat> ajouterPersonneCompetition(final Competition competition)
	{
		return new List<>("Ajouter une personne dans la compétition", "m", 
				() -> new ArrayList<>(inscriptions.getPersonnes()),
				(index, element) -> {competition.add((Personne) element);}
				);
	}
	
	private List<Candidat> ajouterEquipeCompetition(final Competition competition)
	{
		return new List<>("Ajouter une équipe dans la compétition", "e", 
				() -> new ArrayList<>(inscriptions.getEquipes()),
				(index, element) -> {competition.add((Equipe) element);}
				);
	}
	
	private List<Candidat> supprimerCandidat(final Competition competition)
	{
		return new List<>("Supprimer un candidat", "s", 
				() -> new ArrayList<>(competition.getCandidats()),
				(index, element) -> {competition.remove(element);}
				);
	}
	
	private Option modifierCompetition(final Competition competition)
	{
		return new Option("modifier une compétition", "c", 
				() -> 
				{
					competition.setNom(getString("Nouveau nom : \n"));
					competition.setDateCloture(competition.getDateCloture());
				}
		);
	}
	
	private Option supprimerCompetition(final Competition competition)
	{
		return new Option("Supprimer une compétition", "d", 
				() -> 
				{
					competition.delete();
				}
		);
	}
	

	
	// Selectionner : Equipe
	private Menu editerEquipe(Equipe equipe)
    {
        Menu menu = new Menu("Editer " + equipe.getNom());
        menu.add(afficherMembres(equipe));
        menu.add(ajouterMembre(equipe));
        menu.add(supprimerMembre(equipe));
        menu.add(supprimerEquipe(equipe));
        menu.addBack("q");
        return menu;
    }
	
	private Option afficherMembres(final Equipe equipe)
	{
		return new Option("Afficher l'équipe", "a", 
				() -> 
				{
					System.out.println(equipe.getMembres());
				}
		);
	}
	
	private List<Personne> ajouterMembre(final Equipe equipe)
	{
		return new List<>("Ajouter un membre", "m", 
				() -> new ArrayList<>(inscriptions.getPersonnes()),
				(index, element) -> {equipe.add(element);}
				);
	}
	
	private List<Personne> supprimerMembre(final Equipe equipe)
	{
		return new List<>("Supprimer un membre", "s", 
				() -> new ArrayList<>(equipe.getMembres()),
				(index, element) -> {equipe.remove(element);}
				);
	}
	
	private Option supprimerEquipe(final Equipe equipe)
	{
		return new Option("Supprimer l'équipe", "d", 
				() -> 
				{
					equipe.delete();
				}
		);
	}
	
	
	
	// Selectionner : Personne
	
	private Menu editerPersonne(Personne personne)
	{
	    Menu menu = new Menu("Editer " + personne.getNom());
	    menu.add(modifierPersonne(personne));
        menu.add(supprimerPersonne(personne));
	    menu.addBack("q");
	    return menu;
	}
	
	private Option modifierPersonne(Personne personne)
	{
		return new Option("Modifier une personne", "a", () -> {
			
			personne.setNom(getString("Nouveau nom : "));
			personne.setPrenom(getString("Nouveau prenom : "));
			personne.setMail(getString("Nouveau mail : "));
			
		});
	}
	
	private Option supprimerPersonne(Personne personne)
	{
		return new Option("Supprimer la personne", "b", () -> {personne.delete();});
	}
	

	
	
	// Quitter
	
	
	
	private Option quitterEtEnregistrer()
    {
        return new Option("Quitter et enregistrer", "q", 
                () -> 
                {
                    try
                    {
                        inscriptions.sauvegarder();
                        Action.QUIT.optionSelected();
                    } 
                    catch (IOException e)
                    {
                        System.out.println("Impossible d'effectuer la sauvegarde");
                    }
                }
            );
    }
	
	private Option quitterSansEnregistrer()
	{
		return new Option("Quitter sans enregistrer", "a", Action.QUIT);
	}
	
	
	
	// Main 
	public static void main(String[] args)
    {
        Inscriptions inscriptions = Inscriptions.getInscriptions();
        DialogueMain dial = new DialogueMain(inscriptions);
        dial.start();
    }
}
