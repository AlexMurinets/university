<template>
    <v-app>
    <h1>Subject Info </h1>
    <h2>{{subject.name}}</h2>
        <h3>{{subject.description}}</h3>
    </v-app>
</template>

<script>
    import api from "../components/backend-api";

    export default {
        name: "SubjectInfo",

        props: ['id'],

        data(){
            return{
                subject: {},
            }
        },


        beforeCreate() {
            let id = this.$route.params.id
            api.getSubject(id).then(response => {
                this.subject = response.data;
            })
        },
    }
</script>

<style scoped>

</style>