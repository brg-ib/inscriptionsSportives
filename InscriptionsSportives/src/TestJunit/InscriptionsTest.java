package TestJunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import inscriptions.Inscriptions;
import inscriptions.Personne;

public class InscriptionsTest {
	
	@Test
	public void setUp() throws Exception {
	Inscriptions inscr = Inscriptions.getInscriptions();
	Personne Brahim = inscr.createPersonne("Mlaghui", "Brahim", "bra@gmail.com"),
			Ihcen = inscr.createPersonne("Borgi", "Ihcen", "ihcen@me.com");

	assertTrue(Brahim.getPrenom(), Brahim.getPrenom().equals("Brahim"));
	assertTrue(Brahim.getNom(), Brahim.getNom().equals("Mlaghui"));
	assertTrue(Brahim.getMail(), Brahim.getMail().equals("bra@gmail.com"));
	
	Brahim.setPrenom("Dany");
	Ihcen.setPrenom("Philippe");
	assertEquals("Dany", Brahim.getPrenom());
	assertEquals("Philippe", Ihcen.getPrenom());
	
	Brahim.setNom("Boon");
	Ihcen.setNom("Auguste");
	assertEquals("Boon", Brahim.getNom());
	assertEquals("Auguste", Ihcen.getNom());
	
	
	}
	
	@Test
	public void testSetPrenom() {

	}
	
	@Test
	public void testSetNom() {
	
	}
	
	@Test
	public void testSetMail() {
	
	}
	
	
}
