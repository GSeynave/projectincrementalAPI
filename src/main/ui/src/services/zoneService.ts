import { Zone } from "../Models/Zone";
const zonesJson = require("../data/zones.json");
class ZoneService {
  zones: Zone[] = zonesJson;

  getZones(): Zone[] {
    return this.zones;
  }

  getZoneByNom(nom: string): Zone {
    let result = new Zone();
    this.zones.forEach(function (zone) {
      if (zone.nom == nom) result = zone;
    });
    if (result.nom == "") {
      return this.zones[0];
    }
    return result;
  }
}

export default new ZoneService();
