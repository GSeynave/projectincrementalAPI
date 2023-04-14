import Monstre from "./Monstre";

class Zone {
  id: string;
  nom: string;
  monstres: Monstre[];

  constructor(id: string, nom: string, monstres: Monstre[]) {
    this.id = id;
    this.nom = nom;
    this.monstres = monstres;
  }

  get id(): string {
    return this.id;
  }
  get nom(): string {
    return this.nom;
  }
  get monstres(): string {
    return this.monstres;
  }
}
