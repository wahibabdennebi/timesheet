package tn.esprit.spring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseTest {
	@Autowired
	IEntrepriseService ie;



	@Test
	public void ajouterDepartementTest() {
		Departement d = new Departement("test");
		Assert.assertNotEquals(0, ie.ajouterDepartement(d));
		ie.ajouterDepartement(d);
	}

	@Test
	public void affecterDepartementAEntrepriseTest() {
		
		ie.affecterDepartementAEntreprise(13,5);
	}

	@Test
	public void getAllDepartementsNamesByEntreprise() {
		Assert.assertNotEquals(0, ie.getAllDepartementsNamesByEntreprise(5).size());
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//	@Test
//	public void deleteEntrepriseById() {
//		ie.deleteEntrepriseById(4);
//		
//
//	}

//	@Test
//	public void deleteDepartementById() {
//		ie.deleteDepartementById(14);
//	}
//	@Test
//	public void ajouterEntrepriseTest() {
//		Entreprise e = new Entreprise("test", "testtest");
//		Assert.assertNotEquals(0, ie.ajouterEntreprise(e));
//		ie.ajouterEntreprise(e);
//	}
	

}
