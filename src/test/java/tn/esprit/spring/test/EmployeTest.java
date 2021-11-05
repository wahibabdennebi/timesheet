package tn.esprit.spring.test;

import static org.junit.Assert.assertNotEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IEntrepriseService;



@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeTest {
	private static final Logger l =  LogManager.getLogger(EmployeTest.class);
	
	@Autowired
	IEmployeService empservice;
	@Autowired
	IEntrepriseService entservice;
	
		@Order(1)
		@Test
		public void getNombreEmployeJPQLTest(){
			
			assertNotEquals(0, empservice.getNombreEmployeJPQL());
			l.info("Employe number != 0");
			
		}
		@Order(2)
		@Test
		public void getAllEmployeNamesJPQLTest(){
			List<String> names=empservice.getAllEmployeNamesJPQL();
			assertNotEquals(names.size(),0);
			l.info("names "+names);
			
		}
		@Order(3)
		@Test
		public void getAllEmployesTest(){
			List<Employe>employes = empservice.getAllEmployes();
	    	assertNotEquals(employes.size(),0);
	    	l.info("Employees List  >0 ,"+employes.size());
			
		}
		@Order(4)
		@Test
		public void getAllEmployeByEntrepriseTest(){
			Entreprise ent= entservice.getEntrepriseById(1);
			List<Employe>employes = empservice.getAllEmployeByEntreprise(ent);
			assertNotEquals(employes.size(),0);
	    	l.info("Employees List  >0 ,"+employes.size());
		}
		@Order(5)
		@Test
		public void mettreAjourEmailByEmployeIdJPQLTest(){
			empservice.mettreAjourEmailByEmployeIdJPQL("m@mail.com", 7);
		}
		//@Order(8)
		//@Test
		//public void deleteAllContratJPQLTest(){
			
			//empservice.deleteAllContratJPQL();
		//}
		@Order(6)
		@Test
		public void getSalaireByEmployeIdJPQLTest(){
			try{
				l.info("Salaire : "+empservice.getSalaireByEmployeIdJPQL(1));
			}
			catch(Exception e){
				l.error("Erreur dans getSalaireByEmployeIdJPQLTes : "+e);
			}
		}
		@Order(7)
		@Test
		public void getSalaireMoyenByDepartementIdTest(){
			try{
			
			l.info("Salary by Department : "+empservice.getSalaireMoyenByDepartementId(1));}
			
			
			catch(Exception e){
				l.error("Erreur dans getSalaireMoyenByDepartementIdTest : "+e);
			}
			
			
		}
		
		

	


		
	}
		
