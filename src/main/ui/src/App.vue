<template>
    <div v-if="isLogged">
        <button @click="logout">Logout</button>
        <HomePage v-if="this.user" v-bind:user="this.user" @set-personnage-zone="setPersonnageZone"></HomePage>
        <CombatPage v-if="this.user && this.zone" v-bind:user="this.user" v-bind:zone="this.zone"></CombatPage>
    </div>
    <div v-else>
        <LoginPage></LoginPage>
    </div>
</template>

<script>
import HomePage from './components/HomePage.vue'
import CombatPage from './components/CombatPage.vue'
import UserService from "./services/userService"
import ZoneService from "./services/zoneService"
import LoginPage from "./components/LoginPage"

export default {
    name: 'App',
    components: {
        HomePage,
        CombatPage,
        LoginPage
    },
    data() {
        return {
            user: {},
            zone: {},
            isLogged: false
        }
    },
    created() {
        this.initGame();
    },
    methods: {
        async initGame() {
            if (localStorage.authToken != null && localStorage.username != null) {
                this.isLogged = true;
            }
            // check if token in storage, if yes check if still valid, if yes -> isLogged = true, else nothing
            if (this.isLogged) {
                await UserService.getUserById("63fb2dcbe2aaed3be96b392c").then((response) => {
                    this.user = response;
                    ZoneService.getZoneByNom(this.user.personnages[0].nomZone).then((response) => {
                        this.zone = response;
                    });
                });
            }
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
        logout() {
            console.log("clearing local");
            window.localStorage.clear();
            window.location.reload();
        }
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
