<template>
  <body class="container">

    <div class="tender-intro">
      <h1 class="with-tender">Find your next favorite restaurant, with TEnder</h1>
      <br>
      <h2>TEnder is your solution to the eternal question: "Where are we going for dinner?"</h2>
      <h2>Browse restaurants. Pick your favorites. Send an invite to your friends so they can tell you where they do -- and don't -- want to go.</h2>
      <h2>Your new favorite spot is an invite away.</h2>
    </div>

    <form class="form-signin" @submit.prevent="login">

          <h1>Welcome to TEnder</h1>
          
          <div
            class="alert_alert"
            role="alert"
            v-if="invalidCredentials"
          >Invalid username and password!</div>

          <div
            class="alert_alert"
            role="alert"
            v-if="this.$route.query.registration"
          >Thank you for registering, please sign in.</div>
          
          <!-- THIS IS THE LOG IN FORM - USED <BR> AS A TEMP SOLUTION -->
          <input
            type="text"
            id="username"
            class="form-control"
            placeholder="Username"
            v-model="user.username"
            required
            autofocus />
          <br>
          <input
            type="password"
            id="password"
            class="form-control"
            placeholder="Password"
            v-model="user.password"
            required />
          <br>
          <button class="submit" type="submit" id="sign-in" > SIGN IN </button> 
          <br>
          <div>New to TEnder? <router-link :to="{ name: 'register' }">Sign up.</router-link></div>
          
        </form>
  </body>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          alert(error);
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>
<style>

body{
  background-color: rgb(255, 255, 235);
  display: flex;
  justify-content: space-between;
  gap: 25px;
  
  /* original color: rgba(255, 255, 221, 0.867); */
}


.tender-intro{
  order: 1;
  padding: 10px;
  flex-basis: 67%;
  color: white;
  background-image: linear-gradient(to bottom right, rgb(114, 227, 241), rgb(235, 124, 235))
  /* background-image: linear-gradient(to bottom right, rgb(241, 82, 241), rgb(254,213,50)); */
}

.with-tender {
  font-weight: 600;
  font-style: italic;
  font-size: 80px;
}

h2 {
  font-weight: 300;
}

form.form-signin{
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

</style>