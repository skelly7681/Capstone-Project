<template>
  <body class="container">
    <div class="Master-row">
            <div class="row-3">
        <!-- insert and image here  -->
        <img src="" alt="IMAGE HERE">
      </div>
      <div class="row-1">
        <!-- insert an image here -->
        <img src="" alt="IMAGE HERE">
      </div>
      <div id="login" class="row-2">
      
        <form class="form-signin" @submit.prevent="login">
          <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
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
          <router-link :to="{ name: 'register' }">Need an account?</router-link>
          <button type="submit" id="sign-in" >Sign in</button>
        </form>
      </div>
    </div>
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
      alert("calling service");
      authService
        .login(this.user)
        .then(response => {
          alert("promise kept");
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
  background-color: plum;
}
.Master-row{
  
  height: 650px;
  border: solid;
  border-width: 10px;
  display: flex;

}

.row-1{
  order: 1;
  flex-basis: 33%;
  border: solid;
  border-width: 10px;
}

.row-2{
  order: 2;
  flex-basis: 33%;
  border: solid;
  border-width: 10px;
}

.row-3{
  order: 3;
  flex-basis: 33%;
  border: solid;
  border-width: 10px;
}


</style>