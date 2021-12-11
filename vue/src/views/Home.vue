<template>

  <div class="home" id="home">
    <router-link to="/login" v-if="this.$store.state.currentUser">Log In</router-link>&nbsp;&nbsp;
    <router-link v-bind:to="{ name: '' }" id="invite-button"> invite </router-link>&nbsp;
    <!-- <h1 class="pagename">Home</h1> -->
    

    <DummyRestaurant />

    <div id="viewRestaurants">

      <div>
        <h1>DISPLAY RESTAURANT CARDS HERE</h1>
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
@import url('https://fonts.googleapis.com/css2?family=Leckerli+One&family=Pacifico&display=swap');

 .pagename {
   
  }


</style>