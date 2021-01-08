<template>
    <v-app>
    <h1>{{subject.name}}</h1>
    <v-row align="center" justify="center">
            <v-img
             max-height="450"
             max-width="850"
             center
                :src = "subject.image"
        ></v-img>
    </v-row>
        <br>
        <p>{{subject.description}}</p>
        <h3 align = center>Lessons</h3>
        <Lesson v-for="lesson in subject.lessons" :key="lesson.id" :lesson="lesson"/>
        <h3 align = center>Tasks</h3>
        <Task v-for="task in subject.tasks" :key="task.id" :task="task"/>
        <h3 align = center>Tests</h3>
        <Test v-for="test in subject.exams" :key="test.id" :test="test"/>
    </v-app>
</template>

<script>
    import api from "../components/backend-api";
    import Task from "../components/Task";
    import Lesson from "../components/Lesson";
    import Test from "../components/Test";

    export default {
        name: "SubjectInfo",

        components: {
            Task,
            Lesson, 
            Test
        },

        props: ['id'],

        data(){
            return{
                subject: {},
                tasks: [],
                lessons: [],
                tests: []
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