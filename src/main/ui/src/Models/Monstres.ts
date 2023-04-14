import Caracteristique from "./Caracteristique";

class Monstre {
  nom: string;
  caracteristics: Caracteristique;

  constructor(nom: string, caracteristic: Caracteristique) {
    this.nom = nom;
    this.caracteristic = caracteristic;
  }
}
