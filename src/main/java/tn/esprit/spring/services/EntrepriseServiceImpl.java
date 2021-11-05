package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

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

	public int ajouterDepartement(Departement dep) {
		try {
			l.info("in ajouterDepartement");
			deptRepoistory.save(dep);
		} catch (Exception e) {
			l.error("erreur dans ajouterDepartement");
		}
		return dep.getId();
	}

	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		// Le bout Master de cette relation N:1 est departement
		// donc il faut rajouter l'entreprise a departement
		// ==> c'est l'objet departement(le master) qui va mettre a jour l'association
		// Rappel : la classe qui contient mappedBy represente le bout Slave
		// Rappel : Dans une relation oneToMany le mappedBy doit etre du cote one.
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
	}

	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		List<String> depNames = new ArrayList<>();
		try {
			l.info("in getAllDepartementsNamesByEntreprise");
			l.debug("cherche entreprise par id");
			Entreprise entrepriseManagedEntity = entrepriseRepoistory.findById(entrepriseId).orElse(new Entreprise());

			for (Departement dep : entrepriseManagedEntity.getDepartements()) {
				depNames.add(dep.getName());
			}
		} catch (Exception e) {
			l.error("erreur dans getAllDepartementsNamesByEntreprise");
		}
		return depNames;
	}

	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		try {
			l.info("in deleteEntrepriseById");
			entrepriseRepoistory.delete(entrepriseRepoistory.findById(entrepriseId).orElse(null));
		} catch (Exception e) {
			l.error("erreur dans deleteEntrepriseById");
		}
	}

	@Transactional
	public void deleteDepartementById(int depId) {
		try {
			l.info("in deleteDepartementById");
			deptRepoistory.delete(deptRepoistory.findById(depId).orElse(null));
		} catch (Exception e) {
			l.error("erreur dans deleteDepartementById");
		}
	}

	public Entreprise getEntrepriseById(int entrepriseId) {
		l.info("in getEntrepriseById");
		return entrepriseRepoistory.findById(entrepriseId).orElse(null);

	}

}
