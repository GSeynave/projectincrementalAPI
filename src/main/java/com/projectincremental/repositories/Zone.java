package com.projectincremental.repositories;

import org.springframework.data.repository.Repository;

public interface Zone extends Repository<Zone, Long>{
	
	Zone findZoneById(Long id);

}
