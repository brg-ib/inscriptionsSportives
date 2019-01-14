package testJunit;

import org.junit.*;

import static org.junit.Assert.*;

import java.time.LocalDate;

import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

public class TestCompetition {

	private Inscriptions inscr = Inscriptions.getInscriptions();
	private Personne p1,p2;
	private Competition c1, c2;
	private Equipe e1, e2;
	private LocalDate datecloture = LocalDate.of(2021, 11, 11);
	private LocalDate datecloture2 = LocalDate.of(2018, 04, 29);
	
	@Before
	public void setUp() throws Exception {		
		
		c1 = inscr.createCompetition("Poker", datecloture, false);
		c2 = inscr.createCompetition("Billard", datecloture2, true);
		p1 = inscr.createPersonne("Robert","DeNiro","deniro.Robert@youtalkingtome.com");
		p2 = inscr.createPersonne("Marlon","Brando","marlon.brando@thgodfhater.com");
		e1 = inscr.createEquipe("Gangs");
		e2 = inscr.createEquipe("Bulls");
				
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

	@Test
	public void testSetNom() {
		c2.setNom("Boxe");
		assertEquals("Boxe", c2.getNom());
		assertEquals("Poker", c1.getNom());
	}

	@Ignore
	@Test
	public void test2() {
		
	}
	
	@Ignore
	@Test
	public void test3() {
		
	}
	
	@Ignore
	@Test
	public void test4() {
		
	}
}
