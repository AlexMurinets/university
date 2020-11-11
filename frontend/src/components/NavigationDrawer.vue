<template>
    <v-navigation-drawer
            v-model="drawer"
            :mini-variant.sync="mini"
            clipped permanent app
    >
        <v-list-item class="px-2"
                     link
                     @click="$router.push({ path: '/account' })">
            <v-list-item-avatar>
                <v-img src="https://sun9-22.userapi.com/impg/9Xdgvucpm7WSQHVFbvDDaJMg8IhdaxguJGMMFA/w1-MP30zARo.jpg?size=400x0&quality=90&crop=0,0,2120,2120&sign=919d31c6f8e6ccbd014cccdc0a616c6a&ava=1"></v-img>
            </v-list-item-avatar>
            <v-list-item-title><h3>Alexei Murinets</h3></v-list-item-title>
            <v-btn
                    icon
                    @click.stop="mini = !mini"
            >
                <v-icon>mdi-chevron-left</v-icon>
            </v-btn>
        </v-list-item>

        <v-divider></v-divider>

        <v-list dense>
            <v-list-item
                    v-for="item in items"
                    :key="item.title"
                    link
                    @click="$router.push({ path: item.route })"
            >
                <v-list-item-icon>
                    <v-icon>{{ item.icon }}</v-icon>
                </v-list-item-icon>

                <v-list-item-content>
                    <v-list-item-title>{{ item.title }}</v-list-item-title>
                </v-list-item-content>
            </v-list-item>
        </v-list>
    </v-navigation-drawer>
</template>

<script>
    export default {
        data () {
            return {
                drawer: true,
                items: [
                    { title: 'Home', icon: 'mdi-home', route:'/' },
                    { title: 'Subjects', icon: 'mdi-book-open-variant', route:'/subjects' },
                    { title: 'Calendar', icon: 'mdi-calendar', route:'/calendar' },
                    { title: 'Grades', icon: 'mdi-calendar-star', route:'/grades' },
                ],
                mini: true,
            }
        },
    }
</script>