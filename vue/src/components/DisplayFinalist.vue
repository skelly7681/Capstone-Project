
// this is what will be displayed when all selections are made -- only pulls restaurants that have not been vetoes from
//invite_restaurant table in DB.

<template>
<div>
    <router-link v-bind:to="{ name: 'home' }" id="home-button"> home </router-link>&nbsp;


    <restaurant-list/>


</div>
  
</template>

<script>
import RestaurantList from './RestaurantList.vue'
export default {
  components: { RestaurantList },
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

  },
  computed: {

  }

}
</script>

<style>

</style>