package com.projectIncremental.repositories;

import com.projectincremental.ProjectIncrementalApplication;
import com.projectincremental.entities.Monstre;
import com.projectincremental.entities.Zone;
import com.projectincremental.repositories.MonstreRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = ProjectIncrementalApplication.class)
class MonstreRepositoryTest {

    @Autowired
    private MonstreRepository monstreRepository;
    @Test
    void findByZone() {
        // Given
        Zone zone = new Zone();
        zone.setId(1L);

        // WHEN
        List<Monstre> monstres =  this.monstreRepository.findByZone(zone);

        // THEN
        Assertions.assertThat(monstres).isNotNull();
        Assertions.assertThat(monstres.get(0).getZone().getId()).isEqualTo(zone.getId());
    }
}
