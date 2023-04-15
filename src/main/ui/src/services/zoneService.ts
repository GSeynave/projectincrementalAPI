import { Zone } from "../Models/Zone";
class ZoneService {
  zones: Zone[] = [];
  url: string;
  constructor() {
    this.url = process.env.VUE_APP_URL + "/api/v1/zones";
  }

  getZones(): Zone[] {
    return this.zones;
  }

  getZoneByNom(nom: string): Zone {
    let result = new Zone();
    this.zones.forEach(function (zone) {
      if (zone.nom == nom) result = zone;
    });
    return result;
  }
}

export default new ZoneService();
