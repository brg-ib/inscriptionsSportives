package hibernate;

import inscriptions.Inscriptions;
import menuUser.Dialogue;;

public class Main{ 
	
	public static void main(String[] args) {
	        Inscriptions inscriptions = Inscriptions.getInscriptions();
	        Dialogue dial = new Dialogue(inscriptions);
	        dial.start();
	}
}