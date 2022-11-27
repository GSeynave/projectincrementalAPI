package com.projectincremental.dtos;

import java.util.List;

public class InventaireConsommableDto {

    private Long id;
    private ConsommableDto consommable;
    private Long quantite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConsommableDto getConsommable() {
        return consommable;
    }

    public void setConsommable(ConsommableDto consommable) {
        this.consommable = consommable;
    }

    public Long getQuantite() {
        return quantite;
    }

    public void setQuantite(Long quantite) {
        this.quantite = quantite;
    }
}
