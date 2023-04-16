<template>
  <h2>Character creation</h2>

  <div>Select your class and set your name</div>
  <form method="post" @submit.prevent="onCreateCharacter">
    <label for="characterName">Character name</label>
    <input type="text" id="characterName" v-model="characterName" />
    <label for="classes">Classes</label>
    <div v-for="classe in classes" :key="classe.name">
      <label for="classe">{{ classe.name }} </label>
      <input
        type="radio"
        v-bind:id="classe"
        v-model="selectedClasse"
        v-bind:value="classe.name"
      />
    </div>
    <input type="submit" class="button" value="Create" />
  </form>
  <span> selected classe : {{ selectedClasse }}</span>
</template>

<script>
import userService from "@/services/userService";
export default {
  components: {},
  props: ["user"],
  emits: ["setPersonnageZone"],
  data() {
    return {
      classes: [{ name: "Warrior" }, { name: "Rogue" }],
      characterName: "Default character name",
      selectedClasse: "",
    };
  },
  methods: {
    onCreateCharacter() {
      let characters = {
        characterName: this.characterName,
        classe: this.selectedClasse,
      };
      userService.createCharacters([characters]);
    },
  },
};
</script>

<style></style>
