package com.projectincremental.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Personnage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private Long niveau;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "statistique_id", referencedColumnName = "id")
	private Statistique statistique;
	@ManyToOne
	@JoinColumn(name = "zone_id", nullable = false)
	private Zone zone;
}
