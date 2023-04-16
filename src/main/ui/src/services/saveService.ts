import UserService from "./userService";
import InventoryService from "./inventoryService"

class SaveService {
  saveGame(): void {
    const save = {
      characters: UserService.getCharacters(),
      inventory: Array.from(InventoryService.getInventory().ressources),
    };
    console.log("save :", save)
    localStorage.setItem("save", JSON.stringify(save));
  }

  async loadGame(): Promise<boolean> {
    console.log("load")
    const save = await JSON.parse(localStorage.getItem("save") || "{}");
    if (typeof save.characters !== "undefined"){
      console.log("characters on load", save.characters)
      UserService.setCharacters(save.characters);
    }
    if (typeof save.inventory !== "undefined"){
      console.log("inventory on load", save.inventory)
      InventoryService.setInventoryRessources(save.inventory);
    }
    return true;
  }

  deleteGame(): void {
    localStorage.remoteItem("save");
  }
}

export default new SaveService();
