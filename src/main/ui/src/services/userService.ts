import axios from "axios";
import authService from "./authService";

class UserService {
  constructor() {
    this.url = process.env.VUE_APP_URL + "/api/v1/users";
  }

  getUserByUsername(username) {
    const path = this.url + `/${username}`;
    const headers = authService.getHeaders();
    return new Promise(function (resolve, reject) {
      axios.get(path, headers).then(
        (response) => {
          const result = response.data;
          resolve(result);
        },
        (error) => {
          console.log("error while retrieve user", error);
          reject(this.getError(error.response));
        }
      );
    });
  }

  createCharacters(username, characters) {
    const path = this.url + `/${username}/createcharacters`;
    const headers = authService.getHeaders();
    console.log(characters);
    return new Promise(function (resolve, reject) {
      axios.post(path, characters, headers).then(
        (response) => {
          const result = response.data;
          resolve(result);
        },
        (error) => {
          console.log(error);
          reject(this.getError(error.response));
        }
      );
    });
  }

  setPersonnageZone(username, nomPersonnage, nomZone) {
    const path = this.url + `/${username}/personnages/${nomPersonnage}/nomZone`;
    const headers = authService.getHeaders();
    const body = { nomZone: nomZone };
    console.log(body);
    return new Promise(function (resolve, reject) {
      axios.patch(path, body, headers).then(
        (response) => {
          const result = response.data;
          resolve(result);
        },
        (error) => {
          console.log(error);
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

export default new UserService();
