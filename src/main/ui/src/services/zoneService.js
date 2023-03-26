import axios from "axios"
import authService from "./authService"

class ZoneService{

    constructor() {
        this.url = process.env.VUE_APP_URL + '/api/v1/zones';
    }

    getZones()  {
        var path = this.url;
        var headers = authService.getHeaders();
        return new Promise(function(resolve, reject) {
            axios.get(path, headers).then(
                (response) => {
                    var result = response.data;
                    resolve(result);
                },
                (error) => {
                    reject(error);
                });
        });
    }

    getZoneByNom(nom) {
        var path = this.url + `/${nom}`;
        var headers = authService.getHeaders();
        return new Promise(function(resolve, reject) {
            axios.get(path, headers).then(
                (response) => {
                    var result = response.data;
                    resolve(result);
                },
                (error) => {
                    reject(error);
                });
        });
    }
}

export default new ZoneService();
