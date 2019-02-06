package inscriptions;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Candidat à un événement sportif, soit une personne physique, soit une équipe.
 *
 */

public abstract class Candidat implements Comparable<Candidat>, Serializable
{
	private static final long serialVersionUID = -6035399822298694746L;
	private static Inscriptions inscriptions;
	private static Candidat candidat;
	private static String nom;
	private static Set<Competition> competitions;
	
	Candidat(Inscriptions inscriptions, String nom)
	{
		Candidat.inscriptions = inscriptions;
		
		Candidat.nom = nom;
		competitions = new TreeSet<>();
	}

	/**
	 * Retourne le nom du candidat.
	 * @return
	 */
	
	public static String getNom()
	{
		return nom;
	}

	/**
	 * Modifie le nom du candidat.
	 * @param nom
	 */
	
	public static void setNom(String nom)
	{
		Candidat.nom = nom;
	}

	/**
	 * Retourne toutes les compétitions auxquelles ce candidat est inscrit.s
	 * @return
	 */

	public static Set<Competition> getCompetitions()
	{
		SortedSet<Competition> competitions = new TreeSet<>();
		return Collections.unmodifiableSet(competitions);
	}
	
	boolean add(Competition competition)
	{
		return competitions.add(competition);
	}

	boolean remove(Competition competition)
	{
		return competitions.remove(competition);
	}

	/**
	 * Supprime un candidat de l'application.
	 */
	
	public static void delete()
	{
		for (Competition c : competitions)
			c.remove(candidat);
		inscriptions.delete(candidat);
	}
	
	@Override
	public int compareTo(Candidat o)
	{
		return getNom().compareTo(o.getNom());
	}
	
	@Override
	public String toString()
	{
		return "\n" + getNom() + " -> inscrit à " + getCompetitions();
	}
}
