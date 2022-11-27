package com.projectincremental.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Metier {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private Long niveau;
	private Long experience;

	@ManyToOne
	@JoinColumn(name = "compte_id", nullable = false)
	private Compte compte;

	@OneToMany(mappedBy = "metier")
	private Set<Equipement> equipements;
	@OneToMany(mappedBy = "metier")
	private Set<Consommable> consommables;
}
