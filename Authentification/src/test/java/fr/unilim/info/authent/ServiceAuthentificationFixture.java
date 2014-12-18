package fr.unilim.info.authent;

import java.util.ArrayList;
import java.util.List;

public class ServiceAuthentificationFixture {
	
	public static List<String> creerListeSession() {
		List<String> sessionEnCours = new ArrayList<String>();
		
		sessionEnCours.add("truc");
		sessionEnCours.add("machin");
		sessionEnCours.add("patate");
		sessionEnCours.add("tra...trav...machin");
		sessionEnCours.add("kiwi");
		sessionEnCours.add("banana");
		sessionEnCours.add("huit");
		sessionEnCours.add("el patator");
		
		return sessionEnCours;
	}

}
