import axios from "axios";
import authService from "./authService";

class UserService {
  constructor() {
    this.url = process.env.VUE_APP_URL + "/api/v1/users";
  }

  getUserByUsername(username) {
    var path = this.url + `/${username}`;
    var headers = authService.getHeaders();
    return new Promise(function (resolve, reject) {
      axios.get(path, headers).then(
        (response) => {
          var result = response.data;
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
    var path = this.url + `/${username}/createcharacters`;
    var headers = authService.getHeaders();
    console.log(characters);
    return new Promise(function (resolve, reject) {
      axios.post(path, characters, headers).then(
        (response) => {
          var result = response.data;
          resolve(result);
        },
        (error) => {
          console.log(error);
          reject(this.getError(error.response));
        }
      );
    });
  }

  setPersonnageZone(userId, nomPersonnage, nomZone) {
    var path =
      this.url + `/${userId}/personnages/${nomPersonnage}/nomZone/${nomZone}`;
    var headers = authService.getHeaders();
    return new Promise(function (resolve, reject) {
      axios.put(path, headers).then(
        (response) => {
          var result = response.data;
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
