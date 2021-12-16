<template>
<div>
  
  <div class ="restaurant-container">

     <div class="loading" v-if="isLoading">
                <img class="pizza-gif" src="../assets/loading.gif" alt="HELP!!!">
     </div>

    <restaurant-card-finalists class="card" v-for="restaurant in finalSelectionRestaurants" v-bind:key="restaurant.restaurantId"  v-bind:restaurant="restaurant" />
  </div>

    <restaurant-list-vote  v-if="noRestaurants"/>

    <body >
      
        <div class="oops-message" v-show="this.finalSelectionRestaurants.length==0">
            <h1 class="bad-news">We've got bad news!</h1>
            <br>
            <h2>For all you and your friends have in common, you can't agree on a place to eat.</h2>
            <h2>Luckily, we've got your back. You can make a new invite and pick some new restaurants you think they might love.</h2>
            <h2>Try to make them count this time.</h2>

            <div class="new-invite-button-container">
              <button type="button" class="invite-button" id="searchButton" v-on:click="createNew()"> CREATE A NEW INVITE </button>
            </div>

        </div>
    </body>

</div>
  
</template>

<script>
import RestaurantCardFinalists from './RestaurantCardFinalists';
import InviteServices from '../services/InviteServices';

export default {
  name: 'display-finalist',
  components: {
    RestaurantCardFinalists
  },
  data(){
      return{
          isLoading: true,
          finalSelectionRestaurants: [],
          noRestaurants: false,
          currentRestaurant: {
            restaurantName: ''
          }
      }
  }, 
  methods: {
      checkFinalList(){
          //if that final list is empty (all choices vetoed) then change isSelectionEmpty to true and toggle display
      }, 
      createNew(){
          this.$router.push("/invite");
        }


  }, 
  created(){

        InviteServices.getFinalistsByInviteId(this.$route.params.inviteId).then(response =>{
        this.finalSelectionRestaurants = response.data;
        if(!this.finalSelectionRestaurants?.length != 0){
          this.noRestaurants = true;
        } else {
          this.noRestaurants = false;
        }
        this.isLoading = false;
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

.restaurant-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
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

.new-invite-button-container {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-content: center;
}

.invite-button {
  width: 100px;
}

</style>