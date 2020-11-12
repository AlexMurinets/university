<template>
  <div class="home">
    <h1>Home

    </h1>
  </div>
</template>

<script>

import api from "../components/backend-api.js";

export default {
  name: 'Home',

  data() {
    return {
      hello: [],
      errors: [],
    }
  },

  methods: {
    sayHello(){
      api.hello().then(response => {
        this.hello = response.data;
        console.log(response.data)
      })
              .catch(error => {
                this.errors.push(error)
              })
    }
  }

}
</script>
