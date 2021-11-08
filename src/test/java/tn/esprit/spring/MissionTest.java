package tn.esprit.spring;

import java.util.logging.LogManager;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.repository.DepartementRepository;

public class MissionTest {
	@Autowired
	DepartementRepository departementRepository;

}
