<template>
<v-app>
      <v-app-bar app v-if="currentUser">
      <h4>Utm</h4>
      <v-spacer></v-spacer>
      <v-btn color="primary"
             @click="logOut"
      >
        Logout
      </v-btn>
      </v-app-bar>
      <NavigationDrawer app v-if="showUserBoard"/>
      <NavigationProfessor app v-if="showModeratorBoard"/>
      <NavigationAdmin app v-if="showAdminBoard"/>
        <v-content>
          <v-container fluid>
            <router-view/>
          </v-container>
        </v-content>
</v-app>
</template>

 
<script>
import NavigationDrawer from "./components/NavigationDrawer";
import NavigationProfessor from "./components/NavigationProfessor";
import NavigationAdmin from "./components/NavigationAdmin";
export default {
  name : 'App',
  components: {
      NavigationDrawer,
      NavigationProfessor,
      NavigationAdmin
    },
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
      showUserBoard() {
      if (this.currentUser && this.currentUser.roles) {
        return this.currentUser.roles.includes('ROLE_USER');
      }
      return false;
    },
    showAdminBoard() {
      if (this.currentUser && this.currentUser.roles) {
        return this.currentUser.roles.includes('ROLE_ADMIN');
      }
      return false;
    },
    showModeratorBoard() {
      if (this.currentUser && this.currentUser.roles) {
        return this.currentUser.roles.includes('ROLE_MODERATOR');
      }
      return false;
    }
  },
  methods: {
    logOut() {
      this.$store.dispatch('auth/logout');
      this.$router.push('/login');
    }
  }
};
</script>
