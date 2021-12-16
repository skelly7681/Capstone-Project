<template>
<div>

    <div class="tender-intro" id="left-panel">
      <h1>TIME FOR YOU TO VOTE!</h1>
      <h3 class="info">You Your Part! TEnder asks you for to participate in this vital democratic process. Let's just hope your friend doesn't pick any of the options you felt meh about but thumbs-upped anyways. Good luck with that!</h3>
      <h2> make your selections by: {{this.currentInvite.closing_date}} by {{this.currentInvite.closing_time}} </h2>
    </div>

 
    <div class ="restaurant-container">
      <restaurant-card-vote class="card" v-for="restaurant in restaurants" v-bind:key="restaurant.restaurantId"  v-bind:restaurant="restaurant" />

  </div>
</div>

</template>

<script>
import RestaurantCardVote from './RestaurantCardVote.vue';
import RestaurantService from "../services/RestaurantService";
import InviteServices from '../services/InviteServices';


export default {
  name: 'restaurant-list-vote',
  data() {
    return{
      restaurants: [],
      currentInvite: {}
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
    }), 

    InviteServices.getInviteByInviteId(this.$route.params.inviteId).then(response =>{
      this.currentInvite = response.data;
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
  border-radius: 8px;
  margin: 4px;
}
</style>