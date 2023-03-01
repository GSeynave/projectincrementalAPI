package com.projectIncremental.repositories;

import com.projectincremental.ProjectIncrementalApplication;
import com.projectincremental.documents.ZoneDocument;
import com.projectincremental.repositories.ZoneRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = ProjectIncrementalApplication.class)
class ZoneRepositoryTest {

    @Autowired
    private ZoneRepository zoneRepository;


    @Test
    void getZoneByIdTest() {
        // GIVEN
        Long zoneId = 1L;

        // WHEN
        //Optional<Zone> zone = this.zoneRepository.findZoneById(zoneId);

        // THEN
        //Assertions.assertThat(zone.isPresent()).isTrue();
        //assertThat(zone.get()).isNotNull();
        //assertThat(zone.get().getId()).isEqualTo(zoneId);
    }

    @Test
    void getZonesTest() {
        // GIVEN

        // WHEN
        List<ZoneDocument> zones = this.zoneRepository.findAll();

        // THEN
        assertThat(zones).isNotEmpty();
        assertThat(zones.size()).isGreaterThan(1);
    }
}
