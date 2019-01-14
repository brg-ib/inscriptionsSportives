package testJunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.*;

import org.junit.*;

import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

public class TestEquipe {
	
	private Inscriptions inscr = Inscriptions.getInscriptions();; 
	private Personne personne;
	private Equipe equipe1;

	
	@Before // avec cette annotation, cette méthode sera appelée avant chaque test
	public void setUp() throws Exception {
		 personne = inscr.createPersonne("Mlaghui", "Brahim", "bra@gmail.com");
		 equipe1 = inscr.createEquipe("Equipe de Poker");
	}
	
	@Test
	public void testGetMembres() {
		assertEquals("Brahim", personne.getPrenom());	
	}
	
	@Test
	public void testGetPeronnesAAjouter() {
		personne.setPrenom("Dany");
		assertEquals("Dany", personne.getPrenom());
	}
	
	@Test
	public void testSetNom() {
		personne.setNom("Boon");
		assertEquals("Boon", personne.getNom());
	}

	@Test
	public void testGetNom() {
		assertTrue(personne.getNom(), personne.getNom().equals("Mlaghui"));
	}
	
	@Test
	public void testSetMail() {
		personne.setMail("danyboon@gmail.com");
		assertEquals("danyboon@gmail.com", personne.getMail());
	}
	
	@Test
	public void testGetMail() {
		assertTrue(personne.getMail(), personne.getMail().equals("bra@gmail.com"));
	}
	
	@Test
	public void testGetEquipe() {
		Equipe equipe1 = inscr.createEquipe("Equipe de Poker");
		equipe1.add(personne);
		Set<Equipe> setEquipe1 = personne.getEquipes();
		assertTrue(setEquipe1.contains(equipe1));
	}
	@Test
	public void testGetPersonneEquipe() {
		Equipe equipe1 = inscr.createEquipe("Equipe de Poker");
		equipe1.add(personne);
		Set<Equipe> setEquipe1 = personne.getEquipes();
		personne.delete();
		assertFalse(setEquipe1.contains(equipe1));
	}

}
