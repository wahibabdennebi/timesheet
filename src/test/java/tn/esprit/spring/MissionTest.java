package tn.esprit.spring;

import static org.junit.Assert.assertThat;

import java.text.ParseException;
import java.util.logging.LogManager;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.services.ITimesheetService;

public class MissionTest {
	@Autowired
	ITimesheetService  im;
	
	@Test
	public  void ajouterMissionTest() throws ParseException {
		Mission m = new Mission();
		m.setId(10);
		m.setName("SagemCom");
		m.setDescription("embarqué");
		im.ajouterMission(m);
		assertThat(m.getName()).isEqualTo("sagem");

	}

}
