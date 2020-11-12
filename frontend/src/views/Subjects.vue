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
            subjects: [],
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