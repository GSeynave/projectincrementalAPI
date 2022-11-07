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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNiveau() {
		return niveau;
	}

	public void setNiveau(Long niveau) {
		this.niveau = niveau;
	}

	public Long getVie() {
		return vie;
	}

	public void setVie(Long vie) {
		this.vie = vie;
	}

	public Long getTerre() {
		return terre;
	}

	public void setTerre(Long terre) {
		this.terre = terre;
	}

	public Long getFeu() {
		return feu;
	}

	public void setFeu(Long feu) {
		this.feu = feu;
	}

	public Long getAir() {
		return air;
	}

	public void setAir(Long air) {
		this.air = air;
	}

	public Long getEau() {
		return eau;
	}

	public void setEau(Long eau) {
		this.eau = eau;
	}

	public Long getSagesse() {
		return sagesse;
	}

	public void setSagesse(Long sagesse) {
		this.sagesse = sagesse;
	}

	public Long getHate() {
		return hate;
	}

	public void setHate(Long hate) {
		this.hate = hate;
	}

	public Long getPuissance() {
		return puissance;
	}

	public void setPuissance(Long puissance) {
		this.puissance = puissance;
	}

	public Long getPrecision() {
		return precision;
	}

	public void setPrecision(Long precision) {
		this.precision = precision;
	}

	public Long getDexterite() {
		return dexterite;
	}

	public void setDexterite(Long dexterite) {
		this.dexterite = dexterite;
	}

	public Long getEnergie() {
		return energie;
	}

	public void setEnergie(Long energie) {
		this.energie = energie;
	}

	public Long getCritiqueChance() {
		return critiqueChance;
	}

	public void setCritiqueChance(Long critiqueChance) {
		this.critiqueChance = critiqueChance;
	}

	public Long getCritiqueDommage() {
		return critiqueDommage;
	}

	public void setCritiqueDommage(Long critiqueDommage) {
		this.critiqueDommage = critiqueDommage;
	}

	public Long getResistanceTerre() {
		return resistanceTerre;
	}

	public void setResistanceTerre(Long resistanceTerre) {
		this.resistanceTerre = resistanceTerre;
	}

	public Long getResistanceFeu() {
		return resistanceFeu;
	}

	public void setResistanceFeu(Long resistanceFeu) {
		this.resistanceFeu = resistanceFeu;
	}

	public Long getResistanceAir() {
		return resistanceAir;
	}

	public void setResistanceAir(Long resistanceAir) {
		this.resistanceAir = resistanceAir;
	}

	public Long getResistanceEau() {
		return resistanceEau;
	}

	public void setResistanceEau(Long resistanceEau) {
		this.resistanceEau = resistanceEau;
	}
}
