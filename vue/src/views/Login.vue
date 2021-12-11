<template>
  <body class="container">

    <div id="top-bar">
      
    </div>

    <div class="Master-row">
            <div class="row-3">
        <!-- insert and image here  -->
        <!-- <img src="https://cdn.vox-cdn.com/thumbor/SvWuEief9dPa4fwMGLa7BR8NkzA=/0x0:5472x3648/1200x800/filters:focal(2299x1387:3173x2261)/cdn.vox-cdn.com/uploads/chorus_image/image/63216998/2017.08.30_DAF_Pizza_Photos_0909.0.jpg" alt="IMAGE HERE" id="pizza"> -->
      </div>
      <div class="row-1">
        <!-- insert an image here -->
        <!-- <img src="https://external-preview.redd.it/XgYORZehSDLoH1VZb6cVwy-JX7DTNF5zgU8VpyRIJaM.jpg?auto=webp&s=1aa6c764ac6c2cf15ff4abe14a3e03791ab3e845" alt="IMAGE HERE" id="mac"> -->
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
          


          <!-- THIS IS THE LOG IN FORM - USED <BR> AS A TEMP SOLUTION -->
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
          <input
            type="password"
            id="password"
            class="form-control"
            placeholder="Password"
            v-model="user.password"
            required
          />
          <br>
          <button type="submit" id="sign-in" > Sign in </button> <br>
          <router-link :to="{ name: 'register' }"> Need an account? </router-link>
          
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

#top-bar{
  height: 80px;
  font-size: 50px;
  font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
  
  
}

body{
  background-color: #FFDD;
}
.Master-row{
  
  height: 650px;

  display: flex;
  flex-direction: row;

}

#mac{
  width: 100%;
  height: 100%;
}

#pizza{
  width: 100%;
  height: 100%;
}

.row-1{
  order: 1;
  flex-basis: 33%;

}

.row-2{
  order: 2;
  flex-basis: 33%;

}

.row-3{
  order: 3;
  flex-basis: 33%;

}

</style>