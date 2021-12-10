<template>
  <div class="home" id="home">
    <router-link to="/login" v-if="this.$store.state.currentUser">Log In</router-link>&nbsp;&nbsp;
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>

    <div id="searchbar">
      <h1>SEARCH BAR</h1>
      <input type="text" v-model="search" placeholder="Search For">
    </div>
    
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>