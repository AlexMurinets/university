<template>
    <v-app>
    <h1>Files</h1>
        <li v-for="file in files" :key="file.id">
            {{file.fileName}}
            <v-btn text color="warning" @click="saveFile(file.id)">Save</v-btn>
        </li>
    </v-app>
</template>


<script>
import api from "../components/backend-api.js";
    export default {
        name: "AllFiles",

        data(){
            return{
            files: [],
            saved: [],
            }
        },

        methods:{
            saveFile(fileId){
            window.open('http://localhost:9090/api/downloadFile/'+fileId);
            // api.download(fileId).then(response => {
            // this.saved = response.data;
            // })
            // console.log(fileId);
            }
        },

        beforeCreate() {
            api.getFiles().then(response => {
                this.files = response.data;
            })
        },
    }
</script>

<style scoped>

</style>