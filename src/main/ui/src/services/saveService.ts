import UserService from "./userService";
import { Personnage } from "../Models/Personnage";
class SaveService {
  saveGame(): void {
    const save = {
      characters: UserService.getCharacters(),
    };
    localStorage.setItem("save", JSON.stringify(save));
  }

  async loadGame(): Promise<boolean> {
    const save = await JSON.parse(localStorage.getItem("save") || "{}");
    if (typeof save.characters !== "undefined")
      UserService.setCharacters(save.characters);
    return true;
  }

  deleteGame(): void {
    localStorage.remoteItem("save");
  }
}

export default new SaveService();
