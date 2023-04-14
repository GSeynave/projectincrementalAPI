<template>
  <h3>Combat</h3>
  <p v-if="this.zone && this.zone.monstres && this.monstre">
    Vous etes actuellement en train de combattre {{ getMonstre().nom }}
  </p>
  <p>
    <progress
      id="progress-personnage"
      v-bind:max="maxVie"
      v-bind:value="currentPersonnage.caracteristique.vie"
    ></progress>
    Vous avez : {{ user.personnages[0].caracteristique.vie }} pv et vous infigez
    {{ user.personnages[0].caracteristique.degat }} degats. test :
    currentPersonnage.vie : {{ currentPersonnage.caracteristique.vie }},
    getMaxVie :
    {{ getMaxVie() }}
  </p>
  <button @click="doDamage(monstre, currentPersonne)">Get damage</button>
</template>

<script>
export default {
  props: ["user", "zone"],
  data() {
    return {
      monstre: this.getMonstre,
      currentPersonnage: this.getPersonnage(),
      maxVie: this.getMaxVie(),
    };
  },
  methods: {
    getMonstre() {
      console.log("get monstre", this.zone);
      if (this.zone && this.zone.monstres) {
        var index = Math.floor(Math.random() * this.zone.monstres.length);
      }
      this.monstre = this.zone.monstres[index];
      return this.monstre;
    },
    getMaxVie() {
      return this.user.personnages[0].caracteristique.vie;
    },
    getPersonnage() {
      return this.user.personnages[0];
    },
    doDamage(attacker, target) {
      target.caracteristique.vie -= attacker.caracteristique.degat;
    },
  },
};
</script>

<style></style>
