package hibernate;

import inscriptions.Inscriptions;
import menuUser.Dialogue;
import hibernate.Passerelle;

public class Main{ 
	
	public static void main(String[] args) {
			
			Passerelle.initHibernate();
	        Inscriptions inscriptions = Inscriptions.getInscriptions();
	        Dialogue dial = new Dialogue(inscriptions);
	        dial.start();
	}
}