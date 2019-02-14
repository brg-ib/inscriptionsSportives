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
        menu.add(menuEquipe());
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
        return new Option("Liste des compétitions", "l", () -> {
        	System.out.println("Liste des Competitions :");
        	System.out.println(Inscriptions.getInscriptions().getCompetitions());});
    }
    
    // OK
    private List<Competition> selectCompetition(){
        return new List<Competition>("Sélectionner une compétition", "s",
        () -> new ArrayList<>(Inscriptions.getInscriptions().getCompetitions()),
        (element) -> editCompetition(element)
        );
    }
    
    /*
    * Menu Gestion Competition
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
        	
        	
        	try {
                Inscriptions.getInscriptions().createCompetition(InOut.getString("nom : "), LocalDate.of(InOut.getInt("Annee:"),InOut.getInt("Mois:"),InOut.getInt("Jour:")), InOut.getInt("0 - Compétition Seul \n1 - Compétition en Equipe : ") == 1);
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
        return new Option("Liste des candidats", "z", () -> {
            System.out.println(competition.getCandidats());
        });
    }
    
    // OK
    private List<Candidat> addPersonneCompetition(Competition competition)
    {
        
        return new List<>("Ajouter une personne dans la compétition", "p",
        () -> new ArrayList<>(Inscriptions.getInscriptions().getCandidats()),
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
        return new Option("Supprimer une compétition", "ss",
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
    * Menu Equipe
    */
    
    private Menu menuEquipe() {
        Menu menu = new Menu("Gestion des equipes", "e");
        // Afficher
        menu.add(listEquipe());
        // Ajouter / Creer
        menu.add(addEquipe());
        // Modifier
        menu.add(selectEquipe());
        // Option
        menu.addBack("b");
        menu.setAutoBack(true);
        return menu;
    }
    
    //      * Retourne l'ensemble des personnes formant l'équipe.
    
    private Option listEquipe(){
        return new Option("Liste des équipes", "l", () -> {System.out.println(Inscriptions.getInscriptions().getEquipes());});
        
    }
    
    private Option addEquipe(){
        return new Option("Ajouter une nouvelle équipe", "a", () -> {Inscriptions.getInscriptions().createEquipe(getString("Nom de l'équipe : \n"));});
    }
    
    
    private List<Equipe> selectEquipe(){
        return new List<Equipe>("Sélectionner une équipe","e", () -> new ArrayList<>(Inscriptions.getInscriptions().getEquipes()),
        (element) -> editerEquipe(element)
        );
    }
    
    /*
    * Menu Gestion Equipe
    */
    
    
    private Menu editerEquipe(Equipe equipe)
    {
        Menu menu = new Menu("Editer " + equipe.getNom());
        menu.add(listMembres(equipe));
        menu.add(addMembre(equipe));
        menu.add(deleteMembre(equipe));
        menu.add(deleteEquipe(equipe));
        menu.addBack("q");
        menu.setAutoBack(true);
        return menu;
    }
    
    private Option listMembres(Equipe equipe)
    {
        return new Option("Afficher l'équipe", "a",
        () ->
        {
            System.out.println(equipe.getMembres());
        }
        );
    }
    
    private List<Personne> addMembre(Equipe equipe)
    {
        return new List<>("Ajouter un membre", "m",
        () -> new ArrayList<>(Inscriptions.getInscriptions().getPersonnes()),
        (index, element) -> {equipe.add(element);}
        );
    }
    
    private List<Personne> deleteMembre(Equipe equipe)
    {
        return new List<>("Supprimer un membre", "s",
        () -> new ArrayList<>(equipe.getMembres()),
        (index, element) -> {equipe.remove(element);}
        );
    }
    
    private Option deleteEquipe(final Equipe equipe)
    {
        return new Option("Supprimer l'équipe", "d",
        () ->
        {
            equipe.delete();
        }
        );
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