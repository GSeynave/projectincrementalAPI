package com.projectIncremental.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.projectincremental.entities.Monstre;
import com.projectincremental.services.MonstreService;

@SpringBootTest
class MonstreServiceTest {

	@Autowired
	MonstreService monstreService;
	
	@Test
	void TestGetMonstresByZoneId() {
	// GIVEN
		Long zoneId = 1L;
	// WHEN
		List<Monstre> monstres = monstreService.getMonstresByZoneId(zoneId);
	// THEN
		assertThat(monstres).isNotEmpty();
		Monstre monstre = monstres.get(0);
		assertThat(monstre.getZone().getId()).isEqualTo(zoneId);
	}
}
