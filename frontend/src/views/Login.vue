
<template>
  <v-app>
    <v-card width="400" class="mx-auto mt-5">
      <v-card-title>
        <h1 class="display-1">Login</h1>
      </v-card-title>
      <v-card-text>
        <v-form
        @submit.prevent="handleLogin"
        id="login-form">
          <v-text-field 
          type="text"
          label="username" 
          prepend-icon="mdi-account-circle"
          v-model="user.username"
          v-validate="'required'"
          name="username"
          />
          <v-alert
            v-if="errors.has('username')"
            type="error">
            Username is required!
            </v-alert>
          <v-text-field 
            v-model="user.password"
            label="password"
            v-validate="'required'"
            :type="showPassword ? 'text' : 'password'"
            prepend-icon="mdi-lock"
            :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
            @click:append="showPassword = !showPassword"
            name="password"
         />
            <v-alert
            v-if="errors.has('password')"
            type="error">
            Password is required!
            </v-alert>
        </v-form>
      </v-card-text>
      <v-divider></v-divider>
    <v-card-actions>
      <v-btn color="success" @click="$router.push({ path: '/register' })">Register</v-btn>
      <v-spacer></v-spacer>
      <v-btn color="info"  :disabled="loading" type="submit" form="login-form">Login</v-btn>
    </v-card-actions>
            <v-alert
            v-if="message"
            type="error"
            >
            {{message}}
            </v-alert>
    </v-card>
  </v-app>
</template>


<script>
import User from '../models/user';

export default {
  name: 'Login',
  data() {
    return {
      showPassword: false,
      user: new User('', ''),
      loading: false,
      message: ''
    };
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    }
  },
  created() {
    if (this.loggedIn) {
      this.$router.push('/profile');
    }
  },
  methods: {
    handleLogin() {
      this.loading = true;
      this.$validator.validateAll().then(isValid => {
        if (!isValid) {
          this.loading = false;
          return;
        }

        if (this.user.username && this.user.password) {
          this.$store.dispatch('auth/login', this.user).then(
            () => {
              this.$router.push('/profile');
            },
            error => {
              this.loading = false;
              this.message =
                (error.response && error.response.data && error.response.data.message) ||
                error.message ||
                error.toString();
            }
          );
        }
      });
    }
  }
};
</script>

