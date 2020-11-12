<template>
    <v-card
            class="mx-auto my-12"
            width="200"
            height="335"
            elevation="7"
    >
        <template slot="progress">
            <v-progress-linear
                    color="orange"
                    height="10"
                    indeterminate
            ></v-progress-linear>
        </template>

        <v-img
                height="150"
                :src = "subject.image"
        ></v-img>

        <v-card-title>{{subject.name}}</v-card-title>

        <v-card-text>
            <div>{{subject.description}}</div>
        </v-card-text>

        <v-divider class="mx-4"></v-divider>

        <v-card-actions>
            <v-btn
                    color="warning"
                    link
                    @click="$router.push({ path: '/subjectInfo/'+subject.id })"
            >
                Learn
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>


    export default {
        name: "Subject",

        props: {
            subject: {
                type: Object,
                default() {
                    return {}
                }
            },
        },
    }

</script>

<style scoped>

</style>