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
      <button @click="doBattle()">
        Auto battle <span v-if="battle">ON</span><span v-else>OFF</span>
      </button>
      {{ monstre.nom }} a : {{ monstre.caracteristic.vie }} pv et infige
      {{ monstre.caracteristic.degat }} degats.
      <progress
        id="progress-monstre"
        v-bind:max="monstre.caracteristic.maxVie"
        v-bind:value="monstre.caracteristic.vie"
      ></progress>
    </p>
  </div>

  <div v-else>Loading...</div>
</template>

<script>
import { Personnage } from "@/Models/Personnage";
import { Zone } from "../Models/Zone";

export default {
  props: {
    personnage: { type: Personnage },
    zone: { type: Zone },
  },
  watch: {
    zone: function () {
      console.log("get monstres");
      this.monstres = this.zone.monstres;
      this.monstre = this.getMonstre();
    },
  },
  created() {
    clearInterval(this.battleInterval);
  },
  data() {
    return {
      monstres: [],
      monstre: this.getMonstre(),
      battle: false,
      battleInterval: {},
    };
  },
  methods: {
    getMonstre() {
      if (this.monstres && this.monstres.length > 0) {
        const index = Math.floor(Math.random() * this.monstres.length);
        const monstre = this.monstres[index];
        return (this.monstre = monstre);
      }
    },
    doBattle() {
      this.battle = !this.battle;
      if (this.battle) {
        this.battleInterval = setInterval(() => {
          this.monstre.caracteristic.vie -= this.personnage.caracteristic.degat;
          if (this.monstre.caracteristic.vie <= 0) {
            this.monstre.caracteristic.vie = 0;
            console.log("monstre tue.");
            this.monstre = this.getMonstre();
          }
        }, 3 * 1000);
      } else {
        clearInterval(this.battleInterval);
      }
    },
  },
};
</script>

<style></style>
