<template>
    <v-app>
    <h1>{{task.name}}</h1>
        <br>
        <p>{{task.description}}</p>
        <p v-if="task.grade != null">Grade: {{task.name}}</p>
        <p v-else>Not graded yet</p>
        <h3>Your solution</h3>
        <v-form
        id="singleUploadForm" 
        name="singleUploadForm"
        @submit.prevent="uploadSingleFile"
        >
            <v-file-input
                v-model="file"
                label="File input"
                outlined
                dense
            >
            </v-file-input>
            <v-btn color="success" type="submit" form="singleUploadForm">Save</v-btn>
        </v-form>
                 <!-- <form id="singleUploadForm" name="singleUploadForm">
                        <input id="singleFileUploadInput" type="file" name="file" class="file-input" required/>
                        <button type="submit" class="primary submit-btn">Submit</button>
                    </form> -->
    </v-app>
</template>

<script>
    // 'use strict';
    // var singleUploadForm = document.querySelector('#singleUploadForm');
    // var singleFileUploadInput = document.querySelector('#singleFileUploadInput');
    import api from "../components/backend-api";

    export default {
        name: "TaskInfo",


        props: ['id'],

        data(){
            return{
                file: {},
                task: {}
            }
        },

        methods:{
            
            newFile(){
                console.log(this.file);
                api.creteFile(this.file)
            },

            uploadSingleFile() {
            var formData = new FormData();
            formData.append("file", this.file);
            api.creteFile(formData)
            alert("File saved successfully")
            }

        },

        beforeCreate() {
            let id = this.$route.params.id
            api.getTask(id).then(response => {
                this.task = response.data;
            })
        },
    }
</script>

<style scoped>

</style>