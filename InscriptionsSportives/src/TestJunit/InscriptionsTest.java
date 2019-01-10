package TestJunit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import inscriptions.Inscriptions;
import inscriptions.Personne;

public class InscriptionsTest {

	
	@Test
	public void testCreatePersonne() {
	Inscriptions inscr = Inscriptions.getInscriptions();
	Personne Brahim = inscr.createPersonne("Brahim", "Mlaghui", "bra@gmail.com"),
			Ihcen = inscr.createPersonne("Ihcen", "Borgi", "ihcen@me.com");
	
	assertTrue(Brahim.getNom(), Ihcen.getNom().equals("Ihcen"));
	
	}
	
}
