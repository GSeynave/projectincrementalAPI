import { Personnage } from "../Models/Personnage";
import { Caracteristic } from "../Models/Caracteristic";
import saveService from "./saveService";

class UserService {
  characters: Personnage[] = [];

  getCharacters(): Personnage[] {
    return this.characters;
  }
  setCharacters(characters: Personnage[]) {
    this.characters = characters;
  }

  createCharacters(characters: Personnage[]) {
    const self = this;
    this.characters = characters;
    this.characters.forEach(function (character) {
      character.caracteristic = self.initCaracteristic();
    });
    saveService.saveGame();
  }

  setPersonnageZone(nomPersonnage: string, nomZone: string): Personnage {
    let result = new Personnage();
    this.characters.forEach(function (character) {
      if (character.nom == nomPersonnage) {
        character.nomZone = nomZone;
        result = character;
      }
    });
    console.log(result);
    saveService.saveGame();
    return result;
  }

  initCaracteristic(): Caracteristic {
    const caracteristic: Caracteristic = new Caracteristic();
    caracteristic.maxVie = 10.0;
    caracteristic.vie = 10.0;
    caracteristic.degat = 1.0;

    return caracteristic;
  }
}

export default new UserService();
