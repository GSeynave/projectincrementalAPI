class Zone {
    constructor(id, nom, monstres) {
        this.id = id;
        this.nom = nom;
        this.monstres = monstres;
    }

    get id() {
        return this.id;
    }
    get nom() {
        return this.nom;
    }
    get monstres() {
        return this.monstres;
    }
}