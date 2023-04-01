<template>
  <h1>Web Incremental RPG</h1>

  <h2 v-if="user">Bienvenue {{ user.username }}</h2>

  <h3>Zones</h3>

  <p v-if="user && user.personnages">
    Votre personnage <b>{{ user.personnages[0].nom }}</b> est actuellement dans
    la zone <b>{{ user.personnages[0].nomZone }}</b>
  </p>
  <p v-else><CreateCharacter> </CreateCharacter></p>

  <ul v-if="zones">
    <li v-for="zone in zones" :key="zone.id">
      <button type="button" @click="$emit('setPersonnageZone', zone)">
        {{ zone.nom }}
      </button>
      <ul v-if="zone.monstres">
        <li v-for="monstre in zone.monstres" :key="monstre.nom">
          <p>{{ monstre.nom }}</p>
        </li>
      </ul>
    </li>
  </ul>
</template>

<script>
import ZoneService from "../services/zoneService";
import CreateCharacter from "./CreateCharacter";
export default {
  components: {
    CreateCharacter,
  },
  props: ["user"],
  emits: ["setPersonnageZone"],
  data() {
    return {
      zones: this.getZones(),
    };
  },
  methods: {
    getZones() {
      ZoneService.getZones().then((response) => {
        this.zones = response;
      });
    },
  },
};
</script>
