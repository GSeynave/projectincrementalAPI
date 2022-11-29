package com.projectincremental.dtos;

public class InventaireEquipementDto {

    private Long id;
    private EquipementDto equipement;
    private Long personnageId;
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

    public Long getPersonnage() {
        return personnageId;
    }

    public void setPersonnage(Long personnageId) {
        this.personnageId = personnageId;
    }

    public Long getQuantite() {
        return quantite;
    }

    public void setQuantite(Long quantite) {
        this.quantite = quantite;
    }
}
