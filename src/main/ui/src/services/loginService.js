import axios from "axios"

class LoginService {

    constructor() {
        this.url = process.env.VUE_APP_URL + '/api/v1/auth';
    }
    
    register(registerForm)  {
        var path = this.url +`/register`;
        return new Promise(function(resolve, reject) {
            axios.post(path, registerForm).then(
                (response) => {
                    var result = response.data;
                    resolve(result);
                },
                (error) => {
                    reject(error);
                });
        });
    }
    verifyTokenValidity(token) {
        var path = this.url + `/authenticate` + token;
        return new Promise(function(resolve, reject) {
            axios.get(path).then(
                (response) => {
                    var result = response.data; resolve(result);
                },
                (error) => {
                    reject(error);
                });
        });
    }
}

export default new LoginService();
