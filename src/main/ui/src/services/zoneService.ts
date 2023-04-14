import axios from "axios";
import authService from "./authService";

class ZoneService {
  constructor() {
    this.url = process.env.VUE_APP_URL + "/api/v1/zones";
  }

  getZones() {
    const path = this.url;
    const headers = authService.getHeaders();
    return new Promise(function (resolve, reject) {
      axios.get(path, headers).then(
        (response) => {
          const result = response.data;
          resolve(result);
        },
        (error) => {
          reject(this.getError(error.response));
        }
      );
    });
  }

  getZoneByNom(nom) {
    const path = this.url + `/${nom}`;
    const headers = authService.getHeaders();
    return new Promise(function (resolve, reject) {
      axios.get(path, headers).then(
        (response) => {
          const result = response.data;
          resolve(result);
        },
        (error) => {
          reject(this.getError(error.response));
        }
      );
    });
  }

  getError(error) {
    if (error.data.code == "1") {
      this.localStore.clear();
      location.reload();
    } else {
      return error;
    }
  }
}

export default new ZoneService();
