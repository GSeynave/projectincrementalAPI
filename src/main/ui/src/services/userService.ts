import { Personnage } from "../Models/Personnage";
import saveService from "./saveService";

class UserService {
  characters: Personnage[] = [];

  getCharacters(): Personnage[] {
    console.log("get charac", this.characters);
    return this.characters;
  }
  setCharacters(characters: Personnage[]) {
    this.characters = characters;
  }

  createCharacters(characters: Personnage[]) {
    this.characters = characters;
    saveService.saveGame();
    console.log("characters :", this.characters);
  }

  setPersonnageZone(nomPersonnage: string, nomZone: string) {
    this.characters.forEach(function (character) {
      if (character.nom == nomPersonnage) {
        character.nomZone = nomZone;
      }
    });
  }
}

export default new UserService();
