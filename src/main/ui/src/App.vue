<template>
  <nav class="navbar" v-if="isLogged">
    <ul>
      <li class="navbar-item">WebIncremental<span class="rpgtag">RPG</span></li>
      <li class="navbar-item"></li>
      <li class="navbar-item">Character</li>
      <li class="navbar-item">Inventory</li>
      <li class="navbar-item">Crafts</li>
      <li class="navbar-item">Farm</li>
      <li>
        <button @click="logout">Logout</button>
      </li>
    </ul>
  </nav>
  <div v-if="isLogged">
    <div class="component">
      <HomePage
        v-if="this.isLogged && this.user"
        v-bind:user="this.user"
        @set-personnage-zone="setPersonnageZone"
      ></HomePage>
    </div>
    <div class="component">
      <CombatPage
        class="component"
        v-if="this.isLogged && this.user && this.user.personnages && this.zone"
        v-bind:user="this.user"
        v-bind:zone="this.zone"
      ></CombatPage>
    </div>
  </div>
  <div v-else>
    <LoginPage v-model:isLogged="this.isLogged"></LoginPage>
  </div>
</template>

<script>
import HomePage from "./components/HomePage.vue";
import CombatPage from "./components/CombatPage.vue";
import UserService from "./services/userService";
import ZoneService from "./services/zoneService";
import LoginPage from "./components/LoginPage";

export default {
  name: "App",
  components: {
    HomePage,
    CombatPage,
    LoginPage,
  },
  data() {
    return {
      user: {},
      zone: {},
    };
  },
  created() {
    this.initGame();
  },
  methods: {
    async initGame() {
      if (
        localStorage.authToken &&
        localStorage.authToken != "undefined" &&
        localStorage.username
      ) {
        this.isLogged = true;
      } else {
        localStorage.removeItem("authToken");
      }
      if (this.isLogged) {
        await UserService.getUserByUsername(localStorage.username).then(
          (response) => {
            this.user = response;
            ZoneService.getZoneByNom(this.user.personnages[0].nomZone).then(
              (response) => {
                this.zone = response;
              }
            );
          }
        );
      }
    },
    setPersonnageZone(zone) {
      console.log(
        "curent zone:",
        this.user.personnages[0].nomZone,
        "new zone ",
        zone.nom
      );
      if (this.user.personnages[0].nomZone != zone.nom) {
        this.user.personnages[0].nomZone = zone.nom;
        UserService.setPersonnageZone(
          "63fb2dcbe2aaed3be96b392c",
          this.user.personnages[0].nom,
          zone.nom
        ).then((response) => {
          this.user = response;
          this.zone = zone;
        });
      }
    },
    logout() {
      console.log("clearing local");
      window.localStorage.clear();
      window.location.reload();
    },
  },
};
</script>

<style>
body {
  font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
  background-color: #616161;
  color: #e0e0ca;
}
.rpgtag {
  color: #cad8e0;
}

.navbar {
  border-bottom: solid;
  border-width: 3px;
  border-color: #848e94;
}

.navbar > ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  display: flex;
}
.navbar-item:first-child {
  font-weight: bold;
  flex-grow: 6;
}
.navbar-item:not(:first-child) {
  text-align: center;
  flex-grow: 1;
}
.navbar-item:hover:not(:first-child) {
  background-color: #656565;
}

.component {
  padding: 2em;
  border: solid;
  border-width: 3px;
  border-color: #848e94;
}
</style>
