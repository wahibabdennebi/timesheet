package tn.esprit.spring.services;


import java.util.List;




import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;



public interface IEmployeService {
	
	
	public int getNombreEmployeJPQL();
	public List<String> getAllEmployeNamesJPQL();
	public List<Employe> getAllEmployeByEntreprise(Entreprise entreprise);
	public void mettreAjourEmailByEmployeIdJPQL(String email, int employeId);
	public void deleteAllContratJPQL();
	public float getSalaireByEmployeIdJPQL(int employeId);
	public Double getSalaireMoyenByDepartementId(int departementId);
	public List<Employe> getAllEmployes();
	
	
	
	

	
}
