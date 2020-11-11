<template>
    <v-app>
    <h1>Subjects</h1>
    <div class="row">
        <Subject v-for="subject in subjects" :key="subject.id" :subject="subject"/>
    </div>
    </v-app>
</template>


<script>
import Subject from "../components/Subject";
import api from "../components/backend-api.js";
    export default {
        name: "Subjects",
        components: {
            Subject,
        },
        data(){
            return{
            subjects: [{'id': 1, 'name': 'math', 'description': 'pupa'}, {'id': 2, 'name': 'bd', 'description': 'pupa i lupa'}, {'id': 3, 'name': 'fav', 'description': 'pupa i lupa'}],
            }
        },

        beforeCreate() {
            api.getSubjects().then(response => {
                this.subjects = response.data;
            })
        },
    }
</script>

<style scoped>

</style>