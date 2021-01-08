<template>
    <v-card
            color="success"
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
      <strong>{{test.name}}</strong>
    </v-card-title>
            <v-card-text><strong>
      {{test.description}}</strong>
    </v-card-text>
    </v-card>

</template>

<script>


    export default {
        name: "Test",

        props: {
            test: {
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