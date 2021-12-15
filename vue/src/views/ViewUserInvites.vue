<template>
  <div>
      <div id="generalDisplay">
        <!-- this will first display a list of user invites with a indication if it is pending or completed -->
        <!-- clicking a completed invite in the list takes them to a view that displays the finalist -->
        <!-- clicking a pending invite shows them which restaurants were selected for the invitation --> 
      </div>

      <display-finalist/>
      <open-invites/>
      <br>
      <br>
      <br>
      <restaurant-list-vote/>

      

  </div>
</template>

<script>
import DisplayFinalist from '../components/DisplayFinalist.vue'
import OpenInvites from '../components/OpenInvites'
import RestaurantListVote from '../components/RestaurantListVote.vue'

export default {
    components :{
        DisplayFinalist, 
        OpenInvites,
        RestaurantListVote
         // PendingInvitation
    }

}
</script>

<style>
        
</style>
