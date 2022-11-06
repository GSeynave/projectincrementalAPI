package com.projectincremental.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Statistique {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long niveau;
	private Long vie;
	private Long terre;
	private Long feu;
	private Long air;
	private Long eau;
	private Long sagesse;
	private Long hate;
	private Long puissance;
	private Long precision;
	private Long dexterite;
	private Long energie;
	private Long critiqueChance;
	private Long critiqueDommage;
	private Long resistanceTerre;
	private Long resistanceFeu;
	private Long resistanceAir;
	private Long resistanceEau;
}
