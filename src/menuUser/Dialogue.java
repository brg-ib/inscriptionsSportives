package menuUser;

import java.io.IOException;
import java.time.LocalDate;

import inscriptions.*;
import java.util.ArrayList;

import hibernate.Passerelle;

import commandLineMenus.*;
import commandLineMenus.rendering.examples.util.InOut;
import static commandLineMenus.rendering.examples.util.InOut.*;


/**
 * Dialogue utilisateur 
 * CommandLine
 * 
 *
 */
public class Dialogue {
	
	
	private Inscriptions inscriptions;
	
	public Dialogue(Inscriptions inscriptions)
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
	
	
	/**
	 * Menu de l'application
	 * @return
	 */
	private Menu menuCompetitions()
	{
		Menu menu = new Menu("Gérer les compétitions", "c");
		menu.add(afficherCompetitions());
		menu.add(ajouterCompetition());
		menu.add(selectionnerCompetition());
		menu.add(sauvegarder());
		menu.addBack("q");
		return menu;
	}
	
	private Menu menuEquipes()
	{
		Menu menu = new Menu("Gérer les équipes", "e");
		menu.add(afficherEquipes());
		menu.add(ajouterEquipe());
		menu.add(selectionnerEquipe());
		menu.add(sauvegarder());
		menu.addBack("q");
		return menu;
	}
	
	private Menu menuPersonnes()
	{
		Menu menu = new Menu("Gérer les personnes", "p");
		menu.add(afficherPersonnes());
		menu.add(ajouterPersonne());
		menu.add(selectionnerPersonne());
		menu.add(sauvegarder());
		menu.addBack("q");
		return menu;
	}

	
	/**
	 * Affiche les objets slectionnés
	 * @return Option
	 */
	private Option afficherCompetitions()
	{
		return new Option("Afficher les compétitions", "l", () -> {
			for(Competition c : Passerelle.getCompetition()) {
				System.out.println(c);
			};
		});
	}
	
	private Option afficherEquipes()
	{
		return new Option("Afficher les équipes", "l", () -> {
			for(Equipe e : Passerelle.getEquipe()) {
				System.out.println(e);
			};
		});
	}
	
	private Option afficherPersonnes()
	{
		return new Option("Afficher les personnes", "l", () -> {
			for(Personne p : Passerelle.getPersonne()) {
				System.out.println(p);
			};
		});
	}
	
	
	/**
	 * Ajoute l'objet selectionné 
	 * @return
	 */
	private Option ajouterCompetition()
	{
		return new Option("Ajouter une compétition", "a", () -> {
			Passerelle.save(inscriptions.createCompetition(getString("Nom : "), 
				LocalDate.of(getInt("Année : "), getInt("Mois : "), getInt("Jour : ")), 
				  InOut.getInt("Choisir :\n0 - Compétition de personnes \n1 - Compétition d'équipes : ")==1));
		});
	}
	
	private Option ajouterEquipe()
	{
		return new Option("Ajouter une équipe", "a", () -> {
			Passerelle.save(inscriptions.createEquipe(getString("Entrez le nom de votre équipe : ")));});
	}
	
	private Option ajouterPersonne()
	{
		return new Option("Ajouter une personne", "a", () -> {
			Passerelle.save(inscriptions.createPersonne(getString("Entrez le nom de votre personne : "), 
														getString("Entrez le prenom de votre personne : "), 
														getString("Entrez le mail de votre personne : ")));});
	}

	
	
	/**
	 * Selectionner l'objet concerné
	 * @return
	 */
	private List<Competition> selectionnerCompetition()
	{
		return new List<Competition>("Sélectionner une compétition", "e", 
				() -> new ArrayList<>(Passerelle.getCompetition()),
				(element) -> editerCompetition(element)
				);
	}
	
	private List<Equipe> selectionnerEquipe()
	{
		return new List<Equipe>("Sélectionner une équipe", "e", 
				() -> new ArrayList<>(Passerelle.getEquipe()),
				(element) -> editerEquipe(element)
				);
	}
	
	private List<Personne> selectionnerPersonne()
	{
		return new List<Personne>("Sélectionner une personne", "e", 
				() -> new ArrayList<>(Passerelle.getPersonne()),
				(element) -> editerPersonne(element)
				);
	}
	
	
	/**
	 * 
	 * @param competition
	 * @return
	 */
	private Menu editerCompetition(Competition competition)
    {
        Menu menu = new Menu("Editer " + competition.getNom() + ((competition.inscriptionsOuvertes()) ? "" : " Inscriptions closes !"), competition.getNom(), "");
        menu.add(afficherCompetition(competition));
        menu.add(afficherCandidats(competition));
        
        if(competition.inscriptionsOuvertes()) {
	        if (!competition.estEnEquipe()) {
	        	menu.add(ajouterPersonneCompetition(competition));
	        	//Passerelle.save(competition);
	        }
	        else {
	        	menu.add(ajouterEquipeCompetition(competition)); 
	        	//Passerelle.save(competition);
	        }
        } 
        	
        menu.add(supprimerCandidat(competition));
        menu.add(modifierNomCompetition(competition));
        menu.add(modifierDateCompetition(competition));
        menu.add(supprimerCompetition(competition));
        menu.add(sauvegarder());
        menu.addBack("q");
        return menu;
    }
	
