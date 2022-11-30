package com.projectincremental.entities;

import javax.persistence.*;

@Entity
public class InventaireConsommable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "consommable_id", nullable = false)
    private Consommable consommable;

    private Long quantite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Consommable getConsommable() {
        return consommable;
    }

    public void setConsommable(Consommable consommable) {
        this.consommable = consommable;
    }

    public Long getQuantite() {
        return quantite;
    }

    public void setQuantite(Long quantite) {
        this.quantite = quantite;
    }
}
