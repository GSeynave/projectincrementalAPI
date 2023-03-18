<template>
    <h3>Combat</h3>
    <p v-if="this.zone && this.zone.monstres">Vous etes actuellement en train de combattre {{getMonstre()}}</p>

</template>

<script>

    export default {
        props:['user', 'zone'],
        methods: {
            getMonstre() {
                console.log("get monstre", this.zone);
                if (this.zone && this.zone.monstres) {
                    var index = Math.floor(Math.random() * this.zone.monstres.length)
                }
                return this.zone.monstres[index].nom;
            }
        }
    }
</script>

<style>

</style>
