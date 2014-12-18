package fr.unilim.info.authent;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import fr.unilim.info.authent.exception.CompteDejaInscritException;
import fr.unilim.info.authent.exception.CompteInexistantException;

@RunWith(MockitoJUnitRunner.class)
public class InscriptionTest {

	private ServiceAuthentification service;

	@Mock
	private IAnnuaire annuaire;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.annuaire = Mockito.mock(IAnnuaire.class);
		this.service = new ServiceAuthentification(annuaire);
	}

	@Test(expected = IllegalArgumentException.class)
	public void incriptionIdNull() throws CompteDejaInscritException {
		// Given
		String mdp = "truc";
		String id = null;
		// When
		this.service.inscrire(id, mdp);
		// Then
	}

	@Test(expected = IllegalArgumentException.class)
	public void incriptionIdMotDePasseNull() throws CompteDejaInscritException {
		// Given
		String mdp = null;
		String id = null;
		// When
		this.service.inscrire(id, mdp);
		// Then
	}

	@Test(expected = IllegalArgumentException.class)
	public void incriptionMotDePasseNull() throws CompteDejaInscritException {
		// Given
		String mdp = null;
		String id = "patate";
		// When
		this.service.inscrire(id, mdp);
		// Then
	}

	@Test(expected = CompteDejaInscritException.class)
	public void compteDejaInscrit() throws CompteDejaInscritException {
		// Given
		String id = "patate";
		String mdp = "banana";
		// When
		Mockito.when(annuaire.recupererCompteParIdentifiant(id)).thenReturn(
				new Compte(id));
		this.service.inscrire(id, mdp);
		// Then
	}

	@Test
	public void comptePasEncoreInscrit() throws CompteDejaInscritException {
		// Given
		String id = "patate";
		String mdp = "banana";
		// When
		Mockito.when(annuaire.recupererCompteParIdentifiant(id)).thenReturn(null);
		Mockito.when(annuaire.creerCompte(id, mdp)).thenReturn(true);
		boolean condition = this.service.inscrire(id, mdp);
		// Then
		assertTrue(condition);
	}
	
	@Test
	public void comptePasEncoreInscritErreur() throws CompteDejaInscritException {
		// Given
		String id = "patate";
		String mdp = "banana";
		// When
		Mockito.when(annuaire.recupererCompteParIdentifiant(id)).thenReturn(null);
		Mockito.when(annuaire.creerCompte(id, mdp)).thenReturn(false);
		boolean condition = this.service.inscrire(id, mdp);
		// Then
		assertFalse(condition);
	}

	@Test(expected = IllegalArgumentException.class)
	public void desincriptionIdNull() throws CompteInexistantException {
		// Given
		String id = null;
		// When
		this.service.desinscrire(id);
		// Then
	}
	
	@Test(expected = CompteInexistantException.class)
	public void desincriptionCompteInexistant() throws CompteInexistantException {
		//Given
		String id = "patate";
		//When
		Mockito.when(annuaire.recupererCompteParIdentifiant(id)).thenReturn(null);
		this.service.desinscrire(id);
		//Then
	}
	
	@Test
	public void desincriptionCompteExistant() throws CompteInexistantException {
		//Given
		String id = "patate";
		//When
		Mockito.when(annuaire.recupererCompteParIdentifiant(id)).thenReturn(new Compte(id));
		Mockito.when(annuaire.supprimerCompte(id)).thenReturn(true);
		boolean resultat = this.service.desinscrire(id);
		//Then
		assertTrue(resultat);
	}
	
	@Test
	public void desincriptionCompteExistantErreur() throws CompteInexistantException {
		//Given
		String id = "patate";
		//When
		Mockito.when(annuaire.recupererCompteParIdentifiant(id)).thenReturn(new Compte(id));
		Mockito.when(annuaire.supprimerCompte(id)).thenReturn(false);
		boolean resultat = this.service.desinscrire(id);
		//Then
		assertFalse(resultat);
	}
}
