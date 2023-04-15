import { Zone } from "../Models/Zone";
const zonesJson = require("../data/zones.json");
class ZoneService {
  zones: Zone[] = zonesJson;

  getZones(): Zone[] {
    console.log("zones", this.zones);
    return this.zones;
  }

  getZoneByNom(nom: string): Zone {
    console.log("zones", this.zones);
    let result = new Zone();
    this.zones.forEach(function (zone) {
      if (zone.nom == nom) result = zone;
    });
    return result;
  }
}

export default new ZoneService();