	private Option afficherCompetition(final Competition competition)
	{
		return new Option("Afficher la compétition", "lc", 
				() -> 
				{	
					System.out.println(competition.getNom()+" - "
								+competition.getDateCloture()+" - "
								+competition.estEnEquipe());
					Passerelle.save(competition);
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
		return new List<>("Ajouter un candidat dans la compétition", "m", 
				() -> new ArrayList<>(inscriptions.getPersonnes()),
				(index, element) -> {Passerelle.save(competition.add((Personne) element));}
				);
	}
	
	private List<Candidat> ajouterEquipeCompetition(final Competition competition)
	{
		return new List<>("Ajouter une équipe dans la compétition", "e", 
				() -> new ArrayList<>(Passerelle.getEquipe()),
				(index, element) -> {Passerelle.save(competition.add((Equipe) element));}
				);
	}
	
	private List<Candidat> supprimerCandidat(final Competition competition)
	{
		return new List<>("Supprimer un candidat", "s", 
				() -> new ArrayList<>(competition.getCandidats()),
				(index, element) -> {Passerelle.delete(competition.remove(element));}
				);
	}
	
	private Option modifierNomCompetition(final Competition competition)
	{
		return new Option("modifier le nom de la compétition", "c", 
				() -> 
				{
					competition.setNom(getString("Nouveau nom : \n"));
					Passerelle.save(competition);
				}
		);
	}
	
	private Option modifierDateCompetition(final Competition competition)
	{
		return new Option("modifier la date de la compétition", "md", 
				() -> {
					competition.setDateCloture(LocalDate.of(getInt("Année : "), getInt("Mois : "), getInt("Jour : ")));
					});
	}
	
	private Option supprimerCompetition(final Competition competition)
	{
		return new Option("Supprimer la compétition", "d", 
				() -> 
				{
					competition.delete();
					Passerelle.delete(competition);;
				}
		);
	}
	

	
	/**
	 * Menu Edition 
	 * @param equipe
	 * @return
	 */
	private Menu editerEquipe(Equipe equipe)
    {
        Menu menu = new Menu("Editer " + equipe.getNom());
        menu.add(afficherMembres(equipe));
        menu.add(ajouterMembre(equipe));
        menu.add(supprimerMembre(equipe));
        menu.add(supprimerEquipe(equipe));
        menu.add(sauvegarder());
        menu.addBack("q");
        return menu;
    }
	
	
	private Option afficherMembres(final Equipe equipe)
	{
		return new Option("Afficher les membres", "a", 
				() -> 
				{
					System.out.println(equipe.getMembres());
				}
		);
	}
	
	private List<Personne> ajouterMembre(final Equipe equipe)
	{
		return new List<>("Ajouter un membre", "m", 
				() -> new ArrayList<>(Passerelle.getPersonne()),
				(index, element) -> {Passerelle.save(equipe.add(element));}
				);
	}
	
	private List<Personne> supprimerMembre(final Equipe equipe)
	{
		return new List<>("Supprimer un membre", "s", 
				() -> new ArrayList<>(equipe.getMembres()),
				(index, element) -> {Passerelle.delete(equipe.remove(element));}
				);
	}
	
	private Option supprimerEquipe(final Equipe equipe)
	{
		return new Option("Supprimer l'équipe", "d", 
				() -> 
				{
					equipe.delete();
					Passerelle.delete(equipe);
				}
		);
	}
	
	
	
	// Selectionner : Personne
	
	private Menu editerPersonne(Personne personne)
	{
	    Menu menu = new Menu("Editer " + personne.getNom());
	    menu.add(modifierPersonne(personne));
        menu.add(supprimerPersonne(personne));
        menu.add(sauvegarder());
	    menu.addBack("q");
	    return menu;
	}
	
	private Option modifierPersonne(Personne personne)
	{
		return new Option("Modifier une personne", "a", () -> {
			
			personne.setNom(getString("Nouveau nom : "));
			personne.setPrenom(getString("Nouveau prenom : "));
			personne.setMail(getString("Nouveau mail : "));
			Passerelle.save(personne);
			
		});
	}
	
	private Option supprimerPersonne(Personne personne)
	{
		return new Option("Supprimer la personne", "b", () -> {personne.delete();
		Passerelle.delete(personne);
		});
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
	

	/**
	 * Sauvegarder 
	 * @return
	 */
	private Option sauvegarder()
    {
        return new Option("Sauvegarder", "x", 
                () -> 
                {
                    try
                    {
    					System.out.print("Sauvegarde en cours...");
                        inscriptions.sauvegarder();
    					System.out.println("réussie.");

                    } 
                    catch (IOException e)
                    {
                        System.out.println("Impossible d'effectuer une sauvegarde");
                    }
                }
            );
    }
	
	
	
}
