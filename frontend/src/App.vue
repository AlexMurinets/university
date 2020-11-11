<template>
  <div id="app">
  <v-app>
    <v-app-bar app>
      <h4>Utm</h4>
      <v-spacer></v-spacer>
      <v-btn color="primary">Logout</v-btn>
    </v-app-bar>
    <NavigationDrawer app/>
        <v-content>
          <v-container fluid>
            <router-view/>
          </v-container>
        </v-content>
  </v-app>

  </div>
</template>


<script>

  import NavigationDrawer from "./components/NavigationDrawer";
  export default {
    components: {
      NavigationDrawer,
    }
  }
</script>



