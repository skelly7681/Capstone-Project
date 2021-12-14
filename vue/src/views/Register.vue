<template>
  <!-- <div id="register" class="text-center"> -->
  <body class="container">

    <div class="tender-intro2" id="left-panel">
      <h1 class="with-tender">Find your next favorite restaurant, with TEnder</h1>
      <br>
      <h2>TEnder is your solution to the eternal question: "Where are we going for dinner?"</h2>
      <h2>Browse restaurants. Pick your favorites. Send an invite to your friends so they can tell you where they do -- and don't -- want to go.</h2>
      <h2>Your new favorite spot is an invite away.</h2>
    </div>
    
    <form class="form-register" id="right-panel" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Your Account</h1>
      <br>
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
      <br>
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <br>
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <br>
      <br>
      <button class="submit" type="submit"> SIGN UP </button>
      <br>
      <div>Already have an account? <router-link :to="{ name: 'login' }">Sign in.</router-link></div>
    </form>

  </body>
  <!-- </div> -->
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

<style>

body{
  background-color: rgb(255, 255, 235);
  display: flex;
  flex-grow: 1;
  justify-content: space-between;
  gap: 25px;
  
  /* original color: rgba(255, 255, 221, 0.867); */
}

.tender-intro2{
  order: 1;
  padding: 10px;
  flex-basis: 67%;
  color: white;
  background-image: linear-gradient(to bottom right, rgb(235, 124, 235), rgb(114, 227, 241))
  /* background-image: linear-gradient(to bottom right, rgb(241, 82, 241), rgb(254,213,50)); */
}

.with-tender {
  font-weight: 600;
  font-style: italic;
  font-size: 80px;
}

h1 {
  text-align: center;
}

h2 {
  font-weight: 300;
}

form.form-register {
  order: 2;
  flex-basis: 33%;
  justify-content: center;
  display: flex;
  flex-direction: column;
  align-items: center;
}

input.form-control {
  width: 80%;
  padding: 10px 15px;
  border: 3px solid lightgray;
  border-radius: 10px;
  font-size: 16px;
}

input.form-control:focus {
  border: 3px solid black;
}

button.submit {
  border: none;
  background-color: rgb(243, 214, 243);
  font-size: 20px;
  border-radius: 25px;
  width: 250px;
  padding: 12px 32px;
}

button.submit:hover {
  background-color: plum;
  color: white;
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
}


/* SCREEN DIFFERENCES */

@media screen and (max-width: 400px) {

  body {
      display:flex;
      flex-direction: column;
    }

  .with-tender {
    font-weight: 600;
    font-style: italic;
    font-size: 30px;
  }
    
}

@media screen and (max-width: 800px) and (min-width: 400px) {

  body {
    display:flex;
    flex-direction: column;
  }

  .with-tender {
  font-weight: 600;
  font-style: italic;
  font-size: 50px;
}

}

</style>