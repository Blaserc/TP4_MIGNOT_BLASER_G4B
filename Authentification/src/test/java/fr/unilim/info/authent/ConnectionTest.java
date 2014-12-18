package fr.unilim.info.authent;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import fr.unilim.info.authent.exception.CompteDejaInscritException;
import fr.unilim.info.authent.exception.CompteInactifException;
import fr.unilim.info.authent.exception.CompteInexistantException;
import fr.unilim.info.authent.exception.MotDePasseIncorrectException;

@RunWith(MockitoJUnitRunner.class)
public class ConnectionTest {

	private ServiceAuthentification service;
	private List<String> sessionEnCours;
	
	@Mock
	private IAnnuaire annuaire;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.annuaire = Mockito.mock(IAnnuaire.class);
		this.service = new ServiceAuthentification(annuaire);
		this.sessionEnCours = ServiceAuthentificationFixture.creerListeSession();
	}
	
	@Test(expected = CompteInexistantException.class)
	public void connecterCompteInexistant() throws CompteInexistantException, CompteInactifException, MotDePasseIncorrectException  {
		//Given
		String mdp = "patate";
		String id = "patate";
		//When
		Mockito.when(annuaire.recupererCompteParIdentifiant(id)).thenReturn(null);
		this.service.connecter(id, mdp);
		//Then
	}
}
