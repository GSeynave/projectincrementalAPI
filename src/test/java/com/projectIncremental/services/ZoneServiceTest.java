package com.projectIncremental.services;

import com.projectincremental.ProjectIncrementalApplication;
import com.projectincremental.entities.Zone;
import com.projectincremental.services.ZoneService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = ProjectIncrementalApplication.class)
class ZoneServiceTest {

    @Autowired
    private ZoneService zoneService;
    @Test
    void findByIdTest() {
        // GIVEN
        Long zoneId = 1L;

        // WHEN
        Optional<Zone> zone = this.zoneService.findById(zoneId);

        // THEN
        Assertions.assertThat(zone.isPresent()).isTrue();
        Assertions.assertThat(zone.get().getId()).isEqualTo(zoneId);
    }

    @Test
    void findAll() {
        // GIVEN
        // WHEN
        List<Zone> zones = this.zoneService.findAll();

        // THEN
        Assertions.assertThat(zones).isNotNull();
        Assertions.assertThat(zones.size()).isGreaterThan(1);
    }
}
