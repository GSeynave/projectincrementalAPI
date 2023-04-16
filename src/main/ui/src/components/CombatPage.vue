<template>
  <div v-if="personnage && personnage.nom != '' && monstre">
    <h3>Combat</h3>
    <p v-if="this.zone && this.zone.monstres && this.monstre">
      Vous etes actuellement en train de combattre {{ monstre.nom }} dans la
      zone {{ zone.nom }}
    </p>
    <p>
      <progress
        id="progress-personnage"
        v-bind:max="personnage.caracteristic.maxVie"
        v-bind:value="personnage.caracteristic.vie"
      ></progress>
      Vous avez : {{ personnage.caracteristic.vie }} pv et vous infigez
      {{ personnage.caracteristic.degat }} degats.
      <button @click="doDamage()">Get damage</button>
      {{ monstre.nom }} a : {{ monstre.caracteristic.vie }} pv et infige
      {{ monstre.caracteristic.degat }} degats.
    </p>
  </div>

  <div v-else>Loading...</div>
</template>

<script>
import { Personnage } from "@/Models/Personnage";
import { Zone } from "../Models/Zone";

export default {
  props: {
    personnage: Personnage,
    zone: Zone,
  },
  watch: {
    zone: function () {
      this.monstres = this.zone.monstres;
      this.monstre = this.getMonstre();
    },
  },
  data() {
    return {
      monstres: [],
      monstre: this.getMonstre(),
    };
  },
  methods: {
    getMonstre() {
      if (this.monstres && this.monstres.length > 0) {
        const index = Math.floor(Math.random() * this.monstres.length);
        const monstre = this.monstres[index];
        console.log("monstre", monstre);
        return (this.monstre = monstre);
      }
    },
    doDamage() {
      this.monstre.caracteristic.vie -= this.personnage.caracteristic.degat;
    },
  },
};
</script>

<style></style>
