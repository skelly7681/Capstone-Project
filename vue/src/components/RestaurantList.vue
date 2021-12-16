<template>
<div>
    <div class ="restaurant-container" id="main-restaurant">
      <restaurant-card class="card" v-for="restaurant in restaurants" v-bind:key="restaurant.id"  v-bind:restaurant="restaurant" />    
    </div>

<!-- needs to be centered at the bottom of the page -->
      <div class="done-button">
          <button type="button" class="inviteForm" id="searchButton" v-if="showButton" v-on:click="finish()"> ALL DONE.</button>
      </div>     


</div>


</template>

<script>
import RestaurantCard from './RestaurantCard.vue';

export default {
  name: 'restaurant-list',
  data() {
    return{
      restaurants: [],
      showButton: false
    }
  },
  components: { 
      RestaurantCard 
  },

  computed: {
   
  },
  methods:{
    finish(){
      let linkUrl = "http://localhost:8081/vote/" + this.$store.state.currentInvite;
      window.open(linkUrl);
    }
  },
  created() {
    this.$store.subscribe(mutatation => { 
          if(mutatation.type === 'SET_SEARCH_RESULTS'){ 
            this.restaurants =  this.$store.state.searchResults;
            this.showButton = true; 

            }
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
  border-radius: 8px;
  margin: 4px;
}

.done-button {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-content: center;
}

</style>