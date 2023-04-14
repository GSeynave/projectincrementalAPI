import axios from "axios";
import authService from "./authService";

class LoginService {
  constructor() {
    this.url = process.env.VUE_APP_URL + "/api/v1/auth";
  }

  register(registerForm) {
    const path = this.url + `/register`;
    const headers = authService.getHeaders();
    return new Promise(function (resolve, reject) {
      axios.post(path, registerForm, headers).then(
        (response) => {
          const result = response.data;
          console.log("getting result from api");
          resolve(result);
        },
        (error) => {
          console.log("getting error from api", error.response);
          reject(this.getError(error));
        }
      );
    });
  }

  authenticate(username, password) {
    const path = this.url + "/authenticate";
    const headers = authService.getHeaders();
    const body = { username: username, password: password };
    return new Promise(function (resolve, reject) {
      axios.post(path, body, headers).then(
        (response) => {
          const result = response.data;
          resolve(result);
        },
        (error) => {
          reject(this.getError(error));
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

export default new LoginService();
