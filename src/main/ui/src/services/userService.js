import axios from "axios"

class UserService {

    constructor() {
        this.url = process.env.VUE_APP_URL + '/users';
    }
    
    getUserById(id)  {
        var path = this.url +`/${id}`;
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
    setPersonnageZone(userId, nomPersonnage, nomZone) {
        var path = this.url + `/${userId}/personnages/${nomPersonnage}/nomZone/${nomZone}`;
        return new Promise(function(resolve, reject) {
            axios.put(path).then(
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
