import { Personnage } from "../Models/Personnage";

class UserService {
  characters: Personnage[] = [];

  getCharacters(): Personnage[] {
    return this.characters;
  }
  setCharacters(characters: Personnage[]) {
    this.characters = characters;
  }

  createCharacters(username: string, characters: Personnage[]) {
    this.characters = characters;
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
