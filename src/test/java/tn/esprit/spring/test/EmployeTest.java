package tn.esprit.spring.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
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
	@Test
	public void ajouterEmployeTest(){
		Role role =Role.INGENIEUR;
		Employe emp=new Employe("Neji", "amine", "amine@mail", true, role);
		try{
			l.info("Test");
			
			l.info("l'id est "+ empservice.ajouterEmploye(emp));
		}
		catch(Exception e){
			l.error("Erreur dans ajouterEmploye : "+e);
		}
	}
		
		@Test
		public void mettreAjourEmailByEmployeId(){
			empservice.mettreAjourEmailByEmployeId("inesneji", 1);
		}
		@Test
		public void ajouterDepartementTest(){
			//Departement dep=new Departement("Finance");
			Departement dep=new Departement("Informatique");
			entservice.ajouterDepartement(dep);
		}
		@Test
		public void affecterEmployeADepartementTest(){
			//empservice.affecterEmployeADepartement(1, 1);
			empservice.affecterEmployeADepartement(1, 1);
			
		}
		@Test
		public void getEmployePrenomByIdTest(){
			try{
				l.info("Le prenom est : "+empservice.getEmployePrenomById(5));
			}
			catch(Exception e){
				l.error("Erreur dans getEmployePrenomByIdTest : "+e);
			}
			
		}
		@Test
		public void desaffecterEmployeDuDepartemenTest(){
			
			empservice.desaffecterEmployeDuDepartement(1, 1);
		
		}
		@Test
		public void ajouterContratTest() throws ParseException{
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
			//Date date = dateFormat.parse("03-11-2021");
			//Contrat cnt=new Contrat(date, "contrat", 1500);
			Date date = dateFormat.parse("04-11-2021");
			Contrat cnt=new Contrat(date, "contrat1", 2500);
			//Contrat cnt=new Contrat(date, "contrat2", 4500);
			try{
				l.info("Contrat : id : "+empservice.ajouterContrat(cnt));
			}
			catch(Exception e){
				l.error("Erreur dans ajouterContrat : "+e);
			}
			
			
		}
		@Test
		public void affecterContratAEmployeTest(){
			empservice.affecterContratAEmploye(9, 1);
		}
		@Test
		public void deleteEmployeByIdTest(){
			empservice.deleteEmployeById(9);
		}
		//@Test
		//public void deleteContratByIdTest(){
			//empservice.deleteContratById(6);}
		
		@Test
		public void getNombreEmployeJPQLTest(){
			try{
				l.info("Nombre des employes : "+empservice.getNombreEmployeJPQL());
			}
			catch(Exception e){
				l.error("Erreur dans getNombreEmployeJPQL : "+e);
			}
			
		}
		@Test
		public void getAllEmployesTest(){
			try{
				l.info("Employes : "+empservice.getAllEmployes());
			}
			catch(Exception e){
				l.error("Erreur dans getAllEmployesTest : "+e);
			}
			
		}
		//@Test
		//public void deleteAllContratJPQLTest(){
			
			//empservice.deleteAllContratJPQL();
		//}
		@Test
		public void getSalaireByEmployeIdJPQLTest(){
			try{
				l.info("Salaire : "+empservice.getSalaireByEmployeIdJPQL(1));
			}
			catch(Exception e){
				l.error("Erreur dans getSalaireByEmployeIdJPQLTes : "+e);
			}
		}
		@Test
		public void getSalaireMoyenByDepartementIdTest(){
			try{
				l.info("Salary by Department : "+empservice.getSalaireMoyenByDepartementId(1));
			}
			catch(Exception e){
				l.error("Erreur dans getSalaireMoyenByDepartementIdTest : "+e);
			}
			
		}
		

	


		
	}
		
