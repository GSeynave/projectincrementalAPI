<template>
  <h1>Web Incremental RPG</h1>

  <h2 v-if="user">Bienvenue {{ user.username }}</h2>

  <div v-if="characters">
    <h3>Zones</h3>
  </div>
  <p v-else><CreateCharacter> </CreateCharacter></p>

  <ul v-if="zones && characters.length > 0" class="zones">
    <li v-for="zone in zones" :key="zone.id">
      <div class="zoneItem" @click="$emit('setPersonnageZone', zone)">
        <span class="nonZone">
          {{ zone.nom }}
        </span>
        <ul v-if="zone.monstres" class="monstres">
          <li
            class="monstreItem"
            v-for="monstre in zone.monstres"
            :key="monstre.nom"
          >
            <p>{{ monstre.nom }}</p>
          </li>
        </ul>
      </div>
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
  props: ["characters"],
  emits: ["setPersonnageZone"],
  data() {
    return {
      zones: ZoneService.getZones(),
    };
  },
  methods: {},
};
</script>
<style>
ul {
  list-style-type: none;
}

.zones {
  width: 95%;
  margin: 0;
  padding: 0;
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}

.zoneItem {
  padding: 1em;
  border: solid;
  border-width: 1px;
  border-color: #848e94;
}

.monstres {
  margin: 0;
  padding: 0;
  display: flex;
  justify-content: space-around;
  flex-wrap: wrap;
}

.monstreItem {
  padding: 1em;
  flex-grow: 1;
}
</style>
