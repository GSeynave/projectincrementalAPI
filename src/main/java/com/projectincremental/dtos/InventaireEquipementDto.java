package com.projectincremental.dtos;

public class InventaireEquipementDto {

    private Long id;
    private EquipementDto equipement;
    private PersonnageDto personnage;
    private Long quantite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EquipementDto getEquipement() {
        return equipement;
    }

    public void setEquipement(EquipementDto equipement) {
        this.equipement = equipement;
    }

    public PersonnageDto getPersonnage() {
        return personnage;
    }

    public void setPersonnage(PersonnageDto personnage) {
        this.personnage = personnage;
    }

    public Long getQuantite() {
        return quantite;
    }

    public void setQuantite(Long quantite) {
        this.quantite = quantite;
    }
}
