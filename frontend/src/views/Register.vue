<template>
  <v-register>
    <v-card width="400" class="mx-auto mt-5">
      <v-card-title>
        <h1 class="display-1">Register</h1>
      </v-card-title>
      <v-card-text>
        <v-form
        @submit.prevent="handleRegister"
        id="register-form">
          <v-text-field 
          prepend-icon="mdi-account-circle"
          v-model="user.username"
          v-validate="'required|min:3|max:20'"
          type="text"
          label="username" 
          name="username"
          />
          <v-alert
            v-if="submitted && errors.has('username')"
            type="error">
            {{errors.first('username')}}
          </v-alert>
          <v-text-field 
          prepend-icon="mdi-account-circle"
          v-model="user.email"
          v-validate="'required|email|max:50'"
          type="email"
          label="email" 
          name="email"
          />
          <v-alert
            v-if="submitted && errors.has('email')"
            type="error">
            {{errors.first('email')}}
          </v-alert>

       <v-text-field           
            v-model="user.password"
            v-validate="'required|min:6|max:40'"
            :type="showPassword ? 'text' : 'password'"
            prepend-icon="mdi-lock"
            :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
            @click:append="showPassword = !showPassword"
            name="password"
            label="password" 
         />
        <v-alert
            v-if="submitted && errors.has('password')"
            type="error">
            {{errors.first('password')}}
        </v-alert>


        </v-form>
      </v-card-text>
      <v-divider></v-divider>
    <v-card-actions>
      <v-btn color="success" type="submit" form="register-form">Register</v-btn>
      <v-spacer></v-spacer>
      <v-btn color="info" @click="$router.push({ path: '/login' })">Login</v-btn>
    </v-card-actions>
    <v-alert
    v-if="message"
    :type="successful ? 'success' : 'error'"
    >{{message}}</v-alert>
    </v-card>
  </v-register>
</template>

<script>
import User from '../models/user';

export default {
  name: 'Register',
  data() {
    return {
      showPassword: false,
      user: new User('', '', ''),
      submitted: false,
      successful: false,
      message: ''
    };
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    }
  },
  mounted() {
    if (this.loggedIn) {
      this.$router.push('/profile');
    }
  },
  methods: {
    handleRegister() {
      this.message = '';
      this.submitted = true;
      this.$validator.validate().then(isValid => {
        if (isValid) {
          this.$store.dispatch('auth/register', this.user).then(
            data => {
              this.message = data.message;
              this.successful = true;
            },
            error => {
              this.message =
                (error.response && error.response.data && error.response.data.message) ||
                error.message ||
                error.toString();
              this.successful = false;
            }
          );
        }
      });
    }
  }
};
</script>