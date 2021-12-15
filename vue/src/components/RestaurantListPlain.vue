<template>
  <div class ="restaurant-container">
      <restaurant-card-plain class="card" v-for="restaurant in restaurants" v-bind:key="restaurant.id"  v-bind:restaurant="restaurant" />

  </div>
</template>

<script>
import RestaurantCardPlain from './RestaurantCardPlain.vue';

export default {
  name: 'restaurant-list-plain',
  data() {
    return{
      restaurants: []
    }
  },
  components: { 
      RestaurantCardPlain
  },

  computed: {
   
  },

  created() {
    this.$store.subscribe(mutatation => 
      { 
        //   if(mutatation.type === 'SET_SEARCH_RESULTS')
        //     { this.restaurants =  this.$store.state.searchResults; }

         }
      )
  }
}
</script>

<style>
.restaurant-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}

.card {
  display: inline-block;
  border: 2px solid purple;
  border-radius: 8px;
  margin: 4px;
}
</style>