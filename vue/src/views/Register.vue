<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <router-link :to="{ name: 'login' }">Have an account?</router-link>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
        password_length: 0,
        contains_eight_characters: false,
        contains_number: false,
        contains_uppercase: false,
        contains_lowercase: false,
        valid_password: false
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      this.contains_uppercase = /[A-Z]/.test(this.user.password);
      this.contains_lowercase = /[a-z]/.test(this.user.password);
      this.contains_number = /\d/.test(this.user.password);
      this.user.password_length = this.user.password.length;		
      if (this.user.password_length > 8) {
          this.contains_eight_characters = true;
        } else {
          this.contains_eight_characters = false;
			}
			if(this.contains_eight_characters === false){
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password is too short. Minimum length is 8 characters.';
      }
      else if(this.contains_uppercase === false){
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password is missing an uppercase letter';
      }
      else if(this.contains_lowercase === false){
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password is missing a lowercase letter.';
      }
      else if(this.contains_number === false){
              this.registrationErrors = true;
        this.registrationErrorMsg = 'Password is missing a number';
      }
      else if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      }      
      else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Username already exists, please choose another username.';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>