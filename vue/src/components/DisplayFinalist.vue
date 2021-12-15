
// this is what will be displayed when all selections are made -- only pulls restaurants that have not been vetoes from
//invite_restaurant table in DB.

<template>
<div>
    <!-- <router-link v-bind:to="{ name: 'home' }" id="home-button"> home </router-link>&nbsp; -->
    <h1>THIS IS THE COMPONENT</h1>

    <!-- API vomit -->
    {{finalSelectionRestaurants}}


    <restaurant-list-vote/>

    <body v-if="isSelectionListEmpty">
        <div class="oops-message">
            <h1 class="bad-news">We've got bad news!</h1>
            <br>
            <h2>For all you and your friends have in common, you can't agree on a place to eat.</h2>
            <h2>Luckily, we've got your back. You can make a new invite and pick some new restaurants you think they might love.</h2>
            <h2>Try to make them count this time.</h2>
        </div>
    </body>

</div>
  
</template>

<script>
import RestaurantListVote from './RestaurantList.vue'
import InviteServices from '../services/InviteServices';

export default {
  name: 'display-finalist',
  data(){
      return{
          finalSelectionRestaurants: [],
          isSelectionListEmpty: false
      }
  }, 
  methods: {
      checkFinalList(){
          //if that final list is empty (all choices vetoed) then change isSelectionEmpty to true and toggle display
      }


  }, 
  created(){
        InviteServices.getFinalistsByInviteId(this.$route.params.inviteId).then(response =>{
        this.finalSelectionRestaurants = response.data;
        alert("checkpoint2")
    })

  },
  computed: {

  }

}
</script>

<style>

body{
  background-color: rgb(255, 255, 235);
  display: flex;
  flex-grow: 1;
  justify-content: space-between;
  gap: 25px;
}


.oops-message {
  padding: 10px;
  flex-basis: 100%;
  color: white;
  background-image: linear-gradient(to bottom right, rgb(114, 227, 241), rgb(235, 124, 235))
}

.bad-news {
  font-weight: 600;
  font-style: italic;
  font-size: 80px;
}

h2 {
  font-weight: 300;
}

</style>