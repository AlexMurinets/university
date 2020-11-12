<template>
  <div id="app">
  <v-app>
    <v-app-bar app v-if="isAuthenticated">
      <h4>Utm</h4>
      <v-spacer></v-spacer>
      <v-btn color="primary"
             :disabled="!isAuthenticated"
             v-if="isAuthenticated"
             @click="userSignOut"
      >
        Logout
      </v-btn>
    </v-app-bar>

    <NavigationDrawer app v-if="isAuthenticated"> </NavigationDrawer>
        <v-content>
          <v-container fluid>
            <router-view/>
          </v-container>
        </v-content>
  </v-app>

  </div>
</template>


<script>


  import EventBus from './event-bus';
  import NavigationDrawer from "./components/NavigationDrawer";
  export default {
    name : 'App',
    components: {
      NavigationDrawer,
    },
    data() {
      return {
        isAuthenticated: false,
      };
    },
    created() {
      this.isAuthenticated = localStorage.getItem('auth');
      // Use localstorage because isAuthenticated from $store is undefined when event is called
      EventBus.$on('authenticated', () => {
        this.isAuthenticated = localStorage.getItem('auth');
      });
    },
    beforeDestroy() {
      EventBus.$off('authenticated');
    },
    methods: {
      userSignOut() {
        this.$store.dispatch('userSignOut');
      },
    },
  };
</script>





