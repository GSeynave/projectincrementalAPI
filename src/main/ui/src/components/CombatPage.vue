<template>
  <div v-if="personnage && personnage.nom != ''">
    <h3>Combat</h3>
    <p v-if="this.zone && this.zone.monstres && this.monstre">
      Vous etes actuellement en train de combattre {{ monstre.nom }}
    </p>
    <p>
      <progress
        id="progress-personnage"
        v-bind:max="personnage.caracteristic.maxVie"
        v-bind:value="personnage.caracteristic.vie"
      ></progress>
      Vous avez : {{ personnage.caracteristic.vie }} pv et vous infigez
      {{ personnage.caracteristic.degat }} degats. test :
      personnage.caracteristic.vie : {{ personnage.caracteristic.vie }},
      <button @click="doDamage(monstre, personnage)">Get damage</button>
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
  data() {
    return {
      monstre: this.getMonstre(),
      maxVie: 0,
    };
  },
  methods: {
    getMonstre() {
      console.log("get monstre", this.personnage);
      if (this.zone && this.zone.monstres) {
        var index = Math.floor(Math.random() * this.zone.monstres.length);
      }
      this.monstre = this.zone.monstres[index];
      return this.monstre;
    },
    doDamage(attacker, target) {
      target.caracteristic.vie -= attacker.caracteristic.degat;
    },
  },
};
</script>

<style></style>
