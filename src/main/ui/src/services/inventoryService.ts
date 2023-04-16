import { InventaireRessource } from "@/Models/InventaireRessource";
import { Ressource } from "@/Models/Ressource";
import { Inventory } from "../Models/Inventory";
import saveService from "./saveService";
class InventoryService {

    inventory: Inventory = new Inventory();

    addRessource(ressource: Ressource, quantity: number) {
        console.log("addressource")

        console.log("in filter")
        let isRessourceUpdated: boolean = false;
        this.inventory.ressources.forEach(function (inventoryRessource) {
            if (inventoryRessource.ressource == ressource) {
                inventoryRessource.quantity += quantity;
                isRessourceUpdated = true;
            }
        })
        if (!isRessourceUpdated) {
            console.log("not in filter")
            this.inventory.ressources.push(new InventaireRessource(ressource, quantity));

        }
        console.log(this.inventory);
        saveService.saveGame();
    }

    getInventory(): Inventory {
        console.log('get inventory for save', this.inventory)
        return this.inventory;
    }
    setInventoryRessources(ressources: InventaireRessource[]) {
        this.inventory.ressources = ressources;
    }
}

export default new InventoryService();
