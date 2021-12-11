// this will be the form to enter info needed to generate an invite - it will populate the home view
<template>
<div class="invitation">
    <div class="nav">
        <router-link v-bind:to="{ name: 'home' }" id="home-button"> home </router-link>&nbsp;
    </div>


    <!-- this deadline box needs to be bound to an invite to send to the db -->
    <div id="deadlineDate">
        <label for="dueDate">deadline date: </label>
        <input type="date" id="dueDate" name="dueDate" /> 
        <input type="time" id="dueTime" name="dueTime"/>
    </div>

    <!-- all imported componets here -->
    <search-restaurants/>

</div>
</template>

<script>
import SearchRestaurants from './SearchRestaurants.vue'

export default {
  components: { SearchRestaurants },
  data(){
      return{
          isLoading: true
      }
      

  },
  

}
</script>

<style>

</style>