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
  <div v-if="characters.length > 0">
    <div class="component">
      <HomePage
        v-bind:characters="characters"
        @set-personnage-zone="setPersonnageZone"
      ></HomePage>
    </div>
    <div class="component">
      <CombatPage
        class="component"
        v-if="characters && zone"
        v-bind:personnage="characters[0]"
        v-bind:zone="zone"
      ></CombatPage>
    </div>
  </div>
  <div v-else>
    <CreateCharacter></CreateCharacter>
  </div>
</template>

<script lang="ts">
import HomePage from "./components/HomePage.vue";
import CombatPage from "./components/CombatPage.vue";
import CreateCharacter from "./components/CreateCharacter.vue";
import UserService from "./services/userService";
import ZoneService from "./services/zoneService";
import SaveService from "./services/saveService";
import { defineComponent } from "vue";
import { Zone } from "./Models/Zone";
import { Personnage } from "./Models/Personnage";

export default defineComponent({
  name: "App",
  components: {
    HomePage,
    CombatPage,
    CreateCharacter,
  },
  data() {
    return {
      characters: [] as Personnage[],
      zone: new Zone(),
    };
  },
  created() {
    this.initGame();
  },
  methods: {
    async initGame() {
      let gameLoaded: boolean = await SaveService.loadGame().then();

      if (gameLoaded) {
        this.characters = UserService.getCharacters();
        if (this.characters.length > 0)
          this.zone = ZoneService.getZoneByNom(this.characters[0].nomZone);
      }
    },
    setPersonnageZone(zone: Zone) {
      if (this.characters[0].nomZone !== zone.nom) {
        console.log("st pesro zone", zone);
        let updatedCharacter: Personnage = UserService.setPersonnageZone(
          this.characters[0].nom,
          zone.nom
        );
        if (updatedCharacter.nomZone !== "") {
          this.characters[0] = updatedCharacter;
          this.zone = zone;
        }
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
