package com.projectincremental.dtos.mappers;

import com.projectincremental.dtos.CaracteristiqueDto;
import com.projectincremental.entities.Caracteristique;
import org.springframework.stereotype.Component;

@Component
public class CaracteristiqueMapper {

    public CaracteristiqueDto toDto(Caracteristique caracteristique) {
        CaracteristiqueDto dto = new CaracteristiqueDto();
        dto.setId(caracteristique.getId());
        dto.setNiveau(caracteristique.getNiveau());
        dto.setVie(caracteristique.getVie());
        dto.setTerre(caracteristique.getTerre());
        dto.setFeu(caracteristique.getFeu());
        dto.setAir(caracteristique.getAir());
        dto.setEau(caracteristique.getEau());
        dto.setSagesse(caracteristique.getSagesse());
        dto.setHate(caracteristique.getHate());
        dto.setPuissance(caracteristique.getPuissance());
        dto.setPrecision(caracteristique.getPrecision());
        dto.setDexterite(caracteristique.getDexterite());
        dto.setEnergie(caracteristique.getEnergie());
        dto.setCritiqueChance(caracteristique.getCritiqueChance());
        dto.setCritiqueDommage(caracteristique.getCritiqueDommage());
        dto.setResistanceTerre(caracteristique.getResistanceTerre());
        dto.setResistanceFeu(caracteristique.getResistanceFeu());
        dto.setResistanceAir(caracteristique.getResistanceAir());
        dto.setResistanceEau(caracteristique.getResistanceEau());
        return dto;
    }

    public Caracteristique toEntity(CaracteristiqueDto caracteristiqueDto) {
        Caracteristique caracteristique = new Caracteristique();
        caracteristique.setId(caracteristiqueDto.getId());
        caracteristique.setNiveau(caracteristiqueDto.getNiveau());
        caracteristique.setVie(caracteristiqueDto.getVie());
        caracteristique.setTerre(caracteristiqueDto.getTerre());
        caracteristique.setFeu(caracteristiqueDto.getFeu());
        caracteristique.setAir(caracteristiqueDto.getAir());
        caracteristique.setEau(caracteristiqueDto.getEau());
        caracteristique.setSagesse(caracteristiqueDto.getSagesse());
        caracteristique.setHate(caracteristiqueDto.getHate());
        caracteristique.setPuissance(caracteristiqueDto.getPuissance());
        caracteristique.setPrecision(caracteristiqueDto.getPrecision());
        caracteristique.setDexterite(caracteristiqueDto.getDexterite());
        caracteristique.setEnergie(caracteristiqueDto.getEnergie());
        caracteristique.setCritiqueChance(caracteristiqueDto.getCritiqueChance());
        caracteristique.setCritiqueDommage(caracteristiqueDto.getCritiqueDommage());
        caracteristique.setResistanceTerre(caracteristiqueDto.getResistanceTerre());
        caracteristique.setResistanceFeu(caracteristiqueDto.getResistanceFeu());
        caracteristique.setResistanceAir(caracteristiqueDto.getResistanceAir());
        caracteristique.setResistanceEau(caracteristiqueDto.getResistanceEau());
        return caracteristique;
    }
}
