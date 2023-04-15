import UserService from "./userService";
import { Personnage } from "../Models/Personnage";
class SaveService {
  save(): void {
    var save = {
      characters: UserService.getCharacters(),
    };
  }

  load(): void {
    var save = JSON.parse(localStorage.getItem("save") || "{}");
    if (typeof save.characters !== "undefined")
      UserService.setCharacters(save.characters);
  }

  delete(): void {
    localStorage.remoteItem("save");
  }
}

export default new SaveService();
