package com.projectincremental.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Ressource {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private Long tauxDrop;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "zone_id", referencedColumnName = "id")
	private Zone zone;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "monstre_id", referencedColumnName = "id")
	private Monstre monstre;
	@OneToMany(mappedBy = "ressource")
	private Set<RecetteRessourceRequire> ressourcesRequired;
	@OneToMany(mappedBy = "ressource")
	private Set<InventaireRessource> inventaireRessources;
}
