<template>
    <v-card
           color="primary"
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
      <strong>{{lesson.name}}</strong>
    </v-card-title>
            <v-card-text><strong>
      {{lesson.description}}</strong>
    </v-card-text>
    </v-card>

</template>

<script>


    export default {
        name: "Lesson",

        props: {
            lesson: {
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