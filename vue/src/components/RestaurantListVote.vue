<template>
  <div class ="restaurant-container">
      <restaurant-card-vote class="card" v-for="restaurant in restaurants" v-bind:key="restaurant.id"  v-bind:restaurant="restaurant" />

  </div>
</template>

<script>
import RestaurantCardVote from './RestaurantCardVote.vue';

export default {
  name: 'restaurant-list-vote',
  data() {
    return{
      restaurants: []
    }
  },
  components: { 
      RestaurantCardVote 
  },

  computed: {
   
  },

  created() {
    this.$store.subscribe(mutatation => 
      { 
          if(mutatation.type === 'SET_PENDING_RESTAURANTS')
            { this.restaurants =  this.$store.state.pendingInviteRestaurants; }
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