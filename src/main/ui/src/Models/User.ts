import Personnage fron "./Personnage";
import Zone fron "./zone";

class User {
    id: string;
    username: string;
    personnages: Personnage[];
    zone: Zone;

  constructor(
    id: string,
    username: string,
    personnages: Personnage[],
    zone: Zone
  ) {
    this.id = id;
    this.username = username;
    this.personnages = personnages;
  }

  get id() : string{
    return this.id;
  }
  get username() : string{
    return this.username;
  }
  get personnages() : string{
    return this.personnages;
  }
}
