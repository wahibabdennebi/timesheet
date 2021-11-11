package tn.esprit.spring.services;
import tn.esprit.spring.entities.Entreprise;

public interface IEntrepriseService {
	public int ajouterEntreprise(Entreprise entreprise);
	int  affecterDepartementAEntreprise(int depId, int entrepriseId);
	public int deleteEntrepriseById(int entrepriseId);
	public Entreprise getEntrepriseById(int entrepriseId);
}
