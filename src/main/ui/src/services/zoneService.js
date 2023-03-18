import axios from "axios"

class ZoneService{

    constructor() {
        this.url = process.env.VUE_APP_URL + '/zones';
    }

    getZones()  {
        var path = this.url;
        return new Promise(function(resolve, reject) {
            axios.get(path).then(
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
        return new Promise(function(resolve, reject) {
            axios.get(path).then(
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
