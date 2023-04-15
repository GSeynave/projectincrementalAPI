import UserService from "./userService";
import { Personnage } from "../Models/Personnage";
class SaveService {
  saveGame(): void {
    const save = {
      characters: UserService.getCharacters(),
    };
    console.log("saving", save);
    localStorage.setItem("save", JSON.stringify(save));
  }

  async loadGame(): Promise<void> {
    const save = await JSON.parse(localStorage.getItem("save") || "{}");
    console.log("saved get :", save);
    if (typeof save.characters !== "undefined")
      UserService.setCharacters(save.characters);
  }

  deleteGame(): void {
    localStorage.remoteItem("save");
  }
}

export default new SaveService();
