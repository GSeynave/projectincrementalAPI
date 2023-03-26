import axios from "axios"
import authService from "./authService"

class UserService {

    constructor() {
        this.url = process.env.VUE_APP_URL + '/api/v1/users';
    }
    
    getUserById(id)  {
        var path = this.url +`/${id}`;
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
    setPersonnageZone(userId, nomPersonnage, nomZone) {
        var path = this.url + `/${userId}/personnages/${nomPersonnage}/nomZone/${nomZone}`;
        var headers = authService.getHeaders();
        return new Promise(function(resolve, reject) {
            axios.put(path, headers).then(
                (response) => {
                    var result = response.data; resolve(result);
                },
                (error) => {
                    reject(error);
                });
        });
    }
}

export default new UserService();
