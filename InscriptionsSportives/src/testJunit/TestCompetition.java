package testJunit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

public class TestCompetition {

	private LocalDate datecloture = LocalDate.of(2021, 11, 11);
	private LocalDate datecloture2 = LocalDate.of(2018, 04, 29);
	
	@Test
	public void setUp() throws Exception {
	
	Inscriptions inscr = Inscriptions.getInscriptions();

	Competition c1 = inscr.createCompetition("Poker", datecloture, false);
	Competition c2 = inscr.createCompetition("Billard", datecloture2, true);
	
	Personne p1 = inscr.createPersonne("Robert","DeNiro","deniro.Robert@youtalkingtome.com");
	Personne p2 = inscr.createPersonne("Marlon","Brando","marlon.brando@thgodfhater.com");

	Equipe e1 = inscr.createEquipe("Gangs");
	Equipe e2 = inscr.createEquipe("Bulls");
	
	assertEquals("Poker", c1.getNom());
	assertEquals("Billard", c2.getNom());
	assertTrue(c1.inscriptionsOuvertes());
	assertTrue(c2.inscriptionsOuvertes());
	
	}
}
