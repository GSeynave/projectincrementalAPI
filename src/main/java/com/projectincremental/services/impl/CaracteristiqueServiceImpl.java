package com.projectincremental.services.impl;

import com.projectincremental.entities.Caracteristique;
import com.projectincremental.repositories.CaracteristiqueRepository;
import com.projectincremental.services.CaracteristiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CaracteristiqueServiceImpl implements CaracteristiqueService {

    @Autowired
    private CaracteristiqueRepository caracteristiqueRepository;

    @Override
    public Optional<Caracteristique> findById(Long caracteristiqueId) {
        return caracteristiqueRepository.findById(caracteristiqueId);
    }

    @Override
    public Caracteristique getSommeCaracteristiqueById(List<Long> idCaracteristiques) {
        Caracteristique caracteristique = new Caracteristique();
        for(Long id: idCaracteristiques) {
            Caracteristique temp = findById(id).orElseThrow(() -> new EntityNotFoundException("Aucune caracteristique pour l'id " +id));
            caracteristique = sommeCaracteristique(caracteristique, temp);
        }
        return caracteristique;
    }

    private Caracteristique sommeCaracteristique(Caracteristique a, Caracteristique b) {
        Caracteristique somme = new Caracteristique();
        somme.setVie(a.getVie() + b.getVie());
        somme.setTerre(a.getTerre() + b.getTerre());
        somme.setFeu(a.getFeu() + b.getFeu());
        somme.setAir(a.getAir() + b.getAir());
        somme.setEau(a.getEau() + b.getEau());
        somme.setSagesse(a.getSagesse() + b.getSagesse());
        somme.setHate(a.getHate() + b.getHate());
        somme.setPuissance(a.getPuissance() + b.getPuissance());
        somme.setPrecision(a.getPrecision() + b.getPrecision());
        somme.setDexterite(a.getDexterite() + b.getDexterite());
        somme.setEnergie(a.getEnergie() + b.getEnergie());
        somme.setCritiqueChance(a.getCritiqueChance() + b.getCritiqueChance());
        somme.setCritiqueDommage(a.getCritiqueDommage() + b.getCritiqueDommage());
        somme.setResistanceTerre(a.getResistanceTerre() + b.getResistanceTerre());
        somme.setResistanceFeu(a.getResistanceFeu() + b.getResistanceFeu());
        somme.setResistanceAir(a.getResistanceAir() + b.getResistanceAir());
        somme.setResistanceEau(a.getResistanceEau() + b.getResistanceEau());
        return somme;
    }
}
