<template>
  <div class ="restaurant-container">
      <restaurant-card v-bind:restaurant="restaurant" v-for="restaurant in $store.state.restaurants" v-bind:key="restaurant.id" />
      
  </div>
</template>

<script>
import RestaurantCard from './RestaurantCard.vue';

export default {
  components: { 
      RestaurantCard 
  },
}
</script>

<style>
.restaurant-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>