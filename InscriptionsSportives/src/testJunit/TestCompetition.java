package testJunit;

import org.junit.*;

import static org.junit.Assert.*;

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
	
	// Edite et test le nom d'une competition
	c2.setNom("Boxe");
	assertEquals("Poker", c1.getNom());
	assertEquals("Boxe", c2.getNom());
	// Edite et test la dateCloture
	c1.setDateCloture(LocalDate.of(2033, 04, 29));
	assertEquals(LocalDate.of(2033, 04, 29),c1.getDateCloture());
	// Test inscriptionsOuvertes
	assertTrue(c1.inscriptionsOuvertes());
	assertFalse(c2.inscriptionsOuvertes());
	// Test addPersonne et removePersonne
	c1.add(p1);
	assertTrue(c1.getCandidats().contains(p1));
	c1.remove(p1);
	assertFalse(c1.getCandidats().contains(p1));
	// Test estEnEquipe
	assertTrue(c2.estEnEquipe());
	assertFalse(c1.estEnEquipe());
	
	}
}
