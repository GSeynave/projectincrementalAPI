import Caracteristique from "./Caracteristique";

class Personnage {
  nom: string;
  niveau: string;
  nomZone: string;
  caracteristic: Caracteristique;

  constructor(
    nom: string,
    niveau: string,
    nomZone: string,
    caracteristic: Caracteristique
  ) {
    this.nom = nom;
    this.niveau = niveau;
    this.nomZone = nomZone;
    this.caracteristic = caracteristic;
  }

  set nomZone(nomZone: string) {
    this.nomZone = nomZone;
  }
}
