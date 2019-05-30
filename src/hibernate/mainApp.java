package hibernate;

import menuUser.Dialogue;

public class mainApp{ 
	
	public static void main(String[] args) {
	Passerelle.open();
	
	Dialogue.main();    
	
	Passerelle.close();
	System.out.println("Application fermée.");
	}

	/**
	 * Tache à finir Hibernate;
	 * Ajouter personne(membre) dans une equipe
	 * Ajouter candidat à une competition
	 *
	 * 
	 * 
	 */
}