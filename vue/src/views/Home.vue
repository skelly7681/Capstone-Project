<template>
  <div class="home" id="home">
    <router-link to="/login" v-if="this.$store.state.currentUser">Log In</router-link>&nbsp;&nbsp;
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>