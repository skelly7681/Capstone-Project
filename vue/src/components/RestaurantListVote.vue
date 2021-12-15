<template>
  <div class ="restaurant-container">
      <restaurant-card-vote class="card" v-for="restaurant in restaurants" v-bind:key="restaurant.id"  v-bind:restaurant="restaurant" />
      <h1>TEST</h1>
      
      <!-- API vomit -->
      {{restaurants}}

  </div>
</template>

<script>
import RestaurantCardVote from './RestaurantCardVote.vue';
import RestaurantService from "../services/RestaurantService";

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
    RestaurantService.getAllRestaurantsByInviteId(this.$route.params.inviteId).then(response =>{
        this.restaurants = response.data;
        alert("checkpoint1")
    })
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