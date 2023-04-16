import { Personnage } from "../Models/Personnage";
import { Caracteristic } from "../Models/Caracteristic";
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
    const self = this;
    this.characters = characters;
    this.characters.forEach(function (character) {
      character.caracteristic = self.initCaracteristic();
    });
    saveService.saveGame();
    console.log("characters :", this.characters);
  }

  setPersonnageZone(nomPersonnage: string, nomZone: string): Personnage {
    let result = new Personnage();
    this.characters.forEach(function (character) {
      if (character.nom == nomPersonnage) {
        console.log("set zone for charac", character);
        character.nomZone = nomZone;
        result = character;
      }
    });
    return result;
  }

  initCaracteristic(): Caracteristic {
    const caracteristic: Caracteristic = new Caracteristic();
    caracteristic.maxVie = 10.0;
    caracteristic.vie = 10.0;
    caracteristic.degat = 10.0;

    return caracteristic;
  }
}

export default new UserService();
