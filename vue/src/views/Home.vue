<template>
  <div class="home" id="home">
    <router-link to="/login" v-if="this.$store.state.currentUser">Log In</router-link>&nbsp;&nbsp;
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <DummyRestaurant />



  </div>
</template>

<script>
// import Restaurant from '@/components/Restuarant.vue';

import DummyRestaurant from '@/components/DummyRestaurant.vue';


export default {
  name: "home",
  components: {
    DummyRestaurant
  }
}

</script>