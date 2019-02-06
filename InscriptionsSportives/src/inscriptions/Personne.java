package inscriptions;

import java.util.Collections;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Représente une personne physique pouvant s'inscrire à une compétition.
 */

public class Personne extends Candidat
{
	private static final long serialVersionUID = 4434646724271327254L;
	private static String prenom;
	private static String mail;
	private static Set<Equipe> equipes;
	
	Personne(Inscriptions inscriptions, String nom, String prenom, String mail)
	{
		super(inscriptions, nom);
		Personne.prenom = prenom;
		Personne.mail = mail;
		equipes = new TreeSet<>();
	}

	/**
	 * Retourne le prénom de la personne.
	 * @return
	 */
	
	public static String getPrenom()
	{
		return prenom;
	}

	/**
	 * Modifie le prénom de la personne.
	 * @param prenom
	 */
	
	public static void setPrenom(String prenom)
	{
		Personne.prenom = prenom;
	}

	/**
	 * Retourne l'adresse électronique de la personne.
	 * @return
	 */
	
	public static String getMail()
	{
		return mail;
	}

	/**
	 * Modifie l'adresse électronique de la personne.
	 * @param mail
	 */
	
	public static void setMail(String mail)
	{
		Personne.mail = mail;
	}

		
	/**
	 * Retoure les équipes dont cette personne fait partie.
	 * @return
	 */
	
	
	public static Set<Equipe> getEquipes()
	{
//		return Collections.unmodifiableSet(equipes);
		SortedSet<Equipe> equipes = new TreeSet<>();
//		for (Personne c : Personne())
//			if (c instanceof Inscription.Equipe)
//				equipes.add((Inscription.Equipe)c);
		return Collections.unmodifiableSortedSet(equipes);
	}
	
	boolean add(Equipe equipe)
	{
		return equipes.add(equipe);
	}

	boolean remove(Equipe equipe)
	{
		return equipes.remove(equipe);
	}
	
	@Override
	public static void delete()
	{
		
		for (Equipe e : equipes)
			e.remove(this);
		Candidat.delete();
	}
	
	@Override
	public String toString()
	{
		return super.toString() + " membre de " + equipes.toString();
	}
}
