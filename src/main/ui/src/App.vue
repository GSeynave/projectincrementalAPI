<template>
  <nav class="navbar">
    <ul>
      <li class="navbar-item">WebIncremental<span class="rpgtag">RPG</span></li>
      <li class="navbar-item"></li>
      <li class="navbar-item">Character</li>
      <li class="navbar-item">Inventory</li>
      <li class="navbar-item">Crafts</li>
      <li class="navbar-item">Farm</li>
    </ul>
  </nav>
  <div>
    <div class="component">
      <HomePage
        v-if="characters"
        v-bind:characters="characters"
        @set-personnage-zone="setPersonnageZone"
      ></HomePage>
    </div>
    <div class="component">
      <CombatPage
        class="component"
        v-if="characters && zone"
        v-bind:personnage="characters[0]"
        v-bind:characters="zone"
      ></CombatPage>
    </div>
  </div>
</template>

<script lang="ts">
import HomePage from "./components/HomePage.vue";
import CombatPage from "./components/CombatPage.vue";
import UserService from "./services/userService";
import ZoneService from "./services/zoneService";
import { defineComponent } from "vue";
import { Zone } from "./Models/Zone";

export default defineComponent({
  name: "App",
  components: {
    HomePage,
    CombatPage,
  },
  data() {
    return {
      characters: UserService.getCharacters(),
      zone: [],
    };
  },
  created() {
    this.initGame();
  },
  methods: {
    initGame() {
      this.zone = ZoneService.getZoneByNom(this.characters[0].nomZone);
    },
    setPersonnageZone(zone: Zone) {
      console.log(
        "curent zone:",
        this.characters[0].nomZone,
        "new zone ",
        zone.nom
      );
      if (this.characters[0].nomZone != zone.nom) {
        this.characters[0].nomZone = zone.nom;
        UserService.setPersonnageZone(this.characters[0].nom, zone.nom);
      }
    },
  },
});
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
