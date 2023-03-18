<template>
    <HomePage v-if="this.user" v-bind:user="this.user" @set-personnage-zone="setPersonnageZone"></HomePage>
    <CombatPage v-if="this.user && this.zone" v-bind:user="this.user" v-bind:zone="this.zone"></CombatPage>
</template>

<script>
import HomePage from './components/HomePage.vue'
import CombatPage from './components/CombatPage.vue'
import UserService from "./services/userService"
import ZoneService from "./services/zoneService"

export default {
    name: 'App',
    components: {
        HomePage,
        CombatPage
    },
    data() {
        return {
            user: {},
            zone: {}
        }
    },
    created() {
        this.initGame();
    },
    methods: {
        async initGame() {
            await UserService.getUserById("63fb2dcbe2aaed3be96b392c").then((response) => {
                this.user = response;
                ZoneService.getZoneByNom(this.user.personnages[0].nomZone).then((response) => {
                    this.zone = response;
                });
            });
        },
        setPersonnageZone(zone) {
            console.log("curent zone:", this.user.personnages[0].nomZone, "new zone ", zone.nom);
            if (this.user.personnages[0].nomZone != zone.nom) {
                this.user.personnages[0].nomZone = zone.nom;
                UserService.setPersonnageZone("63fb2dcbe2aaed3be96b392c", this.user.personnages[0].nom, zone.nom).then(response => {
                    this.user = response;
                    this.zone = zone;
                })
            }
        },
    },
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
