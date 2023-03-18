class Personnage {
    constructor(nom, niveau, nomZone) {
        this.nom = nom;
        this.niveau = niveau;
        this.nomZone = nomZone;
    }

    set nomZone(nomZone) {
        this.nomZone = nomZone;
    }
}