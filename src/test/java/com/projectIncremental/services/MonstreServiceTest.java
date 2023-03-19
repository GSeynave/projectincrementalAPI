package com.projectIncremental.services;

import com.projectincremental.ProjectIncrementalApplication;
import com.projectincremental.models.Monstre;
import com.projectincremental.services.MonstreService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = ProjectIncrementalApplication.class)
class MonstreServiceTest {

	@Autowired
	private MonstreService monstreService;
	
	@Test
	void TestGetMonstresByZoneId() throws Exception {
	// GIVEN
		Long zoneId = 1L;

	// WHEN
		//List<Monstre> monstres = monstreService.getMonstresByZoneId(zoneId);

	// THEN
		//assertThat(monstres).isNotEmpty();
		//Monstre monstre = monstres.get(0);
		//assertThat(monstre.getZone().getId()).isEqualTo(zoneId);
		//assertThat(monstres.size()).isGreaterThan(1);
	}
}
