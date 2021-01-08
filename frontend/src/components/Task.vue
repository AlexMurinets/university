<template>
    <v-card
           color="warning"
            class="mx-auto my-12"
            width="1000"
            height="120"
            elevation="5"
            dark
            @click="$router.push({ path: '/taskInfo/'+task.id})"
    > <v-card-title>
      <v-icon
        large
        left
      >
        mdi-laptop-chromebook
      </v-icon>
      <strong>{{task.name}}</strong>
    </v-card-title>
            <v-card-text><strong>
      {{task.description}}</strong>
    </v-card-text>
    </v-card>

</template>

<script>


    export default {
        name: "Task",

        props: {
            task: {
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