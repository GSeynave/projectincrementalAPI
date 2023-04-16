import { Ressource } from "./Ressource";

export class InventaireRessource{
    ressource: Ressource = new Ressource();
    quantity: number = 0;

    constructor(ressource: Ressource, quantity: number){
        this.ressource = ressource;
        this.quantity = quantity;
    }
}