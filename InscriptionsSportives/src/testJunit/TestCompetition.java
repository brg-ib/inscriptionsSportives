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

	Inscriptions inscr = Inscriptions.getInscriptions();

	LocalDate dateclôture = LocalDate.of(2021, 11, 11);
	LocalDate dateclôture2 = LocalDate.of(2019, 04, 29);
	LocalDate dateclôture3 = LocalDate.of(2012, 12, 31);

	Competition c1 = inscr.createCompetition("Poker", dateclôture, false);
	Competition c2 = inscr.createCompetition("Billard", dateclôture2, true);
	
	
	Personne p1 = inscr.createPersonne("Robert","DeNiro","deniro.Robert@youtalkingtome.com");
	Equipe e1 = inscr.createEquipe("Gangs");
}
