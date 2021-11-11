package tn.esprit.spring.services;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {
	private static final Logger l = Logger.getLogger(EntrepriseServiceImpl.class);
	@Autowired
	EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;

	public int ajouterEntreprise(Entreprise entreprise) {
		try {
			l.info("in ajouterEntreprise");
			entrepriseRepoistory.save(entreprise);
		} catch (Exception e) {
			l.error("erreur dans ajouterEntreprise");
		}
		return entreprise.getId();
	}



	public int affecterDepartementAEntreprise(int depId, int entrepriseId) {
		
		try {
			l.info("in affecterDepartementAEntreprise");
			l.debug("cherche entreprise par id");
			Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).orElse(null);
			l.debug("cherche departement par id");
			Departement depManagedEntity = deptRepoistory.findById(depId).orElse(new Departement());
			l.debug("update Entreprise ");
			depManagedEntity.setEntreprise(entrepriseManagedEntity);
			deptRepoistory.save(depManagedEntity);
		} catch (Exception e) {
			l.error("erreur dans affecterDepartementAEntreprise");
		}
	return 1;
	}



	@Transactional
	public int deleteEntrepriseById(int entrepriseId) {
		try {
			l.info("in deleteEntrepriseById");
			entrepriseRepoistory.delete(entrepriseRepoistory.findById(entrepriseId).orElse(null));
		} catch (Exception e) {
			l.error("erreur dans deleteEntrepriseById");
		}
		return 1;
	}



	public Entreprise getEntrepriseById(int entrepriseId) {
		l.info("in getEntrepriseById");
		return entrepriseRepoistory.findById(entrepriseId).orElse(null);
	}

}
