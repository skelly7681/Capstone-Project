<template>
  <div class ="restaurant-container">
      <restaurant-card class="card" v-for="restaurant in restaurants" v-bind:key="restaurant.id"  v-bind:restaurant="restaurant" />

  </div>
</template>

<script>
import RestaurantCard from './RestaurantCard.vue';

export default {
  name: 'restaurant-list',
  data() {
    return{
      restaurants: []
    }
  },
  components: { 
      RestaurantCard 
  },

  computed: {
   
  },

  created() {
    this.$store.subscribe(mutatation => 
      { 
          if(mutatation.type === 'SET_SEARCH_RESULTS')
            { this.restaurants =  this.$store.state.searchResults; }

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