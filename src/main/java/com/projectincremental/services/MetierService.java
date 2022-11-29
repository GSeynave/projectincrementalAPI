package com.projectincremental.services;

import com.projectincremental.dtos.ProgressMetier;
import com.projectincremental.entities.Metier;

import java.util.List;

public interface MetierService {

    public List<Metier> getMetiers();

    Metier updateMetier(long metierId, ProgressMetier progressMetier);
}
