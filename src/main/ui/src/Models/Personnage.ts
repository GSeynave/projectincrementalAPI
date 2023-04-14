class Personnage {
  constructor(nom, niveau, nomZone, caracteristics) {
    this.nom = nom;
    this.niveau = niveau;
    this.nomZone = nomZone;
    this.caracteristics = caracteristics;
  }

  set nomZone(nomZone) {
    this.nomZone = nomZone;
  }
}
