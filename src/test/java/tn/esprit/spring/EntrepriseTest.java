package tn.esprit.spring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseTest {
	@Autowired
	IEntrepriseService ie;

	@Test
	public void ajouterEntrepriseTest() {
		Entreprise e = new Entreprise("test", "testtest");
		Assert.assertNotEquals(0, ie.ajouterEntreprise(e));
		ie.ajouterEntreprise(e);
	}



	@Test
	public void affecterDepartementAEntrepriseTest() {
		Assert.assertNotEquals(0, ie.affecterDepartementAEntreprise(1,5));
	}
	@Test
	public void deleteEntrepriseByIdTest() {
		Entreprise e = new Entreprise("test", "testtest");
		ie.ajouterEntreprise(e);
		Assert.assertNotEquals(0, ie.deleteEntrepriseById(ie.ajouterEntreprise(e)));
		
	}
	@Test
	public void getEntrepriseById () {
		Entreprise e = new Entreprise("test", "testtest");
		ie.ajouterEntreprise(e);
		Assert.assertEquals("test", ie.getEntrepriseById(ie.ajouterEntreprise(e)).getName());
	}



	

	

}
