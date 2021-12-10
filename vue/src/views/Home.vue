<template>
  <div class="home" id="home">
    <router-link to="/login" v-if="this.$store.state.currentUser">Log In</router-link>&nbsp;&nbsp;
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>

    <DummyRestaurant />

    <div id="viewRestaurants">
      <div id="isLoading"> 
        add gif img link here if isLoading is true.  Will display while resturants load
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
  components: {
    DummyRestaurant
  }
}

</script>