<template>

  <div class="home" id="home">
    <router-link to="/login" v-if="this.$store.state.currentUser">Log In</router-link>&nbsp;&nbsp;
    <h1 class="pagename">Home</h1>
    <p>You must be authenticated to see this</p>

    <DummyRestaurant />

    <div id="viewRestaurants">

      <div class="loading" v-if="isLoading">
        <img src="../assets/loading.gif" alt="HELP!!!">
      </div>

      <div>
        This is where resturant cards will be displayed?  Do we need to pull from the store or will these populate based on
        the search results?
      </div>
      
    </div>



  </div>
</template>

<script>
// import Restaurant from '@/components/Restuarant.vue';

import DummyRestaurant from '@/components/DummyRestaurant.vue';


export default {
  name: "home",
    data() {
    return {
      Restaurants: [],
      isLoading: true
    };
  },

  components: {
    DummyRestaurant
  }
}

</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Pacifico&display=swap');

 .pagename {
   font-family: 'pacifico';
  }


</style>