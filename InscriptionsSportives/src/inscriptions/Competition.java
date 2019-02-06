package inscriptions;

import java.io.Serializable;
import java.util.Collections;
import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

/**
 * Représente une compétition, c'est-à-dire un ensemble de candidats 
 * inscrits à un événement, les inscriptions sont closes à la date dateCloture.
 *
 */

public class Competition implements Comparable<Competition>, Serializable
{
	private static final long serialVersionUID = -2882150118573759729L;
	private static Inscriptions inscriptions;
	private static Competition competition;
	private static String nom;
	private static Set<Candidat> candidats;
	private static LocalDate dateCloture;
	private boolean enEquipe = false;

	Competition(Inscriptions inscriptions, String nom, LocalDate dateCloture, boolean enEquipe)
	{
		this.enEquipe = enEquipe;
		Competition.inscriptions = inscriptions;
		Competition.nom = nom;
		this.dateCloture = dateCloture;
		candidats = new TreeSet<>();
	}
	
	/**
	 * Retourne le nom de la compétition.
	 * @return
	 */
	
	public String getNom()
	{
		return nom;
	}
	
	/**
	 * Modifie le nom de la compétition.
	 */
	
	public static void setNom(String nom)
	{
		Competition.nom = nom ;
	}
	
	/**
	 * Retourne vrai si les inscriptions sont encore ouvertes, 
	 * faux si les inscriptions sont closes.
	 * @return
	 */
	
	public boolean inscriptionsOuvertes()
	{
		// TODO retourner vrai si et seulement si la date système est antérieure à la date de clôture.
		
		return getDateCloture().isAfter(LocalDate.now());
		
	}
	
	/**
	 * Retourne la date de cloture des inscriptions.
	 * @return
	 */
	
	public static LocalDate getDateCloture()
	{
		return dateCloture;
	}
	
	/**
	 * Est vrai si et seulement si les inscriptions sont réservées aux équipes.
	 * @return
	 */
	
	public boolean estEnEquipe()
	{
		return enEquipe;
	}
	
	/**
	 * Modifie la date de cloture des inscriptions. Il est possible de la reculer 
	 * mais pas de l'avancer.
	 * @param dateCloture
	 */
	
	public void setDateCloture(LocalDate dateCloture)
	{
		// TODO vérifier que l'on avance pas la date.
		if (getDateCloture().isBefore(dateCloture))
			this.dateCloture = dateCloture;
		else
			throw new RuntimeException("Impossible de modifier la date.");
	}
	
	/**
	 * Retourne l'ensemble des candidats inscrits.
	 * @return
	 */
	
	public static Set<Candidat> getCandidats()
	{
		return Collections.unmodifiableSet(candidats);
	}
	
	/**
	 * Inscrit un candidat de type Personne à la compétition. Provoque une
	 * exception si la compétition est réservée aux équipes ou que les 
	 * inscriptions sont closes.
	 * @param personne
	 * @return
	 */
	
	public boolean add(Personne personne)
	{
		// TODO vérifier que la date de clôture n'est pas passée
		if (enEquipe || ! inscriptionsOuvertes())
			throw new RuntimeException("Impossbile d'ajouter une personne.");
		personne.add(this);
		return candidats.add(personne);
	}

	/**
	 * Inscrit un candidat de type Equipe à la compétition. Provoque une
	 * exception si la compétition est réservée aux personnes ou que 
	 * les inscriptions sont closes.
	 * @param personne
	 * @return
	 */

	public boolean add(Equipe equipe)
	{
		// TODO vérifier que la date de clôture n'est pas passée
		if (!enEquipe || !inscriptionsOuvertes())
			throw new RuntimeException("Impossible d'ajouter une equipe.");
		equipe.add(this);
		return candidats.add(equipe);
	}
	
	/**
	 * Retourne les Candidats que l'on peut inscrire à cette competition.
	 * @return les candidats que l'on peut inscrire à cette compétition.
	 */
	
	public Set<Candidat> getCandidatsAInscrire()
	{
		// TODO les candidats que l'on peut inscrire à cette compétition.
		Set<Candidat> CandidatsAInscrire = new TreeSet<>();
		for (Candidat candidats : inscriptions.getCandidats())
			if (!(getCandidats()).contains(candidats))
				CandidatsAInscrire.add(candidats);
		return CandidatsAInscrire;
	}
	
	/**
	 * Désinscrit un candidat.
	 * @param candidat
	 * @return
	 */
	
	public static boolean remove(Candidat candidat)
	{
		candidat.remove(competition);
		return candidats.remove(candidat);
	}
	
	/**
	 * Supprime la compétition de l'application.
	 */
	
	public static void delete()
	{
		for (Candidat candidat : candidats)
			remove(candidat);
		inscriptions.delete(competition);
	}
	
	@Override
	public int compareTo(Competition o)
	{
		return getNom().compareTo(o.getNom());
	}
	
	@Override
	public String toString()
	{
		return getNom();
	}
}
